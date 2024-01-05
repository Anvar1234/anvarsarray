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
        System.out.println("отсортированный массив: ");
        for (Integer intElem : array) {
            System.out.print(" " + intElem);
        }
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
        System.out.println("pivot = " + pivot);
        System.out.println();

        int l = leftIndex; //определим указатели с начальными значениями для левого и правого подмассивов
        int r = rightIndex;
        System.out.printf("Начальные l = %s, r = %s ", l, r);
        System.out.println();

        System.out.println("вход в цикл while l <= r");

        while (l <= r) {
            while (a[l] < pivot) l++;
            while (a[r] > pivot) r--;
            if (l <= r) {
                System.out.printf("при входе в if: l = %s, r = %s \n", l, r);
                swap(a, l, r);
                l++;
                r--;
            }
//            System.out.println("после if: ");
            System.out.print("измененный массив: ");
            for (Integer intElem : a) {
                System.out.print(" " + intElem);
            }
            System.out.println();
            System.out.printf("Новые: l = %s, r = %s \n", l, r);

        }
        System.out.println("конец цикла while l <= r");

        System.out.println("\nначало левой рекурсии");
        quickSort(a, leftIndex, r);
        System.out.println("конец левой рекурсии\n");

        System.out.println("\nначало правой рекурсии");
        quickSort(a, l, rightIndex);
        System.out.println("конец правой рекурсии\n");

    }

    private void swap(Integer[] array, int leftIndex, int rightIndex) {
        int temp = array[leftIndex];
        array[leftIndex] = array[rightIndex];
        array[rightIndex] = temp;
    }


}
