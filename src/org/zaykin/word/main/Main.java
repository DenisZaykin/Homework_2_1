package org.zaykin.word.main;

import org.zaykin.word.calc.DataCalc;
import org.zaykin.word.file.FileOperation;
import org.zaykin.word.parser.DataParser;

import java.util.List;

/**
 * Created by DHM on 7/5/2017.
 */
public class Main {

    public static final String FILE_NAME = "data\\war and peace.txt";
    public static final String WORD_TO_FIND = "Война";


    public static void main(String[] args) throws Exception {
        List<String> linesFromFile = FileOperation.readDataFromFile(FILE_NAME);
        int counter = 0;
        int tempCounter = 0;

        for (int lineNumber=0; lineNumber<linesFromFile.size(); lineNumber++) {
            List<String> parsedLine = DataParser.parseLine(linesFromFile.get(lineNumber), lineNumber+1);
            tempCounter = DataCalc.numberOfOccurrence(parsedLine, WORD_TO_FIND, false);
            counter += tempCounter;
            if (tempCounter>0) {
                System.out.println(parsedLine);
            }
        }

        System.out.println(String.format("Number of the occurrences of the word %s in file %s is: %d",WORD_TO_FIND, FILE_NAME, counter));

    }

}


