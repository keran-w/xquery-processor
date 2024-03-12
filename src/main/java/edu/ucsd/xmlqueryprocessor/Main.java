package edu.ucsd.xmlqueryprocessor;

import edu.ucsd.xmlqueryprocessor.engine.XPathEngine;
import edu.ucsd.xmlqueryprocessor.engine.XQueryEngine;
import edu.ucsd.xmlqueryprocessor.util.FileComparer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        int milestone = 2;
        int start = 1;
        int queryCount = 20;

        System.out.println("--------------------------------------------------------------------------------");
        for (int index = start; index < start + queryCount; index++) {
            try {
                String outputDir = String.format("output/test%d/", milestone);
                Path outputPath = Paths.get(outputDir);
                XQueryEngine engine = new XQueryEngine("data/", outputDir);
                if (!Files.exists(outputPath)) {
                    Files.createDirectory(outputPath);
                }

                String query = null;
                Path inputFilepath = null;

                switch (milestone) {
                    case 1:
                        inputFilepath = Paths.get(String.format("input/m%d/m%d-test.txt", milestone, milestone));
                        query = Files.readAllLines(inputFilepath).get(index - 1);
                        break;
                    case 2:
                        inputFilepath = Paths.get(String.format("input/m%d/query%d.txt", milestone, index));
                        query = Files.readString(inputFilepath);
                        break;
                    case 3:
                        inputFilepath = Paths.get(String.format("input/m%d-rewrite/query%d.txt", milestone, index));
                        query = Files.readString(inputFilepath);
                        break;
                }

                if (query == null) {
                    break;
                }
                System.out.println("Processing query " + index);


                String outputFilename = String.format("result%d.xml", index);
                String outputFilepath = String.format("output/test%d/%s", milestone, outputFilename);
                String testFilepath = String.format("output/m%d/%s", milestone, outputFilename);

                System.out.println("Input file: " + inputFilepath);
                System.out.println("Output file: " + outputFilepath);
                System.out.println("Test file: " + testFilepath);

                // measure time in seconds taken
                long startTime = System.currentTimeMillis();
                engine.evaluate(query, outputFilename);
                long endTime = System.currentTimeMillis();
                System.out.println("Time taken: " + (endTime - startTime) / 1000.0 + " seconds");

                System.out.printf("Successfully processed query %d!%n", index);
                try {
                    FileComparer.compareFiles(
                            String.format("output/test%d/result%d.xml", milestone, index),
                            String.format("output/m%d/result%d.xml", milestone, index)
                    );
                } catch (Exception ignored) {
                }
                System.out.println("--------------------------------------------------------------------------------");
            } catch (Exception ignored) {
                // ignored.printStackTrace();
                break;
            }
        }
    }


    /*public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Usage: java Main <QUERY_FILE_DIRECTORY> <OUTPUT_FILE_DIRECTORY> <ENGINE_MODE>");
            return;
        }

        String FILE_DIRECTORY = "data/";
        String QUERY_FILE_DIRECTORY = args[0];
        String OUTPUT_FILE_DIRECTORY = args[1];
//        String QUERY_FILE_DIRECTORY = "input/m1-test.txt";
//        String OUTPUT_FILE_DIRECTORY = "m1-output/";
        String mission = args[2];
        System.out.println("Mission: " + mission);
        switch (mission) {
            case "1":
                // XPath
                XPathEngine xpathEngine = new XPathEngine(FILE_DIRECTORY, OUTPUT_FILE_DIRECTORY);
                readProcessXPaths(xpathEngine, QUERY_FILE_DIRECTORY);
                break;
            case "2":
                // XQuery
                readProcessXQueries(FILE_DIRECTORY, OUTPUT_FILE_DIRECTORY, QUERY_FILE_DIRECTORY);
        }
    }*/

    private static void readProcessXPaths(XPathEngine engine, String queryFilePath) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(queryFilePath));
            int queryCounter = 0;
            for (String query : lines) {
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

    private static void readProcessXQueries(String FILE_DIRECTORY, String OUTPUT_FILE_DIRECTORY, String queryFilePath) {

        ArrayList<String> queries = new ArrayList<>();
        try {
            System.out.println("Reading queries from " + queryFilePath);
            queries = new ArrayList<>(Files.readAllLines(Paths.get(queryFilePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < queries.size(); i++) {
            System.out.println("Testing query " + (i + 1));
            System.out.println("Processing query: \n" + queries.get(i));
            XQueryEngine engine = new XQueryEngine(FILE_DIRECTORY, OUTPUT_FILE_DIRECTORY);
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