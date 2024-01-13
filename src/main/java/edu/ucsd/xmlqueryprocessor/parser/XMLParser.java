package edu.ucsd.xmlqueryprocessor.parser;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;
import org.w3c.dom.Document;

public class XMLParser {

    public static void main(String[] args) {
        XMLParser xmlParser = new XMLParser();
        Document document = xmlParser.parseXML("/Users/keranwang/Desktop/Winter 24/CSE 232B/project/xquery-processor/j_caesar.xml");
        System.out.println(printDocument(document));
    }

    public static String printDocument(Document doc) {
        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();
            StringWriter writer = new StringWriter();
            transformer.transform(new DOMSource(doc), new StreamResult(writer));

            // The XML string
            return writer.getBuffer().toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Document parseXML(String filePath) {
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