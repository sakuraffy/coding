package top.sakuraffy.bean.same;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class JumpGameTest {

    private JumpGame jumpGameUnderTest;

    @BeforeEach
    void setUp() {
        jumpGameUnderTest = new JumpGame();
    }

    @Test
    void testCanJump() {
        // Setup

        // Run the test
        final boolean result = jumpGameUnderTest.canJump(new int[]{0});

        // Verify the results
        assertTrue(result);
    }

    @Test
    void testJump() {
        // Setup

        // Run the test
        final int result = jumpGameUnderTest.jump(new int[]{0});

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    void testCanReach1() {
        // Setup

        // Run the test
        final boolean result = jumpGameUnderTest.canReach(new int[]{0}, 0);

        // Verify the results
        assertTrue(result);
    }

    @Test
    void testMaxResult() {
        // Setup

        // Run the test
        final int result = jumpGameUnderTest.maxResult(new int[]{0}, 0);

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    void testMaxJumps() {
        // Setup

        // Run the test
        final int result = jumpGameUnderTest.maxJumps(new int[]{0}, 0);

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    void testMinJumps() {
        // Setup

        // Run the test
        final int result = jumpGameUnderTest.minJumps(new int[]{0});

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    void testCanReach2() {
        // Setup

        // Run the test
        final boolean result = jumpGameUnderTest.canReach("s", 0, 0);

        // Verify the results
        assertTrue(result);
    }
}
