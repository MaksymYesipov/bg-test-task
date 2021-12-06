package com.yesipov.testtask.resolver;

import com.yesipov.testtask.constant.Constants;
import com.yesipov.testtask.processor.CategoryProcessor;
import com.yesipov.testtask.processor.impl.AnimalsCategoryProcessor;
import com.yesipov.testtask.processor.impl.CarsCategoryProcessor;
import com.yesipov.testtask.processor.impl.NumbersCategoryProcessor;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Resolver class which responsible for determining which processor should serve the next line
 */
public class CategoryResolver {
    private final Map<String, CategoryProcessor> processorContainer;
    private Map<String, List<String>> resultsContainer;

    /**
     * Default constructor
     */
    public CategoryResolver() {
        resultsContainer = new HashMap<>();
        processorContainer = new HashMap<>();
        processorContainer.put(Constants.ANIMALS_CATEGORY_NAME, new AnimalsCategoryProcessor());
        processorContainer.put(Constants.NUMBERS_CATEGORY_NAME, new NumbersCategoryProcessor());
        processorContainer.put(Constants.CARS_CATEGORY_NAME, new CarsCategoryProcessor());
    }

    public CategoryResolver(Map<String, CategoryProcessor> processorContainer) {
        resultsContainer = new HashMap<>();
        this.processorContainer = processorContainer;
    }

    /**
     * Method for processing parsed data
     * It works based on switching between available category-specific processors and
     * for each string entry it determines if it is necessary to switch current processor, or add new entry to current one
     * Resolver instance will accumulate gathered results till <code>reset()</code> method invocation
     *
     * @param data parsed data
     * @return {@link Map} with category name as key and appropriate processor result as value
     */
    public Map<String, List<String>> resolveCategories(List<String> data) {
        CategoryProcessor currentProcessor = null;
        for (String entry: data) {
            currentProcessor = defineCurrentProcessor(entry, currentProcessor);
        }
        return generateResult();
    }

    private CategoryProcessor defineCurrentProcessor(String entry, CategoryProcessor currentProcessor) {
        return new HashMap<>(processorContainer).computeIfAbsent(entry.toLowerCase(), e -> {
            currentProcessor.add(e);
            return currentProcessor;
        });
    }

    /**
     * Clears results container
     */
    public void reset() {
        resultsContainer.clear();
        processorContainer.forEach((category, processor) -> processor.clear());
    }

    private Map<String, List<String>> generateResult() {
        resultsContainer = processorContainer.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().getResult()));
        return new HashMap<>(resultsContainer);
    }
}
