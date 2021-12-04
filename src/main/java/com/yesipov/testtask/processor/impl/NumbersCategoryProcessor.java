package com.yesipov.testtask.processor.impl;

import com.yesipov.testtask.processor.CategoryProcessor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * {@link CategoryProcessor} implementation for numbers category, includes counting of equal entries and specific result formatting
 */
public class NumbersCategoryProcessor implements CategoryProcessor {
    private final Map<String, Integer> numbers;

    public NumbersCategoryProcessor() {
        numbers = new HashMap<>();
    }

    @Override
    public void add(String entry) {
        numbers.compute(entry, (key, value) -> value != null ? ++value : 1);
    }

    @Override
    public List<String> getResult() {
        List<String> result = new ArrayList<>();
        fillResultsList(result);
        return result;
    }

    @Override
    public void clear() {
        numbers.clear();
    }

    private void fillResultsList(List<String> result) {
        numbers.forEach((k, v) -> result.add(k + ": " + v));
    }
}
