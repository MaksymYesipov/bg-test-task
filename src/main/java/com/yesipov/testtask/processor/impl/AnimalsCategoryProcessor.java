package com.yesipov.testtask.processor.impl;

import com.yesipov.testtask.processor.CategoryProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * {@link CategoryProcessor} implementation for animal category, includes sorting
 */
public class AnimalsCategoryProcessor implements CategoryProcessor {
    private final Set<String> animals;

    public AnimalsCategoryProcessor() {
        animals = new TreeSet<>();
    }

    @Override
    public void add(String entry) {
        animals.add(entry);
    }

    @Override
    public List<String> getResult() {
        return new ArrayList<>(animals);
    }

    @Override
    public void clear() {
        animals.clear();
    }
}
