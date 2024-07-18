package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;
import static telran.util.Arrays.*;

import org.junit.jupiter.api.Test;

import telran.util.test.helpers.*;

public class ArraysInsertTest {
    private RandomArray randomArray = new RandomArray(1000);

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
}
