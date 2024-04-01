package org.algo.dsa.heap;

import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

class State implements Comparable<State> {
    int x;
    int y;
    int val;

    public State(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }

    @Override
    public int compareTo(State o) {
        return Integer.compare(this.val, o.val);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state = (State) o;
        return x == state.x && y == state.y && val == state.val;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, val);
    }
}

public class TestHeap {

    public static void main(String[] args) {
        var heap = new PriorityQueue<>(Comparator.comparingInt((State state) -> state.val).reversed());
        heap.add(new State(0, 0, 1));
        heap.add(new State(0, 1, 2));
        heap.add(new State(1, 0, 3));

        while (!heap.isEmpty()) {
            var state = heap.poll();
            System.out.println(state.val);
        }
    }
}
