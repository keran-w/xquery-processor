package edu.ucsd.xmlqueryprocessor.util;

import org.antlr.v4.runtime.misc.Utils;
import org.antlr.v4.runtime.tree.Tree;
import org.antlr.v4.runtime.tree.Trees;

import java.util.List;

public class TreeUtil {
    /*
     * https://stackoverflow.com/questions/50064110/antlr4-java-pretty-print-parse-
     * tree-to-stdout
     */

    /**
     * Platform dependent end-of-line marker
     */
    public static final String EOL = System.lineSeparator();
    /**
     * The literal indent char(s) used for pretty-printing
     */
    public static final String INDENTS = "  ";
    private static int level;

    private TreeUtil() {
    }

    /**
     * Pretty print out a whole tree. {@link #getNodeText} is used on the node
     * payloads to get the text
     * for the nodes. (Derived from Trees.toStringTree(....))
     */
    public static String toPrettyTree(final Tree t, final List<String> ruleNames) {
        level = 0;
        return process(t, ruleNames).replaceAll("(?m)^\\s+$", "").replaceAll("\\r?\\n\\r?\\n", EOL);
    }

    private static String process(final Tree t, final List<String> ruleNames) {
        if (t.getChildCount() == 0) {
            return Utils.escapeWhitespace(Trees.getNodeText(t, ruleNames), false);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(lead(level));
        level++;
        String s = Utils.escapeWhitespace(Trees.getNodeText(t, ruleNames), false);
        sb.append(s).append(' ');
        for (int i = 0; i < t.getChildCount(); i++) {
            sb.append(process(t.getChild(i), ruleNames));
        }
        level--;
        sb.append(lead(level));
        return sb.toString();
    }

    private static String lead(int level) {
        StringBuilder sb = new StringBuilder();
        if (level > 0) {
            sb.append(EOL);
            for (int cnt = 0; cnt < level; cnt++) {
                sb.append(INDENTS);
            }
        }
        return sb.toString();
    }
}