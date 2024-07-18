package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;
import static telran.util.Arrays.*;

import org.junit.jupiter.api.Test;

import telran.util.test.helpers.*;

public class ArraysSwapTest {
    private RandomArray randomArray = new RandomArray(1000);

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
