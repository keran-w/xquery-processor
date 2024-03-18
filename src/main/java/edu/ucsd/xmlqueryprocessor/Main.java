package edu.ucsd.xmlqueryprocessor;

import edu.ucsd.xmlqueryprocessor.engine.XQueryEngine;
import edu.ucsd.xmlqueryprocessor.engine.XQueryRewriter;
import edu.ucsd.xmlqueryprocessor.util.FileComparer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {


    public static void main(String[] args) throws IOException {

        if (args.length < 4) {
            System.out.println("Usage: java Main <QUERY_FILE_DIRECTORY> <OUTPUT_FILE_DIRECTORY> <MILESTONE> <QUERY_INDEX>");
            return;
        }
        String inputFileDirectory = args[0];
        String outputFileDirectory = args[1];
        int milestone = Integer.parseInt(args[2]);
        int index = Integer.parseInt(args[3]);

        int ifCompare = args.length > 4 ? Integer.parseInt(args[4]) : 0;
        processQuery(inputFileDirectory, outputFileDirectory, milestone, index, ifCompare);

        // String inputFileDirectory = "input/";
        // String outputFileDirectory = "output/";

//        for (int milestone = 1; milestone <= 3; milestone++) {
//            for (int index = 1; index <= 20; index++) {
//                try
//                {
//                    processQuery(inputFileDirectory, outputFileDirectory, milestone, index);
//                }
//                catch (Exception e)
//                {
//                    // System.out.println("Error processing query " + index + " for milestone " + milestone);
//                    // e.printStackTrace();
//                    break;
//                }
//            }
//        }
    }

    private static void processQuery(String inputFileDirectory, String outputFileDirectory, int milestone, int index, int ifCompare) throws IOException {
        String outputDir = String.format(outputFileDirectory + "m%d/", milestone);
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
                XQueryRewriter rewriter = new XQueryRewriter();
                Path originalQueryPath = Paths.get(String.format("input/m%d/query%d.txt", milestone, index));
                inputFilepath = Paths.get(String.format("input/m%d-rewrite/query%d.txt", milestone, index));
                rewriter.rewrite(originalQueryPath, inputFilepath);
                query = Files.readString(inputFilepath);
                break;
        }

        System.out.println("Processing Milestone " + milestone + " Query " + index);

        String outputFilename = String.format("result%d.xml", index);
        String outputFilepath = String.format("output/m%d/%s", milestone, outputFilename);
        // String testFilepath = String.format("output/m%d/%s", milestone, outputFilename);

        System.out.println("Input file: " + inputFilepath);
        System.out.println("Output file: " + outputFilepath);
        // System.out.println("Test file: " + testFilepath);

        // measure time in seconds taken
        long startTime = System.currentTimeMillis();
        engine.evaluate(query, outputFilename);
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken: " + (endTime - startTime) / 1000.0 + " seconds");

        System.out.printf("Successfully processed query %d!%n", index);
        try {
            if (ifCompare == 1) {
                System.out.println("Comparing files " + String.format("output/m%d/result%d.xml", milestone, index) + " and " + String.format("test-output/m%d/result%d.xml", milestone, index));
                FileComparer.compareFiles(
                        String.format("output/m%d/result%d.xml", milestone, index),
                        String.format("test-output/m%d/result%d.xml", milestone, index)
                );
            }
        } catch (Exception ignored) {
        }
        System.out.println("--------------------------------------------------------------------------------");
    }
}