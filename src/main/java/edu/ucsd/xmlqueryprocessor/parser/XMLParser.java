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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class XMLParser {

    public static Set<Node> getNodeByNameNextLevel(Node root, String targetNodeName) {
        Set<Node> results = new LinkedHashSet<>();
        for (int i = 0; i < root.getChildNodes().getLength(); i++) {
            Node node = root.getChildNodes().item(i);
            if (targetNodeName.equals(node.getNodeName())) {
                results.add(node);
            }
        }
        return results;
    }

    public static Set<Node> getNodeByNameAllLevels(Node root, String targetNodeName) {
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

    public static void dumpDocument(Document document, String filePath) {
        try {
            // Write the content into XML file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty("indent", "yes");
            transformer.setOutputProperty("standalone", "yes");
            transformer.setOutputProperty("omit-xml-declaration", "yes");
            transformer.setOutputProperty("{https://xml.apache.org/xslt}indent-amount", "4");
            DOMSource source = new DOMSource(document);
            StreamResult streamResult = new StreamResult(filePath);
            transformer.transform(source, streamResult);

            // Remove empty lines
            Path outputFilePath = Paths.get(filePath);
            String content = new String(Files.readAllBytes(outputFilePath));
            content = content.replaceAll("(?m)^[ \t]*\r?\n", "");
            Files.write(outputFilePath, content.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}