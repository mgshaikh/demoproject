package org.learn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ArrayUtil {

    /*static method sortArray to take array of numbers as input and return a sorted array in ascending order using bubble sort algorithm.
    * provide optimized version if array is already sorted*/
    public static int[] sortArray(int[] arr) {
        int temp;
        boolean isSorted = false;
        for(int i = 0; i < arr.length; i++) {
            isSorted = true;
            for(int j = 0; j < arr.length-i-1; j++) {
                if(arr[j] > arr[j+1]) {
                    /*Swapping*/
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    isSorted = false;
                }
            }
            if(isSorted) {
                break;
            }
        }
        return arr;
    }


    /*static method reverseArray to take array of numbers as input and return a reversed array*/
    public static int[] reverseArray(int[] arr) {
        int[] reversedArray = new int[arr.length];
        int reversedArrayIndex = arr.length - 1;
        for(int index = 0; index < arr.length; index++) {
            reversedArray[reversedArrayIndex] = arr[index];
            reversedArrayIndex--;
        }
        return reversedArray;
    }

//    static method to take a list of uniques string as input and return a map with key as the string and the value as the length of the string
//     using streams and using collect method of stream
    public static Map<String, Integer> getMap(List<String> list) {
        Map<String, Integer> map = list.stream()
                .collect(HashMap::new, (m, v) -> m.put(v, v.length()), HashMap::putAll);
        return map;
    }



//    main method to test the above
    public static void main(String[] args) {
        int[] arr = {9, 2, 1, 5, 7, 4, 8, 6, 3};
        int[] sortedArray = sortArray(arr);
        int[] reversedArray = reverseArray(arr);
        System.out.println("Sorted Array:");

//        use stream to print array
        Arrays.stream(sortedArray).forEach(System.out::println);

        System.out.println("Reversed Array:");
        Arrays.stream(reversedArray).forEach(System.out::println);

    }

}
