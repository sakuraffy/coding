package top.sakuraffy.offer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import top.sakuraffy.commom.TreeNode;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TreeSolutionTest {

    private TreeSolution treeSolutionUnderTest;

    @BeforeEach
    void setUp() {
        treeSolutionUnderTest = new TreeSolution();
    }

    @Test
    void testBuildTreeWithPreAndIn() {
        final TreeNode root = TreeNode.create(Arrays.asList(3,9,20,null,null,15,7));
        final TreeNode result = treeSolutionUnderTest.buildTreeWithPreAndIn(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
        assertEquals(root.toString(), result.toString());
    }

    @Test
    void testBuildTreeWithPostAndIn() {
        final TreeNode root = TreeNode.create(Arrays.asList(3,9,20,null,null,15,7));
        final TreeNode result = treeSolutionUnderTest.buildTreeWithPostAndIn(new int[]{9,15,7,20,3}, new int[]{9,3,15,20,7});
        assertEquals(root.toString(), result.toString());
    }

    @Test
    void testIsSubStructure() {
        final TreeNode head1 = TreeNode.create(Arrays.asList(1,2,3));
        final TreeNode head2 = TreeNode.create(Arrays.asList(3,1));
        final boolean result = treeSolutionUnderTest.isSubStructure(head1, head2);
        assertFalse(result);
    }

    @Test
    void testPathSum() {
        final TreeNode root = TreeNode.create(Arrays.asList(5,4,8,11,null,13,4,7,2,null,null,5,1));
        final List<List<Integer>> result = treeSolutionUnderTest.pathSum(root, 22);
        assertEquals(Arrays.asList(Arrays.asList(5,4,11,2), Arrays.asList(5,8,4,5)), result);
        final TreeNode root1 = TreeNode.create(Arrays.asList(1,2));
        final List<List<Integer>> result1 = treeSolutionUnderTest.pathSum(root1, 1);
        assertEquals(Arrays.asList(), result1);
    }

    @Test
    void testTreeToDoublyList() {
//        final TreeNode root = TreeNode.createBST(Arrays.asList(1,3,5,6,2,8,7));
//        final TreeNode result = treeSolutionUnderTest.treeToDoublyList(root);
//        assertEquals(root.toString(), result.toString());
    }

    @Test
    void testIsBalanced() {
        final TreeNode root = TreeNode.create(Arrays.asList(1,2,2,3,3,null,null,4,4));
        final boolean result = treeSolutionUnderTest.isBalanced(root);
        final boolean result1 = treeSolutionUnderTest.isBalancedWithUpToDown(root);
        assertFalse(result);
        assertFalse(result1);
    }

    @Test
    void testKthLargest() {
        final TreeNode root = TreeNode.createBST(Arrays.asList(1,4,3,2,6,7,8));
        final int result = treeSolutionUnderTest.kthLargest(root, 2);
        assertEquals(7, result);
    }

    @Test
    void testIsSymmetric() {
        final TreeNode root = TreeNode.create(Arrays.asList(1,2,2,3,4,4,3));
        final boolean result = treeSolutionUnderTest.isSymmetric(root);
        assertTrue(result);
        final TreeNode root1 = TreeNode.create(Arrays.asList(1,2,2,null,3,null,3));
        final boolean result1 = treeSolutionUnderTest.isSymmetric(root1);
        assertFalse(result1);
    }

    @Test
    void testLowestCommonAncestor() {
        final TreeNode root = TreeNode.create(Arrays.asList(6,2,8,0,4,7,9,null,null,3,5));
        final TreeNode result = treeSolutionUnderTest.lowestCommonAncestor(root, root.left, root.right);
        assertEquals(root.toString(), result.toString());
    }

    @Test
    void testLevelOrder() {
        final TreeNode root = TreeNode.create(Arrays.asList(6,2,8,0,4,7,9,null,null,3,5));
        final int[] result = treeSolutionUnderTest.levelOrder(root);
        assertArrayEquals(new int[]{6,2,8,0,4,7,9,3,5}, result);
    }

    @Test
    void testRealLevelOrder() {
        final TreeNode root = TreeNode.create(Arrays.asList(6,2,8,0,4,7,9,null,null,3,5));
        final List<List<Integer>> result = treeSolutionUnderTest.realLevelOrder(root);
        assertEquals(Arrays.asList(Arrays.asList(6), Arrays.asList(2,8),
                Arrays.asList(0,4,7,9), Arrays.asList(3,5)).toString(), result.toString());
    }

    @Test
    void testZigLevelOrder() {
        final TreeNode root = TreeNode.create(Arrays.asList(6,2,8,0,4,7,9,null,null,3,5));
        final List<List<Integer>> result = treeSolutionUnderTest.zigLevelOrder(root);
        assertEquals(Arrays.asList(Arrays.asList(6), Arrays.asList(8,2),
                Arrays.asList(0,4,7,9), Arrays.asList(5,3)).toString(), result.toString());
    }

    @Test
    void testMaxDepth() {
        final TreeNode root = TreeNode.create(Arrays.asList(3,9,20,null,null,15,7));
        final int result = treeSolutionUnderTest.maxDepth(root);
        assertEquals(3, result);
    }

    @Test
    void testMirrorTree() {
        final TreeNode root = TreeNode.create(Arrays.asList(4,2,7,1,3,6,9));
        final TreeNode result = treeSolutionUnderTest.mirrorTree(root);
        assertEquals(TreeNode.create(Arrays.asList(4,7,2,9,6,3,1)).toString(), result.toString());
    }

    @Test
    void testVerifyPostorder() {
        final boolean result = treeSolutionUnderTest.verifyPostorder(new int[]{4,3,7,8,6});
        assertTrue(result);
        final boolean result1 = treeSolutionUnderTest.verifyPostorderWithStack(new int[]{4,3,7,8,6});
        assertTrue(result1);
    }
}
