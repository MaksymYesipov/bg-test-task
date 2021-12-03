package com.yesipov.testtask;

import com.yesipov.testtask.resolver.CategoryResolver;
import com.yesipov.testtask.util.DataParser;
import com.yesipov.testtask.util.PrintUtils;

import java.util.List;

public class Run {
    public static void main(String[] args) {
        List<String> data = DataParser.parseInputFile("data/input.txt");
        CategoryResolver resolver = new CategoryResolver();
        resolver.resolveCategories(data);
        PrintUtils.printResolverResults(resolver);
    }
}
