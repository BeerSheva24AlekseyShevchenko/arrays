package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;
import static telran.util.Arrays.*;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import telran.util.test.comparators.*;
import telran.util.test.helpers.*;

public class ArraysSortTest {
    private RandomArray randomArray = new RandomArray(1000);

    @Test
    void sortIntTest() {
        // simple cases
        int[] arr = new int[] {9, -3, 6, 0, 3};
        sort(arr);
        int[] expectedArr = new int[] {-3, 0, 3, 6, 9};
        assertArrayEquals(arr, expectedArr);

        // random cases
        sortIntTest0(randomArray.createInt());
    }

    private void sortIntTest0(int[] arr) {
        sort(arr);
        for(int i = 0; i < arr.length - 1; i++) {
            assertTrue(arr[i] <= arr[i + 1]);
        }
    }

    @Test
    void sortTypeTest() {
        // simple cases
        Integer[] arr = new Integer[] {9, -3, 6, 0, 3};
        sort(arr);
        Integer[] expectedArr = new Integer[] {-3, 0, 3, 6, 9};
        assertArrayEquals(arr, expectedArr);

        // random cases
        sortTypeTest0(randomArray.createInteger());
        sortTypeTest0(randomArray.createString());
        sortTypeTest0(randomArray.createString());
    }

    private <T extends Comparable<T>> void sortTypeTest0(T[] arr) {
        sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            assertTrue(arr[i].compareTo(arr[i + 1]) <= 0);
        }
    }

    @Test
    void sortTypeCmpTest() {
        // simple cases
        Integer[] arr = {7, -8, 10, -100, 13, -10, 99};
        Integer[] expectedArr = {-100, -10, -8, 10, 99, 13, 7};
        sort(arr, new ComparatorEvenOdd());
        assertArrayEquals(arr, expectedArr);

        // random cases
        sortTypeCmpTest0(randomArray.createInteger(), Integer::compare);
        sortTypeCmpTest0(randomArray.createInteger(), new ComparatorEvenOdd());
        sortTypeCmpTest0(randomArray.createString(), new ComparatorASCII());
        sortTypeCmpTest0(randomArray.createString(), new ComparatorLength());
    }

    private <T> void sortTypeCmpTest0(T[] arr, Comparator<T> cmp) {
        sort(arr, cmp);
        for (int i = 0; i < arr.length - 1; i++) {
            assertTrue(cmp.compare(arr[i], arr[i + 1]) <= 0);
        }
    }

    @Test
    void isSortedIntTest() {
        // simple cases
        int[] arr1 = {-3, 0, 3, 6, 9};
        int[] arr2 = {6, 0, -3, 9, 3};
        assertTrue(isSorted(arr1));
        assertFalse(isSorted(arr2));

        // random cases
        isSortedIntTest0(randomArray.createInt());
    }

    private void isSortedIntTest0(int[] arr) {
        assertFalse(isSorted(arr));
        sort(arr);
        assertTrue(isSorted(arr));
    }

    @Test
    void isSortedTypeTest() {
        // simple cases
        Integer[] arr1 = new Integer[] {-3, 0, 3, 6, 9};
        Integer[] arr2 = new Integer[] {6, 0, -3, 9, 3};
        assertTrue(isSorted(arr1, Integer::compare));
        assertFalse(isSorted(arr2, Integer::compare));

        // random cases
        isSortedTypeTest0(randomArray.createInteger(), Integer::compare);
        isSortedTypeTest0(randomArray.createInteger(), new ComparatorEvenOdd());
        isSortedTypeTest0(randomArray.createString(), new ComparatorASCII());
        isSortedTypeTest0(randomArray.createString(), new ComparatorLength());
    }

    private <T> void isSortedTypeTest0(T[] arr, Comparator<T> cmp) {
        assertFalse(isSorted(arr, cmp));
        sort(arr, cmp);
        assertTrue(isSorted(arr, cmp));
    }
}
