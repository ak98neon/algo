package org.algo.designgurus.warmup;

//Easy
public class ShortestWordDistance {

    public static void main(String[] args) {
        var words = new String[]{"a", "c", "d", "b", "a"};
        var word1 = "a";
        var word2 = "b";

        var res = shortestDistance(words, word1, word2);
        System.out.println(res);
    }

    public static int shortestDistance(String[] words, String word1, String word2) {
        int position1 = -1, position2 = -1;
        int shortestDistance = words.length;

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                position1 = i;
            } else if (words[i].equals(word2)) {
                position2 = i;
            }

            if (position1 != -1 && position2 != -1) {
                shortestDistance = Math.min(shortestDistance, Math.abs(position2 - position1));
            }
        }

        return shortestDistance;
    }
}
