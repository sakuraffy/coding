package cn.sakuraffy.array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

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
}
