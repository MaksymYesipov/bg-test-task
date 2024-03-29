package com.yesipov.testtask.processor.impl;

import com.yesipov.testtask.processor.CategoryProcessor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AnimalsCategoryProcessorTest {
    private CategoryProcessor processor;

    @BeforeEach
    public void setUp() {
        processor = new AnimalsCategoryProcessor();
        initData();
    }

    @Test
    public void testAddWithSorting() {
        List<String> result = processor.getResult();
        assertNotNull(result);
        assertEquals(3, result.size());
        assertEquals(Arrays.asList("bird", "cow", "sheep"), result);
    }

    @Test
    public void clearTest() {
        processor.clear();
        List<String> result = processor.getResult();
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    private void initData() {
        processor.add("cow");
        processor.add("sheep");
        processor.add("bird");
    }
}