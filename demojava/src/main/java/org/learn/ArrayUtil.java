package org.learn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ArrayUtil {

 
    // This code is an implementation of the bubble sort algorithm which sorts an array of integers in ascending order.
    // The bubble sort algorithm works by repeatedly swapping adjacent elements of an array if they are in the wrong order.
    // Each iteration of the outer loop moves the largest element of the unsorted portion of the array to the end of the unsorted portion.
    // The inner loop swaps any adjacent elements that are in the wrong order.
    // If no swaps are made in an iteration of the outer loop, the array is sorted and the algorithm terminates.
    // The algorithm is named because each iteration of the outer loop moves the largest element of the unsorted portion of the array to the end of the unsorted portion.
    // This is similar to how bubbles rise to the surface of water.




public static int[] sortArray(int[] arr) {
        int temp;
        boolean isSorted = true;
        for(int index = 0; index < arr.length; index++) {
            isSorted = true;
            for(int j = 0; j < arr.length-index-1; j++) {
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


    // method to find hether a number is prime or not
    public static boolean isPrime(int num) {
        if(num <= 1) {
            return false;
        }
        if(num <= 3) {
            return true;
        }
        if(num % 2 == 0 || num % 3 == 0) {
            return false;
        }
        for(int index = 5; index * index <= num; index += 6) {
            if(num % index == 0 || num % (index + 2) == 0) {
                return false;
            }
        }
        return true;
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
