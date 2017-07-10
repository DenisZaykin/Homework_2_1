package org.zaykin.word.parser;

import org.zaykin.word.exception.ParameterFormatException;

import java.util.Arrays;
import java.util.List;

/**
 * Created by DHM on 6/4/2017.
 */
public class DataParser {

    public static final String DELIMITER = " ";

    public static List<String> parseLine(String line, int lineNumber) throws ParameterFormatException{

        if (lineNumber < 1) {
            throw new ParameterFormatException(String.format("Line number cannot be less than 1; got: %d", lineNumber));
        }

        return Arrays.asList(line.trim().replaceAll("\\p{Punct}","").replaceAll("\\p{Space}+"," ").split(DELIMITER));
    }

}
