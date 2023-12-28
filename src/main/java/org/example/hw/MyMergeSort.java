package org.example.hw;

import java.util.Arrays;

public class MyMergeSort {

    public static void main(String[] args) {
        MyMergeSort myMergeSort = new MyMergeSort();
        Integer[] myArray = new Integer[]{-1, 3, 0, -1, 4, 1};
        System.out.println(Arrays.toString(myMergeSort.mergeSort(myArray)));
    }

    public Integer[] mergeSort(Integer[] array){
       return divisionArrays(array);
    }

    private Integer[] divisionArrays(Integer[] array) {
        if (array.length < 2) return array;

        Integer[] left = new Integer[array.length / 2];
        System.arraycopy(array, 0, left, 0, array.length / 2);
        Integer[] right = new Integer[array.length - array.length / 2];
        System.arraycopy(array, array.length / 2, right, 0, array.length - array.length / 2);
        left = divisionArrays(left);
        right = divisionArrays(right);

        return mergeArrays(left, right);
    }

    private Integer[] mergeArrays(Integer[] arrLeft, Integer[] arrRight) {
        int resultLength = arrLeft.length + arrRight.length;
        Integer[] resultArray = new Integer[resultLength];
        int resultIndex = 0, leftIndex = 0, rightIndex = 0;
        while (leftIndex < arrLeft.length && rightIndex < arrRight.length) {
            if (arrLeft[leftIndex] < arrRight[rightIndex]) resultArray[resultIndex++] = arrLeft[leftIndex++];
            else resultArray[resultIndex++] = arrRight[rightIndex++];
        }

        if (leftIndex != arrLeft.length) {
            while (resultIndex < resultLength) {
                resultArray[resultIndex++] = arrLeft[leftIndex++];
            }
        } else {
            while (resultIndex < resultLength) {
                resultArray[resultIndex++] = arrRight[rightIndex++];
            }
        }
        return resultArray;
    }
}



