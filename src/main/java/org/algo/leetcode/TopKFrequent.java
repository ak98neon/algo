package org.algo.leetcode;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 * <p>
 * Input: nums = [1], k = 1
 * Output: [1]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * k is in the range [1, the number of unique elements in the array].
 * It is guaranteed that the answer is unique.
 * <p>
 * <p>
 * Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class TopKFrequent {

    public static void main(String[] args) {
        var arr = new int[]{1, 1, 1, 2, 2, 3};
        System.out.println(
                Arrays.toString(new TopKFrequent().topKFrequent(arr, 2))
        );
    }

    public int[] topKFrequent(int[] nums, int k) {
        var frequencyMap = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toMap(n -> n, n -> 1, Integer::sum));

        return frequencyMap.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .limit(k)
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }

}
