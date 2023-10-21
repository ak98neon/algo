package org.algo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public static void main(String[] args) {
        var arr = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(
                new GroupAnagrams().groupAnagrams(arr)
        );
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            var key = str.toCharArray();
            Arrays.sort(key);

            if (!map.containsKey(String.valueOf(key))) {
                map.put(String.valueOf(key), new ArrayList<>());
            }

            map.get(String.valueOf(key)).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
