package com.yesipov.testtask.processor;

import java.util.List;

/**
 * Interface which describes processor for specific category
 */
public interface CategoryProcessor {
    /**
     * Adds an element to internal results collection,
     * counting all the necessary processing logic
     *
     * @param entry entry which should be added to result collection
     */
    void add(String entry);

    /**
     * Returns {@link List} of the results
     *
     * @return {@link List} of the results
     */
    List<String> getResult();
}
