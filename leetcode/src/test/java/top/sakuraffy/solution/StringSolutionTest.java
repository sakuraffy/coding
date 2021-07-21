package top.sakuraffy.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringSolutionTest {

    private StringSolution stringSolutionUnderTest;

    @BeforeEach
    void setUp() {
        stringSolutionUnderTest = new StringSolution();
    }

    @Test
    void testLengthOfLongestSubstring() {
        final int result = stringSolutionUnderTest.lengthOfLongestSubstring("pwwkew");
        assertEquals(3, result);
        final int result1 = stringSolutionUnderTest.lengthOfLongestSubstring("tmmzuxt");
        assertEquals(5, result1);
        assertEquals(4, -4 % 10);
    }
}
