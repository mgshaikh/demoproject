package org.learn;

// Create JUNIT5 TEST CASES for methods present in ArrayUtil.java
// Given when then syntax for writing method names
// At least 3 test case covering all scenarios for each method

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ArrayUtilTest {

    @Test
    public void testSortArray() {
        int[] arr = {1, 5, 3, 2, 4};
        int[] expected = {1, 2, 3, 4, 5};
        int[] actual = ArrayUtil.sortArray(arr);
        Assertions.assertArrayEquals(expected, actual);
    }

    // test case for empty array
    @Test
    public void testSortArrayEmpty() {
        int[] arr = {};
        int[] expected = {};
        int[] actual = ArrayUtil.sortArray(arr);
        Assertions.assertArrayEquals(expected, actual);
    }

    // test case for array with one element
    @Test
    public void testSortArrayOneElement() {
        int[] arr = {1};
        int[] expected = {1};
        int[] actual = ArrayUtil.sortArray(arr);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testReverseArray() {
        int[] arr = {1, 5, 3, 2, 4};
        int[] expected = {4, 2, 3, 5, 1};
        int[] actual = ArrayUtil.reverseArray(arr);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testGetMap() {
        List<String> list = Arrays.asList("abc", "def", "ghi");
        Map<String, Integer> expected = new HashMap<>();
        expected.put("abc", 3);
        expected.put("def", 3);
        expected.put("ghi", 3);
        Map<String, Integer> actual = ArrayUtil.getMap(list);
        Assertions.assertEquals(expected, actual);
    }
}
