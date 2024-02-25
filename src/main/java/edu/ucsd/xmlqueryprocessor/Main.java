package edu.ucsd.xmlqueryprocessor;

import edu.ucsd.xmlqueryprocessor.engine.XPathEngine;
import edu.ucsd.xmlqueryprocessor.engine.XQueryEngine;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java Main <QUERY_FILE_DIRECTORY> <OUTPUT_FILE_DIRECTORY>");
            return;
        }

        String FILE_DIRECTORY = "data/";
        String QUERY_FILE_DIRECTORY = args[0];
        String OUTPUT_FILE_DIRECTORY = args[1];
//        String QUERY_FILE_DIRECTORY = "input/m1-test.txt";
//        String OUTPUT_FILE_DIRECTORY = "m1-output/";
        String mission = args[2];
        switch (mission) {
            case "1":
                // XPath
                XPathEngine xpathEngine = new XPathEngine(FILE_DIRECTORY, OUTPUT_FILE_DIRECTORY);
                readProcessXPaths(xpathEngine, QUERY_FILE_DIRECTORY);
            case "2":
                // XQuery
                XQueryEngine xqueryEngine = new XQueryEngine(FILE_DIRECTORY, OUTPUT_FILE_DIRECTORY);
                readProcessXQueries(xqueryEngine, OUTPUT_FILE_DIRECTORY);
        }
    }

    private static void readProcessXPaths(XPathEngine engine, String queryFilePath) {
        try {
            List < String > lines = Files.readAllLines(Paths.get(queryFilePath));
            int queryCounter = 0;
            for (String query: lines) {
                queryCounter++;

                System.out.println("SAMPLE QUERY " + queryCounter + ":\t" + "SAMPLE_QUERY_" + queryCounter);
                engine.evaluate(query, "result" + queryCounter + ".xml");
                System.out.println("--------------------------------------------------------------------------------");
                System.out.println("--------------------------------------------------------------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void readProcessXQueries(XQueryEngine engine, String queryFilePath) {
        ArrayList<String> queries = new ArrayList<>();
        try {
            queries = new ArrayList<>(Files.readAllLines(Paths.get(queryFilePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < queries.size(); i++) {
            System.out.println("Testing query " + (i + 1));
            System.out.println("Processing query: \n" + queries.get(i));
            try {
                engine.evaluate(queries.get(i), "result" + (i + 1) + ".xml");
                System.out.println("Successfully processed query " + (i + 1) + "!");
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("--------------------------------------------------------------------------------");
            System.out.println("--------------------------------------------------------------------------------");
        }
    }
}