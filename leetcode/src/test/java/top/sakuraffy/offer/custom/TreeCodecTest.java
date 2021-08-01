package top.sakuraffy.offer.custom;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import top.sakuraffy.commom.TreeNode;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TreeCodecTest {

    private TreeCodec treeCodecUnderTest;

    @BeforeEach
    void setUp() {
        treeCodecUnderTest = new TreeCodec();
    }

    @Test
    void testSerialize() {
        final TreeNode root = TreeNode.create(Arrays.asList(1,2,3,4,null,null,5));
        final String result = treeCodecUnderTest.serialize(root);
        assertEquals("1 2 3 4 null null 5", result);
    }

    @Test
    void testDeserialize() {
        final TreeNode root = TreeNode.create(Arrays.asList(1,2,3,4,null,null,5));
        final TreeNode result = treeCodecUnderTest.deserialize("1 2 3 4 null null 5");
        assertEquals(root.toString(), result.toString());
    }

}
