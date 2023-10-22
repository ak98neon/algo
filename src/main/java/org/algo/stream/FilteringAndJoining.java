package org.algo.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Task 2: Filtering and Joining
 * Given a list of numbers, filter out all the even numbers and then join the remaining
 * odd numbers into a single string separated by commas.
 * <p>
 * Input: List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
 * <p>
 * Output: "1,3,5,7,9"
 */
public class FilteringAndJoining {

    public static void main(String[] args) {
        var numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(filterAndJoin(numbers));
    }

    public static String filterAndJoin(List<Integer> nums) {
        return nums.stream()
                .filter(n -> n % 2 != 0)
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }
}
