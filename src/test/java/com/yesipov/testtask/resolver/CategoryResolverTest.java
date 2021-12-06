package com.yesipov.testtask.resolver;

import com.yesipov.testtask.processor.CategoryProcessor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CategoryResolverTest {
    private static final String CATEGORY_1 = "category1";
    private static final String CATEGORY_2 = "category2";
    private static final List<String> TEST_DATA =
            Arrays.asList(CATEGORY_1, "entry1", "entry2", CATEGORY_2, "entry3", "entry4", CATEGORY_1, CATEGORY_2, "entry5");

    @Spy
    private final Map<String, CategoryProcessor> processorContainer = new HashMap<>();
    @Mock
    private CategoryProcessor category1Processor;
    @Mock
    private CategoryProcessor category2Processor;

    private CategoryResolver resolver;

    @BeforeEach
    public void setUp() {
        processorContainer.put(CATEGORY_1, category1Processor);
        processorContainer.put(CATEGORY_2, category2Processor);
        resolver = new CategoryResolver(processorContainer);
    }

    @Test
    public void resolveCategoriesTest() {
        when(category1Processor.getResult()).thenReturn(Arrays.asList("entry1", "entry2"));
        when(category2Processor.getResult()).thenReturn(Arrays.asList("entry3", "entry4", "entry5"));
        Map<String, List<String>> results = resolver.resolveCategories(TEST_DATA);
        verifyProcessorInsertions();
        assertNotNull(results);
        assertEquals(2, results.size());
        assertEquals(2, results.get(CATEGORY_1).size());
        assertEquals(3, results.get(CATEGORY_2).size());
    }

    @Test
    public void resolveCategoriesWithAccumulationTest() {
        when(category1Processor.getResult()).thenReturn(Arrays.asList("entry1", "entry2", "entry6"));
        when(category2Processor.getResult()).thenReturn(Arrays.asList("entry3", "entry4", "entry5", "entry7"));
        resolver.resolveCategories(TEST_DATA);
        Map<String, List<String>> results = resolver.resolveCategories(Arrays.asList(CATEGORY_1, "entry6", CATEGORY_2, "entry7"));
        verifyAccumulatedProcessorInsertions();
        assertNotNull(results);
        assertEquals(2, results.size());
        assertEquals(3, results.get(CATEGORY_1).size());
        assertEquals(4, results.get(CATEGORY_2).size());
    }

    @Test
    public void resetTest() {
        resolver.reset();
        verify(category1Processor).clear();
        verify(category2Processor).clear();
    }

    private void verifyProcessorInsertions() {
        verify(category1Processor).add(eq("entry1"));
        verify(category1Processor).add(eq("entry2"));
        verify(category2Processor).add(eq("entry3"));
        verify(category2Processor).add(eq("entry4"));
        verify(category2Processor).add(eq("entry5"));
    }

    private void verifyAccumulatedProcessorInsertions() {
        verifyProcessorInsertions();
        verify(category1Processor).add(eq("entry6"));
        verify(category2Processor).add(eq("entry7"));
    }
}