package top.sakuraffy.same;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import top.sakuraffy.commom.TreeNode;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PathTest {

    private Path pathUnderTest;

    @BeforeEach
    void setUp() {
        pathUnderTest = new Path();
    }

    @Test
    void testHasPathSum() {
        final TreeNode root1 = TreeNode.create(Arrays.asList(5,4,8,11,null,13,4,7,2,null,null,null,1));
        final boolean result1 = pathUnderTest.hasPathSum(root1, 22);
        assertTrue(result1);
    }

    @Test
    void testPathSum() {
        final TreeNode root1 = TreeNode.create(Arrays.asList(5,4,8,11,null,13,4,7,2,null,null,5,1));
        final List<List<Integer>> result1 = pathUnderTest.pathSum(root1, 22);
        assertEquals(Arrays.asList(Arrays.asList(5,4,11,2), Arrays.asList(5,8,4,5)), result1);
    }

    @Test
    void testPathSumCount() {
        final TreeNode root1 = TreeNode.create(Arrays.asList(10,5,-3,3,2,null,11,3,-2,null,1));
        final int result1 = pathUnderTest.pathSumCount(root1, 8);
        assertEquals(3, result1);
        final int result2 = pathUnderTest.pathSumCountWithMap(root1, 8);
        assertEquals(3, result2);
    }

    @Test
    void testMaxPathSum1() {
        // Setup
        final TreeNode root = new TreeNode(0);

        // Run the test
        final int result = pathUnderTest.maxPathSum(root);

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    void testUniquePathsWithObstacles() {
        final int[][] obstacleGrid = new int[][]{{0,0,0}, {0,1,0}, {0,0,0}};
        final int result = pathUnderTest.uniquePathsWithObstacles(obstacleGrid);
        assertEquals(2, result);
    }

    @Test
    void testMinPathSum() {
        final int[][] grid = new int[][]{{1,3,1}, {1,5,1}, {4,2,1}};
        final int result = pathUnderTest.minPathSum(grid);
        assertEquals(7, result);
    }

    @Test
    void testMinFallingPathSum() {
        // Setup
        final int[][] matrix = new int[][]{{0}};

        // Run the test
        final int result = pathUnderTest.minFallingPathSum(matrix);

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    void testUniquePathsIII() {
        final int[][] grid = new int[][]{{1,0,0,0}, {0,0,0,0}, {0,0,2,-1}};
        final int result = pathUnderTest.uniquePathsIII(grid);
        assertEquals(2, result);
    }

    @Test
    void testLongestUnivaluePath() {
        // Setup
        final TreeNode root = new TreeNode(0);

        // Run the test
        final int result = pathUnderTest.longestUnivaluePath(root);

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    void testShortestPathBinaryMatrix() {
        // Setup
        final int[][] grid = new int[][]{{0}};

        // Run the test
        final int result = pathUnderTest.shortestPathBinaryMatrix(grid);

        // Verify the results
        assertEquals(0, result);
    }

    @Test
    void testLongestIncreasingPath() {
        // Setup
        final int[][] matrix = new int[][]{{0}};

        // Run the test
        final int result = pathUnderTest.longestIncreasingPath(matrix);

        // Verify the results
        assertEquals(0, result);
    }
}
