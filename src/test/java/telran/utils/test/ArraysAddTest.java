package telran.utils.test;

import static org.junit.jupiter.api.Assertions.*;
import static telran.utils.Arrays.*;

import org.junit.jupiter.api.Test;

public class ArraysAddTest {
    @Test
    void addTest() {
        assertArrayEquals(new int[] {9, 3, 6}, add(new int[] {9, 3}, 6));
        assertArrayEquals(new int[] {9}, add(new int[0], 9));
    }

    @Test
    void addTypeTest() {
        String[] strArr = {"1", "2", "3"};
        String[] strArrExpected = {"1", "2", "3", "4"};
        assertArrayEquals(strArrExpected, add(strArr, "4"));

        Integer[] intArr = {1, 2, 3};
        Integer[] intArrExpected = {1, 2, 3, 4};
        assertArrayEquals(intArrExpected, add(intArr, 4));
    }

}
