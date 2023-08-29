package org.learn;
/* create JUNIT5 tests to test the ArrayUtil class*/
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ArrayUtilTest {

    @Test
    public void testSortArray() {
        int[] arr = {9, 2, 1, 5, 7, 4, 8, 6, 3};
        int[] sortedArray = ArrayUtil.sortArray(arr);
        Assertions.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, sortedArray);
    }

    @Test
    public void testReverseArray() {
        int[] arr = {9, 2, 1, 5, 7, 4, 8, 6, 3};
        int[] reversedArray = ArrayUtil.reverseArray(arr);
        Assertions.assertArrayEquals(new int[]{3, 6, 8, 4, 7, 5, 1, 2, 9}, reversedArray);
    }

    @Test
    public void testGetMap() {
        List<String> list = Arrays.asList("abc", "def", "ghij");
        Map<String, Integer> map = ArrayUtil.getMap(list);
        Assertions.assertEquals(3, map.size());
        Assertions.assertEquals(3, map.get("abc"));
        Assertions.assertEquals(3, map.get("def"));
        Assertions.assertEquals(4, map.get("ghij"));
    }

/* test the sortArray method giving a sorted array as input*/
    @Test
    public void testSortArrayAlreadySorted() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] sortedArray = ArrayUtil.sortArray(arr);
        Assertions.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, sortedArray);
    }
}
