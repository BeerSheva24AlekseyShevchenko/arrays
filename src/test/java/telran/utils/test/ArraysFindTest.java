package telran.utils.test;

import static org.junit.jupiter.api.Assertions.*;
import static telran.utils.Arrays.*;

import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

import telran.utils.test.helpers.*;

public class ArraysFindTest {
    private RandomArray randomArray = new RandomArray(1000);

    @Test
    void findTypeTest() {
        Predicate<Integer> predicateOddNumbers = (a) -> a % 2 != 0;

        // simple cases
        Integer[] array = {7, -8, 10, -100, 13, -10, 99};
        Integer[] expected = {7, 13, 99};
        assertArrayEquals(expected, find(array, predicateOddNumbers));

        // random cases
        findTypeTest0(randomArray.createInteger(), predicateOddNumbers);
    }

    private <T> void findTypeTest0(T[]arr, Predicate<T> predicate) {
        T[] result = find(arr, predicate);
        for (int i = 0; i < result.length; i++) {
            assertTrue(predicate.test(result[i]));
        }
    }
}
