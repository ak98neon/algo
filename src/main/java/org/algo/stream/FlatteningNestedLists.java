package org.algo.stream;

import java.util.Arrays;
import java.util.List;

/**
 * Task 3: Flattening Nested Lists
 * Given a list of lists of numbers, flatten all the lists into a single list, sort the numbers in ascending order,
 * and then find the distinct numbers.
 *
 * Input: List<List<Integer>> nestedNumbers = Arrays.asList(
 *     Arrays.asList(1, 2, 3),
 *     Arrays.asList(2, 3, 4),
 *     Arrays.asList(3, 4, 5)
 * );
 *
 * Expected Output:
 * A list: [1, 2, 3, 4, 5]
 */
public class FlatteningNestedLists {

    public static void main(String[] args) {
        var nestedNumbers = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(2, 3, 4),
                Arrays.asList(3, 4, 5)
        );

        var res = solve(nestedNumbers);
        System.out.println(res);
    }

    public static List<Integer> solve(List<List<Integer>> numLists) {
        return numLists.stream()
                .flatMap(List::stream)
                .sorted(Integer::compareTo)
                .distinct()
                .toList();
    }
}
