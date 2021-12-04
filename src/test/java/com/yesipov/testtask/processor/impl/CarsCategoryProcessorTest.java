package com.yesipov.testtask.processor.impl;

import com.yesipov.testtask.processor.CategoryProcessor;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarsCategoryProcessorTest {
    private CategoryProcessor processor;

    @BeforeEach
    public void setUp() {
        processor = new CarsCategoryProcessor();
        initData();
    }

    @Test
    public void testReverseOrderAndHashing() {
        List<String> expected = Arrays.asList(formattedResult("truck"), formattedResult("car"), formattedResult("auto"));
        List<String> result = processor.getResult();
        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test
    public void clearTest() {
        processor.clear();
        List<String> result = processor.getResult();
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    private void initData() {
        processor.add("car");
        processor.add("auto");
        processor.add("truck");
    }

    private String formattedResult(String entry) {
        return entry + " (" + DigestUtils.md5Hex(entry) + ")";
    }
}