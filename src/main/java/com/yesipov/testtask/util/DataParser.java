package com.yesipov.testtask.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Util class designed for obtaining file content
 */
public class DataParser {
    /**
     * Static util method which obtains file from
     * resources by name and returns its lines as {@link List} of {@link String} objects
     *
     * @param fileName name of the file which should be parsed
     * @return {@link List} of file lines or empty {@link List} if reading error happened
     */
    public static List<String> parseInputFile(String fileName) {
        InputStream inputStream = DataParser.class.getClassLoader().getResourceAsStream(fileName);
        if (inputStream != null) {
            return new BufferedReader(new InputStreamReader(inputStream))
                    .lines().collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    private DataParser() {
        throw new UnsupportedOperationException();
    }
}
