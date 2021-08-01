package top.sakuraffy.company.mayi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ArraySolutionTest {

    private ArraySolution arraySolutionUnderTest;

    @BeforeEach
    void setUp() {
        arraySolutionUnderTest = new ArraySolution();
    }

    @Test
    void testSpiralOrder() {
        final List<Integer> result1 = arraySolutionUnderTest.spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
        assertEquals(Arrays.asList(1,2,3,6,9,8,7,4,5).toString(), result1.toString());
        final List<Integer> result2 = arraySolutionUnderTest.spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}});
        assertEquals(Arrays.asList(1,2,3,4,8,12,11,10,9,5,6,7).toString(), result2.toString());
        final List<Integer> result3 = arraySolutionUnderTest.spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}});
        assertEquals(Arrays.asList(1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10).toString(), result3.toString());
    }

    @Test
    void testSearchRange() {
        final int[] result1 = arraySolutionUnderTest.searchRange(new int[]{5,7,7,8,8,10}, 8);
        assertArrayEquals(new int[]{3, 4}, result1);
    }

    @Test
    void testPermute() {
        final List<List<Integer>> result = arraySolutionUnderTest.permute(new int[]{1, 2});
        assertEquals(Arrays.asList(Arrays.asList(1,2), Arrays.asList(2, 1)), result);
    }

    @Test
    void testFindKthLargest() {
        final int result = arraySolutionUnderTest.findKthLargest(new int[]{3,2,1,5,6,4}, 2);
        assertEquals(5, result);
    }

    @Test
    void testSmallestK() {
        final int[] result = arraySolutionUnderTest.smallestK(new int[]{1,3,5,7,2,4,6,8}, 4);
        assertArrayEquals(new int[]{4, 3, 2, 1}, result);
    }

    @Test
    void testBiggestK() {
        final int[] result = arraySolutionUnderTest.biggestK(new int[]{3,9,1,5,7,2,4,6,8}, 5);
        assertArrayEquals(new int[]{5,9,7,6,8}, result);
    }

    @Test
    public void testMaxArea() {
        final int result = arraySolutionUnderTest.maxArea(new int[]{1,8,6,2,5,4,8,3,7});
        assertEquals(49, result);
    }
}
