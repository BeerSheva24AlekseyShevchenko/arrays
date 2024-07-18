package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;
import static telran.util.Arrays.*;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.jupiter.api.Test;

import telran.util.test.comparators.*;
import telran.util.test.helpers.*;

public class ArraysSearchTest {
    private RandomArray randomArray = new RandomArray(1000);

    @Test
    void searchTest() {
        int[] arr = new int[] {9, 6, 12, 3, 15};
        
        assertEquals(0, search(arr, arr[0]));
        assertEquals(2, search(arr, arr[2]));
        assertEquals(4, search(arr, arr[4]));
        assertEquals(-1, search(arr, 999));
    }

    @Test
    void binarySearchIntTest() {
        int[] arr = randomArray.createInt();
        sort(arr);

        assertEquals(0, binarySearch(arr, arr[0]));
        assertEquals(arr.length / 4, binarySearch(arr, arr[arr.length / 4]));
        assertEquals(arr.length / 2, binarySearch(arr, arr[arr.length / 2]));
        assertEquals(arr.length - 1, binarySearch(arr, arr[arr.length - 1]));

        int[] arr2 = Arrays.copyOfRange(arr, 0, arr.length - 1);
        assertEquals(-arr.length, binarySearch(arr2, arr[arr.length - 1]));

        int[] arr3 = Arrays.copyOfRange(arr, 1, arr.length);
        assertEquals(-1, binarySearch(arr3, arr[0]));

        int[] arr4 = new int[0];
        assertEquals(-1, binarySearch(arr4, arr[0]));
    }

    @Test
    void binarySearchTypeTest() {
        binarySearchTypeTest0(randomArray.createString());
        binarySearchTypeTest0(randomArray.createInteger());
        binarySearchTypeTest0(randomArray.createPersons());
    }

    private <T extends Comparable<T>> void binarySearchTypeTest0 (T[] arr) {
        sort(arr);

        assertEquals(0, binarySearch(arr, arr[0]));
        assertEquals(arr.length / 4, binarySearch(arr, arr[arr.length / 4]));
        assertEquals(arr.length / 2, binarySearch(arr, arr[arr.length / 2]));
        assertEquals(arr.length - 1, binarySearch(arr, arr[arr.length - 1]));

        T[] arr2 = Arrays.copyOfRange(arr, 0, arr.length - 1);
        assertEquals(-arr.length, binarySearch(arr2, arr[arr.length - 1]));

        T[] arr3 = Arrays.copyOfRange(arr, 1, arr.length);
        assertEquals(-1, binarySearch(arr3, arr[0]));

        T[] arr4 = Arrays.copyOf(arr, 0);
        assertEquals(-1, binarySearch(arr4, arr[0]));
    }

    @Test
    void binarySearchTypeCmpTest() {
        binarySearchTypeCmpTest0(randomArray.createInteger(), Integer::compare);
        binarySearchTypeCmpTest0(randomArray.createString(), new ComparatorASCII());
    }

    private <T> void binarySearchTypeCmpTest0 (T[] arr, Comparator<T> cmp) {
        sort(arr, cmp);

        assertEquals(0, binarySearch(arr, arr[0], cmp));
        assertEquals(arr.length / 4, binarySearch(arr, arr[arr.length / 4], cmp));
        assertEquals(arr.length / 2, binarySearch(arr, arr[arr.length / 2], cmp));
        assertEquals(arr.length - 1, binarySearch(arr, arr[arr.length - 1], cmp));

        T[] arr2 = Arrays.copyOfRange(arr, 0, arr.length - 1);
        assertEquals(-arr.length, binarySearch(arr2, arr[arr.length - 1], cmp));

        T[] arr3 = Arrays.copyOfRange(arr, 1, arr.length);
        assertEquals(-1, binarySearch(arr3, arr[0], cmp));

        @SuppressWarnings("unchecked")
        T[] arr4 = (T[]) new Object[0];
        assertEquals(-1, binarySearch(arr4, arr[0], cmp));
    }

    @Test
    void binarySearchObjectTest() {
        binarySearchObjectRandomTest0(randomArray.createString());
        binarySearchObjectRandomTest0(randomArray.createPersons());

    }

    private void binarySearchObjectRandomTest0 (Object[] arr) {
        sort(arr);

        assertEquals(0, binarySearch(arr, arr[0]));
        assertEquals(arr.length / 4, binarySearch(arr, arr[arr.length / 4]));
        assertEquals(arr.length / 2, binarySearch(arr, arr[arr.length / 2]));
        assertEquals(arr.length - 1, binarySearch(arr, arr[arr.length - 1]));

        Object[] arr2 = Arrays.copyOfRange(arr, 0, arr.length - 1);
        assertEquals(-arr.length, binarySearch(arr2, arr[arr.length - 1]));

        Object[] arr3 = Arrays.copyOfRange(arr, 1, arr.length);
        assertEquals(-1, binarySearch(arr3, arr[0]));

        Object[] arr4 = new Object[0];
        assertEquals(-1, binarySearch(arr4, arr[0]));
    }
}
