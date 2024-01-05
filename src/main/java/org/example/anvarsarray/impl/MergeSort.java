package org.example.anvarsarray.impl;

import java.util.Arrays;
import java.util.Comparator;

public class MergeSort<T extends Comparable> {

    public static void main(String[] args) {
        MergeSort<Integer> arrSort = new MergeSort<>();
        Integer[] intArray = new Integer[]{0, 9, 1};
        System.out.println(Arrays.toString(arrSort.mergeSort(intArray)));
    }


    public T[] mergeSort(T[] array) {
        if (array.length <= 1) return array;//{0} {1}
        int midIndex = array.length / 2; //midIndex = 1;
        T[] leftArray = Arrays.copyOfRange(array, 0, midIndex); //leftArray {0} ->
        T[] rightArray = Arrays.copyOfRange(array, leftArray.length, array.length); //{9, 1} -> {1 , 9}
        leftArray = mergeSort(leftArray); //{0}
        rightArray = mergeSort(rightArray);//{1 , 9}
        return merge(leftArray, rightArray); //{0, 1, 9}
    }

    private T[] merge(T[] left, T[] right) {
        T[] resultArray = (T[]) new Comparable[left.length + right.length];
        int leftIndex = 0, rightIndex = 0, resultIndex = 0;

        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex].compareTo(right[rightIndex]) < 0) {
                resultArray[resultIndex++] = left[leftIndex++];
            } else resultArray[resultIndex++] = right[rightIndex++];
        }
        while (resultIndex < resultArray.length) {
            if (leftIndex != left.length) {
                resultArray[resultIndex++] = left[leftIndex++];
            } else resultArray[resultIndex++] = right[rightIndex++];
        }
        return resultArray; //0, 1, 4, -1, 9
    }

}
