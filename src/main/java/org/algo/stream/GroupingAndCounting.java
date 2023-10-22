package org.algo.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Task 1: Grouping by Length and Counting
 * Given a list of strings, group them by their length and count how many strings are of each length.
 * <p>
 * Input: List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "kiwi", "mango", "orange");
 * <p>
 * Expected Output:
 * A map where keys are string lengths and values are counts:
 * {5=3, 6=3, 4=1}
 */
public class GroupingAndCounting {

    public static void main(String[] args) {
        var words = Arrays.asList("apple", "banana", "cherry", "date", "kiwi", "mango", "orange");
        var result = groupAndCount(words);
        System.out.println(result);
    }

    public static Map<Integer, Long> groupAndCount(List<String> words) {
        return words.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.counting()));
    }
}
