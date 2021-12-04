package com.yesipov.testtask.processor.impl;

import com.yesipov.testtask.processor.CategoryProcessor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AnimalsCategoryProcessorTest {
    private CategoryProcessor processor;

    @BeforeEach
    public void setUp() {
        processor = new AnimalsCategoryProcessor();
    }

    @Test
    public void testAddWithSorting() {
        processor.add("cow");
        processor.add("sheep");
        processor.add("bird");

        List<String> result = processor.getResult();
        assertNotNull(result);
        assertEquals(3, result.size());
        assertEquals(Arrays.asList("bird", "cow", "sheep"), result);
    }
}