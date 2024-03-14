package edu.ucsd.xmlqueryprocessor.engine;

import edu.ucsd.xmlqueryprocessor.parser.XQueryRewriterParser;
import org.antlr.v4.runtime.tree.ParseTree;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static edu.ucsd.xmlqueryprocessor.engine.XPathEngine.createSet;
import static edu.ucsd.xmlqueryprocessor.parser.XMLParser.dumpDocument;
import static edu.ucsd.xmlqueryprocessor.util.Constants.*;

import edu.ucsd.xmlqueryprocessor.engine.DisjointSet;

public class XQueryRewriter {
    private final String outputDirectory;
    private final XPathEngine xpathEngine;
    XQueryRewriterParser parser;
    private Document document;

    public XQueryRewriter(String fileDirectory, String outputDirectory) {
        this.outputDirectory = outputDirectory;
        xpathEngine = new XPathEngine(fileDirectory);
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            document = builder.newDocument();
        } catch (Exception ignored) {
        }
    }

    public static void main(String[] args) throws IOException {
        String QUERY_FILE_DIRECTORY = "input/m3/query4.txt";
        String OUTPUT_FILE_DIRECTORY = "m3-rewrite/";
        String query = null;

        try {
            // read the file content into the string
            query = new String(Files.readAllBytes(Paths.get(QUERY_FILE_DIRECTORY)));
            // eliminate all return and new line
            // query = content.replace("\n", "").replace("\r", "");
            // System.out.println("Processing query: \n" + query);
        } catch (IOException e) {
            e.printStackTrace();
        }

        XQueryRewriter rewriter = new XQueryRewriter("data/", OUTPUT_FILE_DIRECTORY);
        try {
            rewriter.rewrite(query, "result.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * Decorator function to print out the name of the node being processed
     */
    private Map<String, List<Object>> getChildren(ParseTree tree, String name) {
        System.out.println("Processing " + name + ": " + tree.getText());
        Map<String, List<Object>> children = parser.getChildren(tree);
        System.out.println("\tChildren key set: " + children.keySet());
        for (String key : children.keySet()) {
            if (Objects.equals(key, "otherChildren")) {
                System.out.println("\t\t" + key + ": " + children.get(key));
            } else {
                for (Object child : children.get(key)) {
                    System.out.println("\t\t" + key + ": " + ((ParseTree) child).getText());
                }
            }
        }

        return children;
    }

    public void rewrite(String query, String outputFileName) {
        // interpret query into ParseTree
        System.out.println("Processing query: \n" + query);
        parser = new XQueryRewriterParser(query);
        ParseTree tree = parser.getTree();

        processXQuery(tree, new HashMap<>());

        String outputFilePath = outputDirectory + outputFileName;
        // write into outputFilePath
    }


    public void processXQuery(ParseTree tree, HashMap<String, Node> varHashMap) {
        Map<String, List<Object>> children = parser.getChildren(tree);

        // TODO: any other syntax?
        // Default: for clause, where clause, return clause
        HashMap<String, String> parent = new HashMap<>();
        HashMap<String, Set<String>> map = new HashMap<>();
        System.out.println("===== For Clause =====");
        processForClause((ParseTree) children.get(KEY_FOR_CLAUSE).get(0), parent, map);

        List<List<String>> paris = null;
        if (children.containsKey(KEY_WHERE_CLAUSE)) {
            paris = processWhereClause((ParseTree) children.get(KEY_WHERE_CLAUSE).get(0), parent, map);
            System.out.println("===== Where Clause =====");
            System.out.println("Parent Map: " + parent);
            System.out.println("Disjoint Set: " + map);
            System.out.println("Pairs: " + paris);
        }

        ParseTree returnClause = (ParseTree) children.get(KEY_RETURN_CLAUSE).get(0);
        System.out.println("Processing return clause: " + returnClause.getText());
        System.out.println("===== Return Clause =====");
        processReturnClause(tree, parent, map, paris);
    }

    public void processForClause(ParseTree tree, HashMap<String, String> parent, HashMap<String, Set<String>> map) {
        System.out.println("Processing for clause: " + tree.getText());
        int childCount = tree.getChildCount();
        String varName;
        ParseTree xquery;
        ParseTree forClause;
        switch (childCount) {
            case 4:
                // 'for' var 'in' xquery
                // no nested FLWR expressions -> first for query, xquery should be absolute path
                varName = tree.getChild(1).getText();
                xquery = tree.getChild(3);
                processInStatement(varName, xquery, parent, map);
                System.out.println("Parent Map: " + parent);
                System.out.println("Disjoint Set: " + map);
                return;
            case 5:
                // forClause ',' var 'in' xquery
                forClause = tree.getChild(0);
                processForClause(forClause, parent, map);
                varName = tree.getChild(2).getText();
                xquery = tree.getChild(4);
                processInStatement(varName, xquery, parent, map);
                System.out.println("Parent Map: " + parent);
                System.out.println("Disjoint Set: " + map);
                return;
            default:
                throw new IllegalArgumentException("processForClause: invalid child count");
        }
    }

    public void processInStatement(String varName, ParseTree xquery, HashMap<String, String> parent, HashMap<String, Set<String>> map) {
        int childCount = xquery.getChildCount();
        String parentName;

        if (childCount == 3) {
            // xquery: var / relativePath
            parentName = xquery.getChild(0).getText();

            // {var: parent}
            parent.put(varName, parentName);
            map.get(parentName).add(varName + " in " + xquery.getText());

        } else {
            // xquery: absolutePath
            parent.put(varName, varName);   // its parent is itself

            Set<String> group = new LinkedHashSet<>();   // store in sequence
            group.add(varName + " in " + xquery.getText());
            map.put(varName, group);
        }
    }

    public List<List<String>> processWhereClause(ParseTree tree, HashMap<String, String> parent, HashMap<String, Set<String>> map) {
        // 'where' cond
        System.out.println("Processing where clause: " + tree.getText());
        ParseTree cond = tree.getChild(1);
        return processCond(cond, parent, map);
    }

    public List<List<String>> processCond(ParseTree tree, HashMap<String, String> parent, HashMap<String, Set<String>> map) {
        ParseTree left = tree.getChild(0);
        ParseTree right = tree.getChild(2);
        String op = tree.getChild(1).getText();
        List<List<String>> pairs = new ArrayList<>();

        switch (op) {
            case "and":
                // cond 'and' cond
                List<List<String>> list1 = processCond(left, parent, map);
                List<List<String>> list2 = processCond(right, parent, map);
                list1.addAll(list2);
                return list1;
            case "=":
            case "eq":
                // xquery '='/'eq' xquery
                Map<String, List<Object>> leftChildren = parser.getChildren(left);
                Map<String, List<Object>> rightChildren = parser.getChildren(right);
                if (leftChildren.containsKey(KEY_VAR) && rightChildren.containsKey(KEY_VAR)) {
                    // var op var
                    String leftVar = left.getText();
                    String rightVar = right.getText();

                    // check their group
                    if (! parent.get(leftVar).equals(parent.get(rightVar))) {
                        // not in the same group
                        pairs.add(Arrays.asList(leftVar, rightVar));
                    } else {
                        // same group
                        String varParent = parent.get(left.getText());
                        map.get(varParent).add(left.getText() + " eq " + right.getText());    // Xquery, 'eq'
                    }
                } else {
                    // var op constant
                    String varParent = parent.get(left.getText());
                    map.get(varParent).add(left.getText() + " eq " + right.getText());    // Xquery, 'eq'
                }
        }
        return pairs;
    }

    public void processReturnClause(ParseTree tree, HashMap<String, String> parent, HashMap<String, Set<String>> map, List<List<String>> pairs) {
        // join the pairs
        map.forEach((variable, expressions) -> {
            System.out.println(generateTuple(expressions));
        });
        System.out.println(sortPairs(pairs));
        System.out.println(processJoin(parent, map, pairs));
    }

    public String generateTuple(Set<String> expressions) {
        StringBuilder builder = new StringBuilder();
        Set<String> varNames = new LinkedHashSet<>();
        final boolean[] flag = new boolean[3];
        builder.append("for ");

        flag[0] = true;   // check first for
        flag[1] = true;   // check first cond
        flag[2] = true;   // check first return
        expressions.forEach(expression -> {
            if (expression.contains("in")) {
                // for clause
                if (flag[0]) {
                    // first for
                    builder.append(expression);
                    flag[0] = false;
                } else {
                    builder.append(",\n").append(expression);
                }
                String varName = expression.split(" ")[0];
                varNames.add(varName);
            } else {
                // condition clause
                builder.append("\n");
                if (flag[1]) {
                    // first condition
                    builder.append("where ").append(expression);
                } else {
                    builder.append(" and").append(expression);
                }
            }
        });

        // System.out.println(varNames);
        // Return
        builder.append("\nreturn <tuple>\n");
        varNames.forEach(var -> {
            if (flag[2]) {
                builder.append("\t<").append(var.substring(1)).append("> {").append(var).append("} </").append(var.substring(1)).append(">");
                flag[2] = false;
            } else {
                builder.append(",\n").append("\t<").append(var.substring(1)).append("> {").append(var).append("} </").append(var.substring(1)).append(">");
            }
        });

        builder.append("\n</tuple>\n");

        return builder.toString();
    }

    // (1, 2), (3, 4), (1, 3), (2, 4)
    // (1, 2), (1, 3), (2, 3), (1, 4)
    // (1, 2), 5
    // join( join(1,2), 5 )
    // join (5, join(1,2) )
    // where -> null

    // (1,2), (3, 4)
    // join( join(1,2), join(3, 4), [], [] )

    // parent group (map key): 1, 2, ..., 6, 7
    // pairs: [(1,2), (3,4), (1,5)] -> [(1,2,5), (3,4), 6, 7]

    // disjoint, 判断parent走没走过，再看怎么join

    // TODO: sort the paris
    public List<Set<String>> sortPairs(List<List<String>> pairs) {
        List<Set<String>> sortedPairs = new ArrayList<>();
        DisjointSet ds = new DisjointSet();

        // union all edges
        for (List<String> pair : pairs) {
            ds.union(pair.get(0), pair.get(1));
        }

        // collect disjoint set
        Map<String, Set<String>> disjointSets = new HashMap<>();
        for (List<String> pair: pairs) {
            for (String var : pair) {
                String root = ds.find(var);
                disjointSets.putIfAbsent(root, new HashSet<>());
                disjointSets.get(root).add(var);
            }
        }

        sortedPairs.addAll(disjointSets.values());

        return sortedPairs;
    }


    // TODO: join the pairs

    public String processJoin(HashMap<String, String> parent, HashMap<String, Set<String>> map, List<List<String>> pairs) {
        // build graph
        Map<String, Set<String>> ajList = new HashMap<>();   // adjacency list
        Set<String> join_group = new HashSet<>();
        for (List<String> pair : pairs) {
            // 对于无向图，需要在两个方向上都添加边
            ajList.computeIfAbsent(pair.get(0), k -> new HashSet<>()).add(pair.get(1));
            ajList.computeIfAbsent(pair.get(1), k -> new HashSet<>()).add(pair.get(0));
            join_group.add(parent.get(pair.get(0)));
            join_group.add(parent.get(pair.get(1)));
        }

        List<Set<String>> ds = sortPairs(pairs);
        Set<String> diff = new HashSet<>(map.keySet());
        // find single node
        diff.removeAll(join_group);
        for (String node : diff) {
            Set<String> single = new HashSet<>();
            single.add(node);
            ds.add(single);
        }

        System.out.println("===== Process Join =====");
        String res = "";
        // System.out.println("for $tuple in ");
        for (Set<String> sub_ds : ds) {
            List<String> sub_ds_l = new ArrayList<>(sub_ds);
            if (res.isEmpty()) {
                res = join(sub_ds_l, ajList, parent, map);
            } else {
                String s = join(sub_ds_l, ajList, parent, map);
                res = "join(" + res + "," + s + ", [], [])";
            }
            // System.out.println(join(sub_ds_l, ajList, parent, map));
        }

        res = "for $tuple in " + res;
        return res;
    }

    // BFS join connected graph
    public String join(List<String> nodes, Map<String, Set<String>> ajList, HashMap<String, String> parent, HashMap<String, Set<String>> map) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        String start = nodes.get(0);
        String parentName = parent.get(start);
        String res = generateTuple(map.get(parentName));
        String s;
        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            String curr = queue.poll();

            for (String nb : ajList.get(curr)) {
                if (!visited.contains(nb)) {
                    visited.add(nb);
                    queue.add(nb);
                    parentName = parent.get(nb);
                    s = generateTuple(map.get(parentName));
                    res = "join(" + res + "," + s + ", [" + curr.substring(1) + "]" + ", [" + nb.substring(1) + "]" + ")";
                }
            }
        }

        return res;
    }

    // (a1, a2), (a3, a4), (a1, a3)
    // join(join(join(a1,a2), a3), a4)
}
