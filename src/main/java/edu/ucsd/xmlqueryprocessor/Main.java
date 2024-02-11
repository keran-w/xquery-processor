package edu.ucsd.xmlqueryprocessor;

import edu.ucsd.xmlqueryprocessor.engine.Engine;

import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.nio.file.*;
import java.util.*;


public class Main {
    // run in sh: java -jar out/artifacts/xquery_processor_jar/xquery-processor.jar \
    // xquery-processor-master/test.txt \
    // xquery-processor-master/output/

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java Main <QUERY_FILE_DIRECTORY> <OUTPUT_FILE_DIRECTORY>");
            return;
        }

        String FILE_DIRECTORY = "xquery-processor-master/";

        String QUERY_FILE_DIRECTORY = args[0];
        String OUTPUT_FILE_DIRECTORY = args[1];

//        String FILE_DIRECTORY = "D://Java-code/CSE232b/milestone1/xquery-processor-master/";
//        String QUERY_FILE_DIRECTORY = "D://Java-code/CSE232b/milestone1/xquery-processor-master/mytest.txt";
//        String OUTPUT_FILE_DIRECTORY = "D://Java-code/CSE232b/milestone1/xquery-processor-master/output/";

        Engine engine = new Engine(FILE_DIRECTORY, OUTPUT_FILE_DIRECTORY);

        // read and process test XQueries
        readProcessQueries(engine, QUERY_FILE_DIRECTORY);
    }

    private static void readProcessQueries(Engine engine, String queryFilePath) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(queryFilePath));
            int queryCounter = 1;
            for (String query : lines) {
                System.out.println("SAMPLE QUERY " + queryCounter + ":\t" + "SAMPLE_QUERY_" + queryCounter);
                String resultIdentifier = "result" + queryCounter++;
                engine.process(query, resultIdentifier);
                System.out.println("--------------------------------------------------------------------------------");
                System.out.println("--------------------------------------------------------------------------------");
            }
        } catch (IOException e) {
            System.err.println("Error reading queries file: " + e.getMessage());
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
    }
}