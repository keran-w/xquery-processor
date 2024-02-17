package edu.ucsd.xmlqueryprocessor.parser;


import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.util.*;

public class XMLParser {

    public static Set<Node> getByNodeNameHelper(Node root, String targetNodeName) {
        Set<Node> results = new LinkedHashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (targetNodeName.equals(node.getNodeName())) {
                results.add(node);
            }

            for (int i = 0; i < node.getChildNodes().getLength(); i++) {
                queue.add(node.getChildNodes().item(i));
            }
        }
        return results;
    }

    public static Document getByNodeName(Document document, String targetNodeName) {
        try {
            if (document == null) {
                return null;
            }
            Node root = document.getDocumentElement();
            Set<Node> results = getByNodeNameHelper(root, targetNodeName);
            return convertResultsToDOM(results);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Set<Node> processEquality(Document document, String left, String target, boolean inequalityFlag) {
        System.out.println("Processing equality: " + left + " = " + target);

        try {
            Node root = document.getDocumentElement();
            Set<Node> results = new LinkedHashSet<>();
            for (int i = 0; i < root.getChildNodes().getLength(); i++) {
                Node node = root.getChildNodes().item(i);
                String tagName = node.getNodeName();

                List<String> nodeNameList = new ArrayList<>();
                for (Node n : getByNodeNameHelper(node, left)) {
                    nodeNameList.add(n.getTextContent());
                }

                if (nodeNameList.contains(target) ^ inequalityFlag) {
                    System.out.println("\t\tFound a match: " + node);
                    results.add(node);
                }
            }
            return results;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Document convertResultsToDOM(Set<Node> results) throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();
        Node root = document.createElement("RESULT");
        document.appendChild(root);

        for (Node node : results) {
            Node importedNode = document.importNode(node, true);
            root.appendChild(importedNode);
        }
        return document;
    }

    public static void dumpDocument(Document document, String filePath) {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty("omit-xml-declaration", "yes");
            DOMSource source = new DOMSource(document);
            StreamResult streamResult = new StreamResult(filePath);
            transformer.transform(source, streamResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Document parseXML(String filePath) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(filePath);
            document.getDocumentElement().normalize();
            return document;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}