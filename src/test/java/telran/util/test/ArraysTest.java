package telran.util.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static telran.util.Arrays.*;

import java.util.Arrays;
import java.util.Random;

public class ArraysTest {
    private final static int TEST_ARRAY_LENGTH = 1_000;

    @Test
    void searchTest() {
        int[] arr = new int[] {9, 6, 12, 3, 15};
        
        assertEquals(0, search(arr, arr[0]));
        assertEquals(2, search(arr, arr[2]));
        assertEquals(4, search(arr, arr[4]));
        assertEquals(-1, search(arr, 999));
    }

    @Test
    void addTest() {
        assertArrayEquals(new int[] {9, 3, 6}, add(new int[] {9, 3}, 6));
        assertArrayEquals(new int[] {9}, add(new int[0], 9));
    }

    @Test
    void insertTest() {
        assertArrayEquals(new int[] {9, 3, 6}, insert(new int[] {3, 6}, 0, 9));
        assertArrayEquals(new int[] {9, 3, 6}, insert(new int[] {9, 6}, 1, 3));
        assertArrayEquals(new int[] {9, 3, 6}, insert(new int[] {9, 3}, 2, 6));
        assertArrayEquals(new int[] {9}, insert(new int[0], 0, 9));

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> insert(new int[1], -1, 1));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> insert(new int[1], 2, 1));
    }

    @Test
    void removeTest() {
        assertArrayEquals(new int[] {3, 6}, remove(new int[] {9, 3, 6}, 0));
        assertArrayEquals(new int[] {9, 6}, remove(new int[] {9, 3, 6}, 1));
        assertArrayEquals(new int[] {9, 3}, remove(new int[] {9, 3, 6}, 2));
        assertArrayEquals(new int[] {}, remove(new int[] {9}, 0));

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> remove(new int[] {9, 3, 6}, -1));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> remove(new int[] {9, 3, 6}, 3));
        assertThrows(NegativeArraySizeException.class, () -> remove(new int[0], 0));
    }

    @Test
    void swapTest() {
        assertArrayEquals(new int[] {9, 3, 6}, swap(new int[] {6, 3, 9}, 0, 2));
        assertArrayEquals(new int[] {9, 3, 6}, swap(new int[] {9, 6, 3}, 1, 2));
        assertArrayEquals(new int[] {9, 3, 6}, swap(new int[] {9, 3, 6}, 0, 0));

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> swap(new int[] {9, 3, 6}, 0, 10));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> swap(new int[] {9, 3, 6}, -1, 0));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> swap(new int[0], 0, 0));
    }

    @Test
    void sortTest() {
        int[] arr = getRandomArray(TEST_ARRAY_LENGTH);
        sort(arr);

        for(int i = 0; i < arr.length - 1; i++) {
            assertTrue(arr[i] <= arr[i + 1]);
        }
    }

    @Test
    void binarySearchTest() {
        int[] arr = getRandomArray(TEST_ARRAY_LENGTH);
        sort(arr);

        assertEquals(0, binarySearch(arr, arr[0]));
        assertEquals(TEST_ARRAY_LENGTH / 4, binarySearch(arr, arr[TEST_ARRAY_LENGTH / 4]));
        assertEquals(TEST_ARRAY_LENGTH / 2, binarySearch(arr, arr[TEST_ARRAY_LENGTH / 2]));
        assertEquals(TEST_ARRAY_LENGTH - 1, binarySearch(arr, arr[TEST_ARRAY_LENGTH - 1]));
        assertEquals(0, binarySearch(new int[] {1}, 1));

        assertEquals(-6, binarySearch(new int[] {-3, 0, 3, 6, 9}, 999));
        assertEquals(-3, binarySearch(new int[] {-3, 0, 3, 6, 9}, 2));
        assertEquals(-2, binarySearch(new int[] {-3, 0, 3, 6, 9}, -2));
        assertEquals(-1, binarySearch(new int[] {-3, 0, 3, 6, 9}, -999));
        assertEquals(-1, binarySearch(new int[0], 999));
    }

    @Test
    void insertSortedTest() {
        assertArrayEquals(new int[] {-3, 0, 3, 9}, insertSorted(new int[] {-3, 0, 3}, 9));
        assertArrayEquals(new int[] {-3, 0, 3, 3}, insertSorted(new int[] {-3, 0, 3}, 3));
        assertArrayEquals(new int[] {-3, 0, 2, 3}, insertSorted(new int[] {-3, 0, 3}, 2));
        assertArrayEquals(new int[] {-3, 0, 0, 3}, insertSorted(new int[] {-3, 0, 3}, 0));
        assertArrayEquals(new int[] {-3, -3, 0, 3}, insertSorted(new int[] {-3, 0, 3}, -3));
        assertArrayEquals(new int[] {-9, -3, 0, 3}, insertSorted(new int[] {-3, 0, 3}, -9));
    }

    @Test
    void isSortedTest() {
        assertTrue(isSorted(sort(getRandomArray(TEST_ARRAY_LENGTH))));
        assertFalse(isSorted(new int[] {-3, 0, 3, 6, 5}));
    }

    @Test
    void isOneSwapForSortedTest() {
        int[] arr = sort(getRandomArray(TEST_ARRAY_LENGTH));

        assertTrue(isOneSwapForSorted(swap(Arrays.copyOf(arr, arr.length), TEST_ARRAY_LENGTH / 2, TEST_ARRAY_LENGTH / 2 + 1)));
        assertTrue(isOneSwapForSorted(swap(Arrays.copyOf(arr, arr.length), TEST_ARRAY_LENGTH / 2, TEST_ARRAY_LENGTH - 1)));
        assertTrue(isOneSwapForSorted(swap(Arrays.copyOf(arr, arr.length), 0, TEST_ARRAY_LENGTH - 1)));
        
        assertFalse(isOneSwapForSorted(arr));
        assertFalse(isOneSwapForSorted(new int[] {6, -3, 0, -6, 3}));
    }


    private int[] getRandomArray(int length) {
        int[] res = new int[length];

        Random random = new Random();

        for(int i = 0; i < length; i++) {
            res[i] = random.nextInt();
        }

        return res;
    }
}
