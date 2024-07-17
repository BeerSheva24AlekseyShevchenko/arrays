package telran.util.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static telran.util.Arrays.*;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysTest {
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
    void sortIntTest() {
        int[] arr = sort(randomArray.createInt());

        for(int i = 0; i < arr.length - 1; i++) {
            assertTrue(arr[i] <= arr[i + 1]);
        }
    }

    @Test
    void sortTypeTest() {
        String [] strings = {"lmn", "cfta", "w", "aa"};
        String [] expectedASCII ={"aa", "cfta", "lmn", "w"};
        String [] expectedLength = {"w", "aa", "lmn", "cfta"};
        assertArrayEquals(expectedASCII,  sort(strings, new ComparatorASCII()));
        assertArrayEquals(expectedLength, sort(strings, new ComparatorLength()));
    }

    @Test
    void binarySearchIntTest() {
        int[] arr = sort(randomArray.createInt());

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
        // Test Integer
        Comparator<Integer> cmpInteger = Integer::compare;
        Integer[] arrInteger = sort(randomArray.createInteger(), cmpInteger);

        assertEquals(0, binarySearch(arrInteger, arrInteger[0], cmpInteger));
        assertEquals(arrInteger.length / 4, binarySearch(arrInteger, arrInteger[arrInteger.length / 4], cmpInteger));
        assertEquals(arrInteger.length / 2, binarySearch(arrInteger, arrInteger[arrInteger.length / 2], cmpInteger));
        assertEquals(arrInteger.length - 1, binarySearch(arrInteger, arrInteger[arrInteger.length - 1], cmpInteger));

        Integer[] arrInteger2 = Arrays.copyOfRange(arrInteger, 0, arrInteger.length - 1);
        assertEquals(-arrInteger.length, binarySearch(arrInteger2, arrInteger[arrInteger.length - 1], cmpInteger));

        Integer[] arrInteger3 = Arrays.copyOfRange(arrInteger, 1, arrInteger.length);
        assertEquals(-1, binarySearch(arrInteger3, arrInteger[0], cmpInteger));

        Integer[] arrInteger4 = new Integer[0];
        assertEquals(-1, binarySearch(arrInteger4, arrInteger[0], cmpInteger));

        // Test String
        Comparator<String> cmpString = new ComparatorASCII();
        String[] arrString = sort(randomArray.createString(), cmpString);

        assertEquals(0, binarySearch(arrString, arrString[0], cmpString));
        assertEquals(arrString.length / 4, binarySearch(arrString, arrString[arrString.length / 4], cmpString));
        assertEquals(arrString.length / 2, binarySearch(arrString, arrString[arrString.length / 2], cmpString));
        assertEquals(arrString.length - 1, binarySearch(arrString, arrString[arrString.length - 1], cmpString));

        String[] arrString2 = Arrays.copyOfRange(arrString, 0, arrString.length - 1);
        assertEquals(-arrInteger.length, binarySearch(arrString2, arrString[arrString.length - 1], cmpString));

        String[] arrString3 = Arrays.copyOfRange(arrString, 1, arrString.length);
        assertEquals(-1, binarySearch(arrString3, arrString[0], cmpString));

        String[] arrString4 = new String[0];
        assertEquals(-1, binarySearch(arrString4, arrString[0], cmpString));

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
    void isSortedTest() {
        assertTrue(isSorted(sort(randomArray.createInt())));
        assertFalse(isSorted(new int[] {-3, 0, 3, 6, 5}));
    }

    @Test
    void isOneSwapForSortedTest() {
        int[] arr = sort(randomArray.createInt());

        assertTrue(isOneSwapForSorted(swap(Arrays.copyOf(arr, arr.length), arr.length / 2, arr.length / 2 + 1)));
        assertTrue(isOneSwapForSorted(swap(Arrays.copyOf(arr, arr.length), arr.length / 2, arr.length - 1)));
        assertTrue(isOneSwapForSorted(swap(Arrays.copyOf(arr, arr.length), 0, arr.length - 1)));
        
        assertFalse(isOneSwapForSorted(arr));
        assertFalse(isOneSwapForSorted(new int[] {6, -3, 0, -6, 3}));
    }
}
