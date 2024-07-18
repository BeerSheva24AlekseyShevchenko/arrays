package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;
import static telran.util.Arrays.*;

import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

import telran.util.test.comparators.*;
import telran.util.test.helpers.*;

public class ArraysFindTest {
    private RandomArray randomArray = new RandomArray(1000);

    @Test
    void findTypeTest() {
        // simple cases
        Integer[] array = {7, -8, 10, -100, 13, -10, 99};
        Integer[] expected = {7, 13, 99};
        assertArrayEquals(expected, find(array, new PredicateOddNumbers()));

        // random cases
        findTypeTest0(randomArray.createInteger(), new PredicateOddNumbers());
    }

    private <T> void findTypeTest0(T[]arr, Predicate<T> predicate) {
        T[] result = find(arr, predicate);
        for (int i = 0; i < result.length; i++) {
            assertTrue(predicate.test(result[i]));
        }
    }
}
