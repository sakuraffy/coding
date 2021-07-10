package top.sakuraffy.bean.same;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberSumTest {

    private NumberSum numberSumUnderTest;

    @BeforeEach
    void setUp() {
        numberSumUnderTest = new NumberSum();
    }

    @Test
    void testTwoSum() {
        final int[] result1 = numberSumUnderTest.twoSum(new int[]{2,7,11,15}, 9);
        assertArrayEquals(new int[]{0,1}, result1);
        final int[] result2 = numberSumUnderTest.twoSum(new int[]{3,2,4}, 6);
        assertArrayEquals(new int[]{1,2}, result2);
        final int[] result3 = numberSumUnderTest.twoSum(new int[]{3,4}, 6);
        assertArrayEquals(new int[]{}, result3);
        final int[] result4 = numberSumUnderTest.twoSum(new int[]{3}, 6);
        assertArrayEquals(new int[]{}, result4);
    }

    @Test
    void testThreeSum() {
        final List<List<Integer>> result1 = numberSumUnderTest.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        assertEquals(Arrays.asList(Arrays.asList(-1, -1, 2), Arrays.asList(-1, 0, 1)), result1);
        final List<List<Integer>> result2 = numberSumUnderTest.threeSum(new int[]{});
        assertEquals(new ArrayList<Integer>(), result2);
        final List<List<Integer>> result3 = numberSumUnderTest.threeSum(new int[]{0});
        assertEquals(new ArrayList<Integer>(), result3);
        final List<List<Integer>> result4 = numberSumUnderTest.threeSum(new int[]{-1, -1, -1, 1, 1, 0, 1, 2, -1, -4});
        assertEquals(Arrays.asList(Arrays.asList(-1, -1, 2), Arrays.asList(-1, 0, 1)), result4);
    }

    @Test
    void testThreeSumClosest() {
        final int result1 = numberSumUnderTest.threeSumClosest(new int[]{-1,2,1,-4}, 1);
        assertEquals(2, result1);
        final int result2 = numberSumUnderTest.threeSumClosest(new int[]{-1,2,1,-4}, 2);
        assertEquals(2, result2);
    }

    @Test
    void testThreeSumMulti() {
        final int result1 = numberSumUnderTest.threeSumMulti(new int[]{1,1,2,2,3,3,4,4,5,5}, 8);
        assertEquals(20, result1);
        final int result2 = numberSumUnderTest.threeSumMulti(new int[]{1,1,2,2,2,2}, 5);
        assertEquals(12, result2);
    }

    @Test
    void testFourSum() {
        final List<List<Integer>> result1 = numberSumUnderTest.fourSum(new int[]{1,0,-1,0,-2,2}, 0);
        assertEquals(Arrays.asList(Arrays.asList(-2,-1,1,2), Arrays.asList(-2,0,0,2), Arrays.asList(-1,0,0,1)), result1);
        final List<List<Integer>> result2 = numberSumUnderTest.fourSum(new int[]{2,2,2,2,2}, 8);
        assertEquals(Arrays.asList(Arrays.asList(2,2,2,2)), result2);
        final List<List<Integer>> result3 = numberSumUnderTest.fourSum(new int[]{-2,-1,-1,1,1,2,2}, 0);
        assertEquals(Arrays.asList(Arrays.asList(-2,-1,1,2), Arrays.asList(-1,-1,1,1)), result3);
    }

    @Test
    void testFourSumCount() {
        final int result1 = numberSumUnderTest.fourSumCount(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2});
        assertEquals(2, result1);
        final int result2 = numberSumUnderTest.fourSumCount(new int[]{0}, new int[]{0}, new int[]{0}, new int[]{0});
        assertEquals(1, result2);
    }
}
