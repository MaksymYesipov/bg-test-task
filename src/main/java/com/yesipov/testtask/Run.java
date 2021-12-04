package com.yesipov.testtask;

import com.yesipov.testtask.resolver.CategoryResolver;
import com.yesipov.testtask.util.DataParser;
import com.yesipov.testtask.util.PrintUtils;

import java.util.List;

public class Run {
    public static void main(String[] args) {
        List<String> data = DataParser.parseInputFile("data/input.txt");
        List<String> data2 = DataParser.parseInputFile("data/input2.txt");
        CategoryResolver resolver = new CategoryResolver();
        resolver.resolveCategories(data);
        PrintUtils.printResolverResults(resolver.resolveCategories(data2));
    }
}
