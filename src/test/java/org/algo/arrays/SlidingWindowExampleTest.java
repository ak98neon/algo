package org.algo.arrays;

import org.junit.jupiter.api.Test;

import static org.algo.arrays.SlidingWindowExample.maxSumInArrSlidingWindow;
import static org.junit.jupiter.api.Assertions.*;

class SlidingWindowExampleTest {

    @Test
    void maxSumInArrSlidingWindowTest() {
        var arr = new int[] {1, 2, 3, 4, 5, 6};
        var k = 3;

        var result = maxSumInArrSlidingWindow(arr, k);
        assertEquals(15, result);
    }
}
