package edu.ucsd.xmlqueryprocessor;

import edu.ucsd.xmlqueryprocessor.engine.XPathEngine;

import java.nio.file.Files;
import java.nio.file.Paths;
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
        XPathEngine xpathEngine = new XPathEngine(FILE_DIRECTORY, OUTPUT_FILE_DIRECTORY);
        readProcessQueries(xpathEngine, QUERY_FILE_DIRECTORY);
    }

    private static void readProcessQueries(XPathEngine engine, String queryFilePath) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(queryFilePath));
            int queryCounter = 0;
            for (String query : lines) {
                queryCounter++;
                if (queryCounter > 10) {
                    continue;
                }
                System.out.println("SAMPLE QUERY " + queryCounter + ":\t" + "SAMPLE_QUERY_" + queryCounter);
                engine.evaluate(query, "result" + queryCounter + ".xml");
                System.out.println("--------------------------------------------------------------------------------");
                System.out.println("--------------------------------------------------------------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}