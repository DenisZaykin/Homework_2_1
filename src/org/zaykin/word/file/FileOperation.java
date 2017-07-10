package org.zaykin.word.file;

import java.io.*;
import java.util.ArrayList;

import org.zaykin.word.exception.FileOperationException;

/**
 * Created by DHM on 6/4/2017.
 */
public class FileOperation {

    private FileOperation() {
    }

    public static ArrayList<String> readDataFromFile(String fileName) throws FileOperationException {

        if (fileName == null || "".equals(fileName)) {
            throw new FileOperationException("Empty file name");
        }

        ArrayList<String> lines = new ArrayList<>();
        File file = new File(fileName);


        if (!file.exists()) {
            throw new FileOperationException(String.format("File %s not found", fileName));
        }

        if (!file.isFile()) {
            throw new FileOperationException(String.format("%s is not a file", fileName));
        }

        if (!file.canRead()) {
            throw new FileOperationException(String.format("File %s cannot be read", fileName));
        }

        if (file.length() == 0) {
            throw new FileOperationException(String.format("File %s is empty", fileName));
        }

        try (FileInputStream fileInputStream = new FileInputStream(file);
             DataInputStream in = new DataInputStream(fileInputStream);
             LineNumberReader lineBufferedReader = new LineNumberReader(new InputStreamReader(in,"cp1251"));
        ) {
            String line;
            while ((line = lineBufferedReader.readLine()) != null) {
                lines.add(line);
            }

        }
        catch (IOException e) {
            throw new FileOperationException(e.getMessage(), e.getCause());
        }

        if (lines.isEmpty()) {
            throw new FileOperationException(String.format("File %s doesn't contain any valid date", fileName));
        }
        return lines;

    }

}
