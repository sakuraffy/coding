package top.sakuraffy.solution;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
    }

    @Test
    void testLongestPalindrome() {
        final String result = stringSolutionUnderTest.longestPalindrome("babad");
        assertEquals("bab", result);
        final String result1 = stringSolutionUnderTest.longestPalindrome("cbbd");
        assertEquals("bb", result1);
        final String result2 = stringSolutionUnderTest.longestPalindrome("a");
        assertEquals("a", result2);
    }

    @Test
    void test() {
        assertTrue(stringSolutionUnderTest.isPalindrome("A man, a plan, a canal: Panama"));
    }
}
