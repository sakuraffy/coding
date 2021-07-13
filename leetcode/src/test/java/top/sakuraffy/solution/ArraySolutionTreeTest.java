package top.sakuraffy.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArraySolutionTreeTest {

    @Autowired
    @Qualifier
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
        assertEquals(-1, result4);
        final int result5 = arraySolutionUnderTest.minSubarray(new int[]{1000000000, 1000000000, 1000000000}, 3);
        assertEquals(0, result5);
    }

    @Test
    void testInvalidTransactions() {
//        final List<String> result1 = arraySolutionUnderTest.invalidTransactions(new String[]{"alice,20,800,mtv", "alice,50,100,beijing"});
//        assertEquals(Arrays.asList("alice,20,800,mtv", "alice,50,100,beijing"), result1);
//        final List<String> result2 = arraySolutionUnderTest.invalidTransactions(new String[]{"alice,20,800,mtv", "alice,50,1200,mtv"});
//        assertEquals(Arrays.asList("alice,50,1200,mtv"), result2);
//        final List<String> result3 = arraySolutionUnderTest.invalidTransactions(new String[]{"alice,20,800,mtv", "bob,50,1200,mtv"});
//        assertEquals(Arrays.asList("bob,50,1200,mtv"), result3);
        final List<String> result4 = arraySolutionUnderTest.invalidTransactions(new String[]{"alice,20,800,mtv", "alice,50,100,mtv", "alice,51,100,frankfurt"});
        assertEquals(Arrays.asList("alice,20,800,mtv", "alice,50,100,mtv", "alice,51,100,frankfurt"), result4);
    }
}
