package top.sakuraffy.same;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SubArrayTest {

    private SubArray subArrayUnderTest;

    @BeforeEach
    void setUp() {
        subArrayUnderTest = new SubArray();
    }

    @Test
    void testSumSubarrayMins() {
        final int result1 = subArrayUnderTest.sumSubarrayMins(new int[]{});
        assertEquals(0, result1);
        final int result2 = subArrayUnderTest.sumSubarrayMins(new int[]{3,1,2,4});
        assertEquals(17, result2);
        final int result3 = subArrayUnderTest.sumSubarrayMins(new int[]{11,81,94,43,3});
        assertEquals(444, result3);
    }

    @Test
    void testSubarraySum() {
        final int result1 = subArrayUnderTest.subarraySum(new int[]{1, 1, 1}, 2);
        assertEquals(2, result1);
    }
}
