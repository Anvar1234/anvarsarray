package org.example.hw.quicksort;

import java.util.Arrays;
import java.util.Random;

public class AnvarQuickSort {

    public static void main(String[] args) {
        AnvarQuickSort anvarQuickSort = new AnvarQuickSort();
        Integer[] integersArray = new Integer[]{1, 10, 5, 12, 11, 2};
        System.out.println(integersArray);
        System.out.println(Arrays.toString(anvarQuickSort.divisionArrays(integersArray)));
    }

    //в данном методе происходит разделение массивов и перемещение элементов относительно пивота.
    //опорный элемент определим как случайный, чтобы не было предопределенности (типа только правый, левый).
    public Integer[] divisionArrays(Integer[] insertArray) {
        //int startIndex, int endIndex
        if (insertArray.length < 2) return insertArray; //базовый случай, выход из рекурсии.
        //определяем опорный элемент:
        Random random = new Random();
        int randomPivotIndex = random.nextInt(0, insertArray.length);//включительно или нет в Джава?
        int pivotElem = insertArray[randomPivotIndex];
        System.out.printf("Pivot = %s \n", pivotElem);
        insertArray[randomPivotIndex] = pivotElem;//входящий массив будет и результирующим.

        int leftLength = randomPivotIndex;//длина левого массива (не включает элемент, находящийся под pivotIndex).
        // То есть если длина инсертмассива 4, то пивотиндекс выпал например 2, тогда длина левого массива == 2.
        int rightLength = insertArray.length - leftLength - 1;//длина правого массива, этот массив тоже не включает пивот элемент.
//итого у нас будет 3 массива: входящий, он же результирующий, и левый с правым массивы.
        Integer[] leftArray = new Integer[leftLength];//создаем и копируем левый массив.
        System.arraycopy(insertArray, 0, leftArray, 0, randomPivotIndex);
        Integer[] rightArray = new Integer[rightLength];//создаем и копируем правый массив.
        System.arraycopy(insertArray, randomPivotIndex + 1, rightArray, 0, insertArray.length - leftLength - 1);

        //пропишем указатели:
        int leftIndex = 0;
        int rightIndex = rightLength - 1;

        //поиск элемента большего чем пивот в левом массиве, а также элемента меньшего пивота в правом массиве, и далее их свап.
        while (leftIndex < randomPivotIndex && rightIndex != 0) {
            if (leftArray[leftIndex] < pivotElem) {
                insertArray[leftIndex] = leftArray[leftIndex++];
            }
            if (rightArray[rightIndex] >= pivotElem) {
                insertArray[leftLength + 1 + rightIndex] = rightArray[rightIndex--];
            }

            //свап элементов.
            if (leftArray[leftIndex] > pivotElem && rightArray[rightIndex] < pivotElem) {
                //написать вспомогательный метод для свапа
                int temp = leftArray[leftIndex];
                leftArray[leftIndex] = rightArray[rightIndex];
                rightArray[rightIndex] = temp;
            }
        }
        return insertArray;
    }

    //в данном методе происходит сортировка методом рекурсии.
//    public Integer[] quickSortArrays(Integer[] insertArray) {
//        if ()
//    }

}


