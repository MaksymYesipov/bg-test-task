package com.yesipov.testtask.processor.impl;

import com.yesipov.testtask.processor.CategoryProcessor;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class CarsCategoryProcessor implements CategoryProcessor {
    private final Set<String> cars;

    public CarsCategoryProcessor() {
        this.cars = new TreeSet<>();
    }

    @Override
    public void add(String entry) {
        cars.add(entry.toLowerCase());
    }

    @Override
    public List<String> getResult() {
        return cars.stream()
                .sorted(Comparator.reverseOrder())
                .map(car -> car + " (" + DigestUtils.md5Hex(car) + ")")
                .collect(Collectors.toList());
    }

    @Override
    public void clear() {
        cars.clear();
    }
}
