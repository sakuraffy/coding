package top.sakuraffy.offer;

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
    void testPermutation() {
        final String[] result = stringSolutionUnderTest.permutation("abc");
        assertArrayEquals(new String[]{"abc","acb","bac","bca","cab","cba"}, result);
    }

    @Test
    void testIsNumber() {
        // Setup

        // Run the test
        final boolean result = stringSolutionUnderTest.isNumber("str");

        // Verify the results
        assertTrue(result);
    }

    @Test
    void testLengthOfLongestSubstring() {
        // Setup

        // Run the test
        final int result = stringSolutionUnderTest.lengthOfLongestSubstring("str");

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    void testMinNumber() {
        final String result = stringSolutionUnderTest.minNumber(new int[]{3,30,34,5,9});
        assertEquals("3033459", result);
    }

    @Test
    void testFirstUniqChar() {
        final char result = stringSolutionUnderTest.firstUniqChar("str");
        assertEquals('s', result);
    }

    @Test
    void testReverseLeftWords() {
        // Setup

        // Run the test
        final String result = stringSolutionUnderTest.reverseLeftWords("str", 0);

        // Verify the results
        assertEquals("result", result);
    }

    @Test
    void testStrToInt() {
        // Setup

        // Run the test
        final int result = stringSolutionUnderTest.strToInt("str");

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    void testIsMatch() {
        // Setup

        // Run the test
        final boolean result = stringSolutionUnderTest.isMatch("str", "pattern");

        // Verify the results
        assertTrue(result);
    }

    @Test
    void testFindNthDigit() {
        // Setup

        // Run the test
        final int result = stringSolutionUnderTest.findNthDigit(0);

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    void testReverseWords() {
        final String result = stringSolutionUnderTest.reverseWords("a good   example");
        assertEquals("example good a", result);
    }

    @Test
    void testReplaceSpace() {
        final String result = stringSolutionUnderTest.replaceSpace("We are happy.");
        assertEquals("We%20are%20happy.", result);
    }
}
