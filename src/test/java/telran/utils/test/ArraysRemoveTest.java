package telran.utils.test;

import static org.junit.jupiter.api.Assertions.*;
import static telran.utils.Arrays.*;

import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

import telran.utils.test.helpers.*;

public class ArraysRemoveTest {
    private RandomArray randomArray = new RandomArray(1000);

    @Test
    void removeIntTest() {
        // simple cases
        assertArrayEquals(new int[] {3, 6}, remove(new int[] {9, 3, 6}, 0));
        assertArrayEquals(new int[] {9, 6}, remove(new int[] {9, 3, 6}, 1));
        assertArrayEquals(new int[] {9, 3}, remove(new int[] {9, 3, 6}, 2));
        assertArrayEquals(new int[] {}, remove(new int[] {9}, 0));

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> remove(new int[] {9, 3, 6}, -1));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> remove(new int[] {9, 3, 6}, 3));
        assertThrows(NegativeArraySizeException.class, () -> remove(new int[0], 0));
    }

    @Test
    void removeTypeIfTest() {
        Predicate<Integer> predicateOddNumbers = (a) -> a % 2 != 0;

        // simple cases
        Integer[] arr = new Integer[] {-3, 0, 3, 6, 9};
        Integer[] expectedArr = new Integer[] {0, 6};
        Integer[] resultArray = removeIf(arr, predicateOddNumbers);
        assertArrayEquals(expectedArr, resultArray);

        // random cases
        removeIfTypeTest0(randomArray.createInteger(), predicateOddNumbers);
    }

    private <T> void removeIfTypeTest0(T[] arr, Predicate<T> predicate) {
        T[] result = removeIf(arr, predicate);
        for (int i = 0; i < result.length; i++) {
            assertFalse(predicate.test(result[i]));
        }
    }
}
