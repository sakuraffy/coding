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
        final boolean result = stringSolutionUnderTest.isNumber("1e2");
        assertTrue(result);
        final boolean result1 = stringSolutionUnderTest.isNumber("2.2e3.2");
        assertFalse(result1);
        final boolean result2 = stringSolutionUnderTest.isNumber("-1E-16");
        assertTrue(result2);
        final boolean result3 = stringSolutionUnderTest.isNumber("46.e3");
        assertTrue(result3);
        final boolean result4 = stringSolutionUnderTest.isNumber("4e+");
        assertFalse(result4);
        final boolean result5 = stringSolutionUnderTest.isNumber("6e6.5");
        assertFalse(result5);
        final boolean result6 = stringSolutionUnderTest.isNumber("46.e5");
        assertTrue(result6);
    }

    @Test
    void testLengthOfLongestSubstring() {
//        final int result = stringSolutionUnderTest.lengthOfLongestSubstring("abcabcbb");
//        assertEquals(3, result);
        final int result1 = stringSolutionUnderTest.lengthOfLongestSubstring("abba");
        assertEquals(2, result1);
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
        final String result = stringSolutionUnderTest.reverseLeftWords("abcdefg", 2);
        assertEquals("cdefgab", result);
    }

    @Test
    void testStrToInt() {
        final int result = stringSolutionUnderTest.strToInt(" -42 ");
        assertEquals(-42, result);
        final int result1 = stringSolutionUnderTest.strToInt("4193 with words");
        assertEquals(4193, result1);
    }

    @Test
    void testIsMatch() {
        final boolean result = stringSolutionUnderTest.isMatch("aab", "aa");
        assertFalse(result);
        final boolean result1 = stringSolutionUnderTest.isMatch("aab", "aa.");
        assertTrue(result1);
        final boolean result2 = stringSolutionUnderTest.isMatch("aab", "aabc*");
        assertTrue(result2);
        final boolean result3 = stringSolutionUnderTest.isMatch("aab", "aab*");
        assertTrue(result3);
        final boolean result4 = stringSolutionUnderTest.isMatch("aabsddaee", ".*");
        assertTrue(result4);
    }

    @Test
    void testFindNthDigit() {
        final int result = stringSolutionUnderTest.findNthDigit(12);
        assertEquals(1, result);
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

    @Test
    void testTranslateNum() {
        final int result = stringSolutionUnderTest.translateNum(12258);
        assertEquals(5, result);
        final int result1 = stringSolutionUnderTest.translateNum(1);
        assertEquals(1, result1);
    }
}
