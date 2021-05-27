package top.sakuraffy.solution.array;

import com.sun.xml.internal.ws.policy.AssertionValidationProcessor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArraySolutionTest {

    private ArraySolution arraySolutionUnderTest;

    @BeforeEach
    void setUp() {
        arraySolutionUnderTest = new ArraySolution();
    }

    @Test
    void testSmallerNumbersThanCurrent() {
        final int[] result = arraySolutionUnderTest.smallerNumbersThanCurrent(new int[]{0});
        assertArrayEquals(new int[]{0}, result);
    }

    @Test
    void testVoidFlood() {
        final int[] result1 = arraySolutionUnderTest.avoidFlood(new int[]{1, 2, 3, 4});
        assertArrayEquals(new int[]{-1, -1, -1, -1}, result1);
        final int[] result2 = arraySolutionUnderTest.avoidFlood(new int[]{1, 2, 0, 0, 2, 1});
        assertArrayEquals(new int[]{-1, -1, 2, 1, -1, -1}, result2);
        final int[] result3 = arraySolutionUnderTest.avoidFlood(new int[]{1, 2, 0, 1, 2});
        assertArrayEquals(new int[]{}, result3);
        final int[] result4 = arraySolutionUnderTest.avoidFlood(new int[]{0, 1, 1});
        assertArrayEquals(new int[]{}, result4);
        final int[] result5 = arraySolutionUnderTest.avoidFlood(new int[]{69, 0, 0, 0, 69});
        assertArrayEquals(new int[]{-1, 69, 1, 1, -1}, result5);
        final int[] result6 = arraySolutionUnderTest.avoidFlood(new int[]{1, 0, 2, 0, 2, 1});
        assertArrayEquals(new int[]{-1, 1, -1, 2, -1, -1}, result6);
    }

    @Test
    void testCountPairs() {
        final int result1 = arraySolutionUnderTest.countPairs(new int[]{1, 3, 5, 7, 9});
        assertEquals(4, result1);
        final int result2 = arraySolutionUnderTest.countPairs(new int[]{1, 1, 1, 3, 3, 3, 7});
        assertEquals(15, result2);
    }

    @Test
    void testMinSubarray() {
        final int result1 = arraySolutionUnderTest.minSubarray(new int[]{3, 1, 4, 2}, 6);
        assertEquals(1, result1);
        final int result2 = arraySolutionUnderTest.minSubarray(new int[]{6, 3, 5, 2}, 9);
        assertEquals(2, result2);
        final int result3 = arraySolutionUnderTest.minSubarray(new int[]{1, 2, 3}, 3);
        assertEquals(0, result3);
        final int result4 = arraySolutionUnderTest.minSubarray(new int[]{1, 2, 3}, 7);
        assertEquals(-1, result2);
        final int result5 = arraySolutionUnderTest.minSubarray(new int[]{1000000000, 1000000000, 1000000000}, 3);
        assertEquals(0, result2);
    }

    @Test
    void testThreeSum() {
        final List<List<Integer>> result1 = arraySolutionUnderTest.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        assertEquals(Arrays.asList(Arrays.asList(-1, -1, 2), Arrays.asList(-1, 0, 1)), result1);
        final List<List<Integer>> result2 = arraySolutionUnderTest.threeSum(new int[]{});
        assertEquals(new ArrayList<Integer>(), result2);
        final List<List<Integer>> result3 = arraySolutionUnderTest.threeSum(new int[]{0});
        assertEquals(new ArrayList<Integer>(), result3);
    }
}