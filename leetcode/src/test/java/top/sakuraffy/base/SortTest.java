package top.sakuraffy.base;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SortTest {

    private Sort sortUnderTest;

    @BeforeEach
    void setUp() {
        sortUnderTest = new Sort();
    }

    @Test
    void testBubbleSort() {
        final int[] result = sortUnderTest.bubbleSort(new int[]{1,3,2,4,5,6,8,7,9,0});
        assertArrayEquals(new int[]{0,1,2,3,4,5,6,7,8,9}, result);
    }

    @Test
    void testQuickSort() {
        final int[] result = sortUnderTest.quickSort(new int[]{1,3,2,4,5,6,8,7,9,0});
        assertArrayEquals(new int[]{0,1,2,3,4,5,6,7,8,9}, result);
    }

    @Test
    void testSelectSort() {
        final int[] result = sortUnderTest.selectSort(new int[]{1,3,2,4,5,6,8,7,9,0});
        assertArrayEquals(new int[]{0,1,2,3,4,5,6,7,8,9}, result);
    }

    @Test
    void testHeapSort() {
        final int[] result = sortUnderTest.heapSort(new int[]{1,3,2,4,5,6,8,7,9,0});
        assertArrayEquals(new int[]{0,1,2,3,4,5,6,7,8,9}, result);
    }

    @Test
    void testInsertSort() {
        final int[] result = sortUnderTest.insertSort(new int[]{1,3,2,4,5,6,8,7,9,0});
        assertArrayEquals(new int[]{0,1,2,3,4,5,6,7,8,9}, result);
    }

    @Test
    void testShellSort() {
        final int[] result = sortUnderTest.shellSort(new int[]{1,3,2,4,5,6,8,7,9,0});
        assertArrayEquals(new int[]{0,1,2,3,4,5,6,7,8,9}, result);
    }

    @Test
    void testMergeSort() {
        final int[] result = sortUnderTest.mergeSort(new int[]{1,3,2,4,5,6,8,7,9,0});
        assertArrayEquals(new int[]{0,1,2,3,4,5,6,7,8,9}, result);
    }

    @Test
    void testRadixSort() {
        final int[] result = sortUnderTest.radixSort(new int[]{1,3,2,4,5,6,8,7,9,0});
        assertArrayEquals(new int[]{0,1,2,3,4,5,6,7,8,9}, result);
    }
}
