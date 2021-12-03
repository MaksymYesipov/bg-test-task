package com.yesipov.testtask.util;

import com.yesipov.testtask.resolver.CategoryResolver;

import java.util.List;

/**
 * Util class for printing informations
 */
public class PrintUtils {
    /**
     * Method which prints results from {@link CategoryResolver} instance
     *
     * @param resolver {@link CategoryResolver} instance which results will be printed
     */
    public static void printResolverResults(CategoryResolver resolver) {
        resolver.getResults().forEach(PrintUtils::printList);
    }

    public static void printList(String heading, List<String> data) {
        System.out.println(System.lineSeparator() + heading.toUpperCase());
        data.forEach(System.out::println);
    }

    private PrintUtils() {
        throw new UnsupportedOperationException();
    }
}
