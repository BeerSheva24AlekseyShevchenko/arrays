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
        String [] strings = {"lmn", "cfta", "w", "aa"};
        String [] expectedASCII ={"aa", "cfta", "lmn", "w"};
        String [] expectedLength = {"w", "aa", "lmn", "cfta"};
        sort(strings, new ComparatorASCII());
        assertArrayEquals(expectedASCII,  strings);
        sort(strings, new ComparatorLength());
        assertArrayEquals(expectedLength, strings);
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
        isSortedTypeTest0(randomArray.createString(), new ComparatorASCII());
    }

    private <T> void isSortedTypeTest0(T[] arr, Comparator<T> cmp) {
        assertFalse(isSorted(arr, cmp));
        sort(arr, cmp);
        assertTrue(isSorted(arr, cmp));
    }
}
