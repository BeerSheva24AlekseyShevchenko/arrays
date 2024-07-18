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
        int[] arr = randomArray.createInt();
        sort(arr);

        for(int i = 0; i < arr.length - 1; i++) {
            assertTrue(arr[i] <= arr[i + 1]);
        }
    }

    @Test
    void sortTypeTest() {
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
        Integer[] arr = {7, -8, 10, -100, 13, -10, 99};
        Integer[] expectedArr = {-100, -10, -8, 10, 99, 13, 7};
        sort(arr, new ComparatorEvenOdd());
        assertArrayEquals(arr, expectedArr);

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
    void sortObjectTest() {
        sortObjectTest0(randomArray.createInteger());
        sortObjectTest0(randomArray.createString());
        sortObjectTest0(randomArray.createInteger());
    }

    private void sortObjectTest0(Object[] arr) {
        sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            @SuppressWarnings("rawtypes")
            Comparable val = (Comparable)arr[i];
            @SuppressWarnings("unchecked")
            int cmp = val.compareTo(arr[i + 1]);
            assertTrue(cmp <= 0);
        }
    }

    @Test
    void isSortedIntTest() {
        int[] arr = randomArray.createInt();
        assertFalse(isSorted(arr));
        sort(arr);
        assertTrue(isSorted(arr));
    }

    @Test
    void isSortedTypeTest() {
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

    @Test
    void isSortedObjectTest() {
        isSortedObjectTest0(randomArray.createInteger());
        isSortedObjectTest0(randomArray.createString());
    }

    private void isSortedObjectTest0(Object[] arr) {
        assertFalse(isSorted(arr));
        sort(arr);
        assertTrue(isSorted(arr));
    }
}
