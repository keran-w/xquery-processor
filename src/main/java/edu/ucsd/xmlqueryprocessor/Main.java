package edu.ucsd.xmlqueryprocessor;

import edu.ucsd.xmlqueryprocessor.engine.Engine;

public class Main {
    // Find all persons in the play
    public static final String SAMPLE_QUERY_1 = "doc(\"j_caesar.xml\")//PERSONA";

    // Find the scenes in which CAESAR speaks
    public static final String SAMPLE_QUERY_2 = "doc(\"j_caesar.xml\")//SCENE[SPEECH/SPEAKER/text() = \"CAESAR\"]";

    // Find the acts containing some scene in which both CAESAR and BRUTUS speak
    public static final String SAMPLE_QUERY_3 = "doc(\"j_caesar.xml\")//ACT[SCENE[SPEECH/SPEAKER/text() = \"CAESAR\"][SPEECH/SPEAKER/text() = \"BRUTUS\"]]";

    // Same as previous, but different syntax
    public static final String SAMPLE_QUERY_4 = "doc(\"j_caesar.xml\")//ACT[.//SPEAKER/text() = \"CAESAR\"][.//SPEAKER/text() = \"BRUTUS\"]";

    // Find the acts in which CAESAR no longer appears
    public static final String SAMPLE_QUERY_5 = "doc(\"j_caesar.xml\")//ACT[not .//SPEAKER/text() = \"CAESAR\"]";

    public static final String FILE_DIRECTORY = "/Users/keranwang/Desktop/Winter 24/CSE 232B/project/xquery-processor/";
    public static final String OUTPUT_FILE_DIRECTORY = "/Users/keranwang/Desktop/Winter 24/CSE 232B/project/xquery-processor/output/";

    public static void main(String[] args) {
        Engine engine = new Engine(FILE_DIRECTORY, OUTPUT_FILE_DIRECTORY);
        System.out.println("Find all persons in the play");
        System.out.println("SAMPLE QUERY 1:\t" + SAMPLE_QUERY_1);
        engine.process(SAMPLE_QUERY_1, "result1");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------------");

        System.out.println("Find the scenes in which CAESAR speaks");
        System.out.println("SAMPLE QUERY 2:\t" + SAMPLE_QUERY_2);
        engine.process(SAMPLE_QUERY_2, "result2");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------------");

        System.out.println("Find the acts containing some scene in which both CAESAR and BRUTUS speak");
        System.out.println("SAMPLE QUERY 3:\t" + SAMPLE_QUERY_3);
        engine.process(SAMPLE_QUERY_3, "result3");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------------");

        System.out.println("Same as previous, but different syntax");
        System.out.println("SAMPLE QUERY 4:\t" + SAMPLE_QUERY_4);
        engine.process(SAMPLE_QUERY_4, "result4");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("--------------------------------------------------------------------------------");

        System.out.println("Find the acts in which CAESAR no longer appears");
        System.out.println("SAMPLE QUERY 5:\t" + SAMPLE_QUERY_5 + "\n");
        engine.process(SAMPLE_QUERY_5, "result5");
    }
}