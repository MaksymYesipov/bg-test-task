package com.yesipov.testtask.util;

import com.yesipov.testtask.resolver.CategoryResolver;

import java.util.List;
import java.util.Map;

/**
 * Util class for printing informations
 */
public class PrintUtils {
    /**
     * Method which prints results from {@link CategoryResolver} instance
     *
     * @param results {@link Map} instance with results
     */
    public static void printResolverResults(Map<String, List<String>> results) {
        results.forEach(PrintUtils::printList);
    }

    private static void printList(String heading, List<String> data) {
        System.out.println(System.lineSeparator() + heading.toUpperCase());
        data.forEach(System.out::println);
    }

    private PrintUtils() {
        throw new UnsupportedOperationException();
    }
}
