package top.sakuraffy.offer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StackSolutionTest {

    private StackSolution stackSolutionUnderTest;

    @BeforeEach
    void setUp() {
        stackSolutionUnderTest = new StackSolution();
    }

    @Test
    void testValidateStackSequences() {
        final boolean result = stackSolutionUnderTest.validateStackSequences(new int[]{1,2,3,4,5}, new int[]{4,5,3,2,1});
        assertTrue(result);
        final boolean result1 = stackSolutionUnderTest.validateStackSequences(new int[]{1,2,3,4,5}, new int[]{4,3,5,1,2});
        assertFalse(result1);
    }
}
