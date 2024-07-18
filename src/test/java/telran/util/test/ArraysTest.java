package telran.util.test;

import org.junit.jupiter.api.Test;

import telran.util.test.helpers.*;

import static org.junit.jupiter.api.Assertions.*;
import static telran.util.Arrays.*;

public class ArraysTest {
    private RandomArray randomArray = new RandomArray(1000);

    @Test
    void addTest() {
        assertArrayEquals(new int[] {9, 3, 6}, add(new int[] {9, 3}, 6));
        assertArrayEquals(new int[] {9}, add(new int[0], 9));
    }

    @Test
    void insertIntTest() {
        assertArrayEquals(new int[] {9, 3, 6}, insert(new int[] {3, 6}, 0, 9));
        assertArrayEquals(new int[] {9, 3, 6}, insert(new int[] {9, 6}, 1, 3));
        assertArrayEquals(new int[] {9, 3, 6}, insert(new int[] {9, 3}, 2, 6));
        assertArrayEquals(new int[] {9}, insert(new int[0], 0, 9));

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> insert(new int[1], -1, 1));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> insert(new int[1], 2, 1));
    }

    @Test
    void insertTypeTest() {
        Integer[] arr = randomArray.createInteger();
        assertEquals(999, insert(arr, 0, 999)[0]);
        assertEquals(999, insert(arr, arr.length / 2, 999)[arr.length / 2]);
        assertEquals(999, insert(arr, arr.length, 999)[arr.length]);
        assertEquals(999, insert(new Integer[0], 0, 999)[0]);

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> insert(new Integer[1], -1, 1));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> insert(new Integer[1], 2, 1));
    }

    @Test
    void insertSortedIntTest() {
        assertArrayEquals(new int[] {-3, 0, 3, 9}, insertSorted(new int[] {-3, 0, 3}, 9));
        assertArrayEquals(new int[] {-3, 0, 3, 3}, insertSorted(new int[] {-3, 0, 3}, 3));
        assertArrayEquals(new int[] {-3, 0, 2, 3}, insertSorted(new int[] {-3, 0, 3}, 2));
        assertArrayEquals(new int[] {-3, 0, 0, 3}, insertSorted(new int[] {-3, 0, 3}, 0));
        assertArrayEquals(new int[] {-3, -3, 0, 3}, insertSorted(new int[] {-3, 0, 3}, -3));
        assertArrayEquals(new int[] {-9, -3, 0, 3}, insertSorted(new int[] {-3, 0, 3}, -9));
    }

    @Test
    void removeIntTest() {
        assertArrayEquals(new int[] {3, 6}, remove(new int[] {9, 3, 6}, 0));
        assertArrayEquals(new int[] {9, 6}, remove(new int[] {9, 3, 6}, 1));
        assertArrayEquals(new int[] {9, 3}, remove(new int[] {9, 3, 6}, 2));
        assertArrayEquals(new int[] {}, remove(new int[] {9}, 0));

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> remove(new int[] {9, 3, 6}, -1));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> remove(new int[] {9, 3, 6}, 3));
        assertThrows(NegativeArraySizeException.class, () -> remove(new int[0], 0));
    }

    @Test
    void swapIntTest() {
        assertArrayEquals(new int[] {9, 3, 6}, swap(new int[] {6, 3, 9}, 0, 2));
        assertArrayEquals(new int[] {9, 3, 6}, swap(new int[] {9, 6, 3}, 1, 2));
        assertArrayEquals(new int[] {9, 3, 6}, swap(new int[] {9, 3, 6}, 0, 0));

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> swap(new int[] {9, 3, 6}, 0, 10));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> swap(new int[] {9, 3, 6}, -1, 0));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> swap(new int[0], 0, 0));
    }

    @Test
    void isOneSwapForSortedTest() {
        int[] arr = randomArray.createInt();
        sort(arr);

        assertTrue(isOneSwapForSorted(swap(java.util.Arrays.copyOf(arr, arr.length), arr.length / 2, arr.length / 2 + 1)));
        assertTrue(isOneSwapForSorted(swap(java.util.Arrays.copyOf(arr, arr.length), arr.length / 2, arr.length - 1)));
        assertTrue(isOneSwapForSorted(swap(java.util.Arrays.copyOf(arr, arr.length), 0, arr.length - 1)));
        
        assertFalse(isOneSwapForSorted(arr));
        assertFalse(isOneSwapForSorted(new int[] {6, -3, 0, -6, 3}));
    }
}
