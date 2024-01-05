package org.example.hw.quicksort;

import java.util.Random;

public class AnvarQuickSort2 {

    public static void main(String[] args) {

        Integer[] array = new Integer[]{1, 10, 3, 9, 0};
        System.out.println("начальный массив: ");
        for (Integer intElem : array) {
            System.out.print(" " + intElem);
        }
        System.out.println();
        AnvarQuickSort2 anvarQuickSort2 = new AnvarQuickSort2();
        anvarQuickSort2.quickSort(array, 0, array.length - 1);
    }

    public void quickSort(Integer[] a, int leftIndex, int rightIndex) { //принимаем на вход массив, точку начала и точку конца сортировки массива
        if (leftIndex > rightIndex) {
            System.out.println("выход");
            return; //Укажем базовый случай выхода из рекурсии.
        }

        Random random = new Random();
        int pivotIndex = random.nextInt(leftIndex, rightIndex + 1); //определяем опорный элемент массива как случайный элемент диапазона
        System.out.println("random = " + pivotIndex);
        int pivot = a[pivotIndex];


        int l = leftIndex; //определим указатели с начальными значениями для левого и правого подмассивов
        int r = rightIndex;
        System.out.printf("l = %s, r = %s ", l, r);
        System.out.println();

        System.out.println("pivot = " + pivot);
        System.out.println("вход в цикл while l <= r");

        while (l <= r) {
            while (a[l] < pivot) l++;
            while (a[r] > pivot) r--;
            if (l <= r) {
                System.out.println("сработал if l <= r");
                swap(a, l, r);
                l++;
                r--;
            }

            System.out.printf("Новые: l = %s, r = %s ", l, r);
            System.out.print("измененный массив: ");
            for (Integer intElem : a) {
                System.out.print(" " + intElem);
            }
            System.out.println();
        }
        System.out.println("конец цикла while l <= r");

        quickSort(a, leftIndex, l);
        quickSort(a, r, rightIndex);


    }

    private void swap(Integer[] array, int leftIndex, int rightIndex) {
        int temp = array[leftIndex];
        array[leftIndex] = array[rightIndex];
        array[rightIndex] = temp;
    }


}
