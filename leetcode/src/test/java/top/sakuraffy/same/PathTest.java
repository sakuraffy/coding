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
    void testMaxPathSum() {
        final TreeNode root = TreeNode.create(Arrays.asList(1,2,3));
        final int result = pathUnderTest.maxPathSum(root);
        assertEquals(6, result);
        final TreeNode root2 = TreeNode.create(Arrays.asList(-10,9,20,null,null,15,7));
        final int result2 = pathUnderTest.maxPathSum(root2);
        assertEquals(42, result2);
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
        final int[][] matrix1 = new int[][]{{2,1,3},{6,5,4},{7,8,9}};
        final int result1 = pathUnderTest.minFallingPathSum(matrix1);
        assertEquals(13, result1);
        final int[][] matrix2 = new int[][]{{-19,57},{-40,-5}};
        final int result2 = pathUnderTest.minFallingPathSum(matrix2);
        assertEquals(-59, result2);
    }

    @Test
    void testUniquePathsIII() {
        final int[][] grid = new int[][]{{1,0,0,0}, {0,0,0,0}, {0,0,2,-1}};
        final int result = pathUnderTest.uniquePathsIII(grid);
        assertEquals(2, result);
    }

    @Test
    void testLongestUnivaluePath() {
        final int result1 = pathUnderTest.longestUnivaluePath(TreeNode.create(Arrays.asList(5,4,5,1,1,5)));
        assertEquals(2, result1);
        final int result2 = pathUnderTest.longestUnivaluePath(TreeNode.create(Arrays.asList(1,4,5,4,4,5)));
        assertEquals(2, result2);
    }

    @Test
    void testShortestPathBinaryMatrix() {
        final int[][] grid1 = new int[][]{{0,0,0}, {1,1,0}, {1,1,0}};
        final int result1 = pathUnderTest.shortestPathBinaryMatrix(grid1);
        assertEquals(4, result1);
        final int[][] grid2 = new int[][]{{1,0,0}, {1,1,0}, {1,1,0}};
        final int result2 = pathUnderTest.shortestPathBinaryMatrix(grid2);
        assertEquals(-1, result2);
        final int[][] grid3 = new int[][]{{0,1}, {1,0}};
        final int result3 = pathUnderTest.shortestPathBinaryMatrix(grid3);
        assertEquals(2, result3);
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
