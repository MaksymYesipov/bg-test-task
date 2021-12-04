package com.yesipov.testtask.util;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataParserTest {

    @Test
    void parseInputFileTest() {
        List<String> actual = DataParser.parseInputFile("testInput.txt");
        List<String> expected = Arrays.asList("CATEGORY1", "entry1", "entry2", "CATEGORY2", "entry3");
        assertNotNull(actual);
        assertEquals(expected, actual);
    }
}