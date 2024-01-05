package org.example.hw.quicksort;

import java.util.Random;

public class AnvarQuickSort2 {

    public static void main(String[] args) {

        Integer[] array = new Integer[]{111, 10, 3, 9, 0, 111};
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

    public void quickSort(Integer[] a, int leftIndex, int rightIndex) { //принимаем на вход массив, точку начала и точку конца сортировки.
        if (leftIndex > rightIndex) return; //укажем базовый случай выхода из рекурсии.

        Random random = new Random();
        int pivotIndex = random.nextInt(leftIndex, rightIndex + 1); //определяем опорный элемент массива как случайный элемент диапазона.
        int pivot = a[pivotIndex];

        int l = leftIndex; //определим указатели с начальными значениями для левого и правого подмассивов.
        int r = rightIndex;

        while (l <= r) {
            while (a[l] < pivot) l++;
            while (a[r] > pivot) r--;
            if (l <= r) {
                swap(a, l, r);
                l++;
                r--;
            }
        }

        //рекурсивно вызываем метод с измененными диапазонами.
        quickSort(a, leftIndex, r);
        quickSort(a, l, rightIndex);
    }

    //вспомогательный метод замены ссылок.
    private void swap(Integer[] array, int leftIndex, int rightIndex) {
        int temp = array[leftIndex];
        array[leftIndex] = array[rightIndex];
        array[rightIndex] = temp;
    }


}
