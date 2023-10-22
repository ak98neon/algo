package org.algo.stream;

import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static java.util.stream.Collectors.toMap;

/**
 * Task: Transform a Map and Collect Statistics
 * You have a Map where the keys are names of students and the values are lists of their test scores.
 * <p>
 * Map<String, List<Integer>> studentScores = new HashMap<>() {{
 * put("Alice", Arrays.asList(85, 90, 78, 92));
 * put("Bob", Arrays.asList(70, 82, 65, 87));
 * put("Charlie", Arrays.asList(92, 95, 93, 90));
 * put("Daisy", Arrays.asList(72, 76, 70, 68));
 * }};
 * Your task is to transform this map into another Map<String, StudentStats>, where StudentStats is a custom class that holds:
 * <p>
 * The highest score.
 * The lowest score.
 * The average score.
 * For the purpose of this task, define the StudentStats class as:
 * <p>
 * public class StudentStats {
 * private final int highestScore;
 * private final int lowestScore;
 * private final double averageScore;
 * <p>
 * public StudentStats(int highestScore, int lowestScore, double averageScore) {
 * this.highestScore = highestScore;
 * this.lowestScore = lowestScore;
 * this.averageScore = averageScore;
 * }
 * <p>
 * // getters and possibly other methods like toString
 * }
 * Expected Output:
 * <p>
 * For the provided input, the resulting map should contain:
 * <p>
 * Alice with highest score = 92, lowest score = 78, and average = 86.25.
 * Bob with highest score = 87, lowest score = 65, and average = 76.
 * Charlie with highest score = 95, lowest score = 90, and average = 92.5.
 * Daisy with highest score = 76, lowest score = 68, and average = 71.5.
 */
public class TransformMapCollectStatistics {

    public static void main(String[] args) {
        Map<String, List<Integer>> studentScores = new HashMap<>() {{
            put("Alice", Arrays.asList(85, 90, 78, 92));
            put("Bob", Arrays.asList(70, 82, 65, 87));
            put("Charlie", Arrays.asList(92, 95, 93, 90));
            put("Daisy", Arrays.asList(72, 76, 70, 68));
        }};

        var result = new TransformMapCollectStatistics().solve(studentScores);
        System.out.println(result);
    }

    public Map<String, StudentStats> solve(Map<String, List<Integer>> studentScores) {
        return studentScores.entrySet()
                .stream()
                .map(e -> new SimpleImmutableEntry<>(
                        e.getKey(),
                        new StudentStats(
                                Collections.max(e.getValue()),
                                Collections.min(e.getValue()),
                                e.getValue().stream().mapToInt(Integer::intValue).average().orElse(0)
                        ))).collect(toMap(SimpleImmutableEntry::getKey, SimpleImmutableEntry::getValue));
    }

    public class StudentStats {
        private final int highestScore;
        private final int lowestScore;
        private final double averageScore;

        public StudentStats(int highestScore, int lowestScore, double averageScore) {
            this.highestScore = highestScore;
            this.lowestScore = lowestScore;
            this.averageScore = averageScore;
        }

        public int getHighestScore() {
            return highestScore;
        }

        public int getLowestScore() {
            return lowestScore;
        }

        public double getAverageScore() {
            return averageScore;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            StudentStats that = (StudentStats) o;
            return highestScore == that.highestScore && lowestScore == that.lowestScore && Double.compare(averageScore, that.averageScore) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(highestScore, lowestScore, averageScore);
        }

        @Override
        public String toString() {
            return "highestScore=" + highestScore +
                    ", lowestScore=" + lowestScore +
                    ", and averageScore=" + averageScore;
        }
    }
}
