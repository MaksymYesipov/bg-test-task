package com.yesipov.testtask.util;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PrintUtilsTest {
    public static final String EXPECTED_OUTPUT = "CATEGORY2" + System.lineSeparator() +
            "entry3" + System.lineSeparator() +
            "entry4" + System.lineSeparator() +
            System.lineSeparator() +
            "CATEGORY1" + System.lineSeparator() +
            "entry1" + System.lineSeparator() +
            "entry2";
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void givenSystemOutRedirection_whenInvokePrintln_thenOutputCaptorSuccess() {
        Map<String, List<String>> inputData = initInputData();
        PrintUtils.printResolverResults(inputData);

        assertEquals(EXPECTED_OUTPUT, outputStreamCaptor.toString().trim());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    private Map<String, List<String>> initInputData() {
        Map<String, List<String>> data = new HashMap<>();
        data.put("CATEGORY1", Arrays.asList("entry1", "entry2"));
        data.put("CATEGORY2", Arrays.asList("entry3", "entry4"));
        return data;
    }
}