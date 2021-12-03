package com.yesipov.testtask.resolver;

import com.yesipov.testtask.processor.CategoryProcessor;
import com.yesipov.testtask.processor.impl.AnimalsCategoryProcessor;
import com.yesipov.testtask.processor.impl.NumbersCategoryProcessor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.yesipov.testtask.constant.Constants.ANIMALS_CATEGORY_NAME;
import static com.yesipov.testtask.constant.Constants.NUMBERS_CATEGORY_NAME;

/**
 * Resolver class which responsible for determining which processor should serve the next line
 */
public class CategoryResolver {
    private final Map<String, CategoryProcessor> processorContainer;

    /**
     * Default constructor
     */
    public CategoryResolver() {
        processorContainer = new HashMap<>();
        processorContainer.put(ANIMALS_CATEGORY_NAME, new AnimalsCategoryProcessor());
        processorContainer.put(NUMBERS_CATEGORY_NAME, new NumbersCategoryProcessor());
    }

    /**
     * Method for processing parsed data
     * It works based on switching between available category-specific processors and
     * for each string entry it determines if it is necessary to switch current processor, or add new entry to current one
     *
     * @param data parsed data
     */
    public void resolveCategories(List<String> data) {
        CategoryProcessor currentProcessor = null;
        for (String entry: data) {
            CategoryProcessor processor = processorContainer.get(entry.toLowerCase());
            if (processor != null) {
                currentProcessor = processor;
            } else if (currentProcessor != null) {
                currentProcessor.add(entry);
            }
        }
    }

    /**
     * Getter for results field
     */
    public Map<String, List<String>> getResults() {
        return processorContainer.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().getResult()));
    }
}
