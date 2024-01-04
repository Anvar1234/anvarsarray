package org.example.hw.quicksort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class AnvarQuickSort {

    public static void main(String[] args) {
        AnvarQuickSort anvarQuickSort = new AnvarQuickSort();
        Integer[] integersArray = new Integer[]{5, 10, 2, 9, -1, 0, 99};
        System.out.println(Arrays.toString(integersArray));
        System.out.println(Arrays.toString(anvarQuickSort.quickSort(integersArray)));
    }

    //в данном методе происходит разделение массивов и перемещение элементов относительно пивота.
    //опорный элемент определим как случайный.
    //проблема, если брать например всегда первый или последний - он может быть всегда меньше всех элементов и будет бесконечная рекурсия.
    //проблема в случайном - что если есть одинаковые числа в массиве, то они и останутся в бесконечной рекурсии.
    public Integer[] quickSort(Integer[] insertArray) {
        if (insertArray.length < 2) return insertArray;

        Random random = new Random();
        int randomPivotIndex = random.nextInt(0, insertArray.length);
        int pivot = insertArray[randomPivotIndex];

        System.out.println("PivotElem = " + pivot);

        //пока сделаю с использованием динамических массивов типа ArrayList.
        ArrayList<Integer> leftArrayList = new ArrayList<>();
        ArrayList<Integer> rightArrayList = new ArrayList<>();


        //Условие, что если элемент меньше пивота, то идет в лефт, а если больше или равен - в райт:
        for (Integer intElem : insertArray) {
            if (intElem < pivot) leftArrayList.add(intElem);
            if (intElem >= pivot) rightArrayList.add(intElem);
        }
        System.out.println("leftArrayList = " + leftArrayList);
        System.out.println("rightArrayList = " + rightArrayList);

        Integer[] leftArray = leftArrayList.toArray(new Integer[leftArrayList.size()]);
        Integer[] rightArray = rightArrayList.toArray(new Integer[rightArrayList.size()]);

        leftArray = quickSort(leftArray);
        rightArray = quickSort(rightArray);

        Integer[] resultArray = new Integer[leftArray.length + rightArray.length];
        System.arraycopy(leftArray, 0, resultArray, 0, leftArray.length);
        System.arraycopy(rightArray, 0, resultArray, leftArray.length, rightArray.length);

        return resultArray;



    }
}


