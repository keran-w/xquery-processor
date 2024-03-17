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


        int start = 1;
        int queryCount = 20;

        for (int milestone = 3; milestone <= 3; milestone++) {
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
                            XQueryRewriter rewriter = new XQueryRewriter();
                            Path originalQueryPath = Paths.get(String.format("input/m%d/query%d.txt", milestone, index));
                            inputFilepath = Paths.get(String.format("input/m%d-rewrite-test/query%d.txt", milestone, index));
                            rewriter.rewrite(originalQueryPath, inputFilepath);
                            query = Files.readString(inputFilepath);
                            break;
                    }

                    if (query == null) {
                        break;
                    }
                    System.out.println("Processing Milestone " + milestone + " Query " + index);


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
    }
}