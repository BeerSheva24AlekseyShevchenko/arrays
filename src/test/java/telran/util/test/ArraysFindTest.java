package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;
import static telran.util.Arrays.*;

import org.junit.jupiter.api.Test;

import telran.util.test.comparators.*;

public class ArraysFindTest {
    @Test
    void findTest() {
        Integer[] array = {7, -8, 10, -100, 13, -10, 99};
        Integer [] expected = {7, 13, 99};
        assertArrayEquals(expected, find(array, new PredicateOddNumbers()));
    }
}
