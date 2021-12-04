package com.yesipov.testtask.processor.impl;

import com.yesipov.testtask.processor.CategoryProcessor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumbersCategoryProcessorTest {
    private CategoryProcessor processor;

    @BeforeEach
    public void setUp() {
        processor = new NumbersCategoryProcessor();
        initData();
    }

    @Test
    public void testAdd() {
        List<String> expected = Arrays.asList("one: 3", "two: 1", "three: 1");
        List<String> result = processor.getResult();
        assertNotNull(result);
        assertEquals(3, result.size());
        assertTrue(expected.containsAll(result) && result.containsAll(expected));
    }

    @Test
    public void clearTest() {
        processor.clear();
        List<String> result = processor.getResult();
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    private void initData() {
        processor.add("one");
        processor.add("two");
        processor.add("one");
        processor.add("three");
        processor.add("one");
    }
}