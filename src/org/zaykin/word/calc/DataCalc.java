package org.zaykin.word.calc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by DHM on 7/5/2017.
 */
public class DataCalc {

    public static int numberOfOccurrence(List<String> lines, String word, boolean isCaseSensitive) {

        int result = 0;
        List<String> linesToLowerCase;
        if (lines != null && !lines.isEmpty()) {

            if (isCaseSensitive) {
                linesToLowerCase = new ArrayList<>();
                lines.forEach((line) -> linesToLowerCase.add(line.toLowerCase()));
            }
            else {
                linesToLowerCase = lines;
            }
            result = Collections.frequency(isCaseSensitive?linesToLowerCase:lines, isCaseSensitive?word.toLowerCase():word);

        }
        return result;
    }


}
