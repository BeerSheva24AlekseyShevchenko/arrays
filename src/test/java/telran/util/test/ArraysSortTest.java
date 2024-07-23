package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;
import static telran.util.Arrays.*;

import java.util.Comparator;

import org.junit.jupiter.api.Test;
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
        // simple case Integer
        Integer[] arrInt = {7, -8, 10, -3, -100, 13, -10, 99};
        Integer[] arrIntExpected = {-100, -10, -8, 10, 99, 13, 7, -3};
        sort(arrInt, (o1, o2) -> {
            int res;
            boolean isEvenO1 = o1 % 2 == 0;
            boolean isEvenO2 = o2 % 2 == 0;
    
            if (isEvenO1 == isEvenO2) {
                int cmp = Integer.compare(o1, o2);
                res = isEvenO1 ? cmp : -cmp;
            } else {
                res = isEvenO1 ? -1 : 1;
            }
    
            return res;
        });
        assertArrayEquals(arrInt, arrIntExpected);

        // simple case String
        String[] arrStr = new String[] {"lmn", "cftb", "w", "aa"};
        String[] arrStrExpected1 = new String[] {"aa", "cftb", "lmn", "w"};
        String[] arrStrExpected2 = new String[] {"w", "aa", "lmn", "cftb"};
        sort(arrStr, (String a, String b) -> a.compareTo(b));
        assertArrayEquals(arrStr, arrStrExpected1);
        sort(arrStr, (String a, String b) -> a.length() - b.length());
        assertArrayEquals(arrStr, arrStrExpected2);

        // random cases
        sortTypeCmpTest0(randomArray.createInteger(), Integer::compare);
        sortTypeCmpTest0(randomArray.createString(), (String a, String b) -> a.compareTo(b));
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
        Integer[] arrInt1 = new Integer[] {-3, 0, 3, 6, 9};
        Integer[] arrInt2 = new Integer[] {6, 0, -3, 9, 3};
        assertTrue(isSorted(arrInt1, Integer::compare));
        assertFalse(isSorted(arrInt2, Integer::compare));

        // random cases
        isSortedTypeTest0(randomArray.createInteger(), Integer::compare);
        isSortedTypeTest0(randomArray.createString(), (String a, String b) -> a.compareTo(b));
    }

    private <T> void isSortedTypeTest0(T[] arr, Comparator<T> cmp) {
        assertFalse(isSorted(arr, cmp));
        sort(arr, cmp);
        assertTrue(isSorted(arr, cmp));
    }
}
