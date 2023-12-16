package org.example;

import org.example.anvarsarray.impl.AnvarsArray;

public class Main {
    public static void main(String[] args) {
        AnvarsArray<Integer> anvarsArray = new AnvarsArray<>();
        anvarsArray.add(1);
        anvarsArray.add(2);
        anvarsArray.add(3);
        anvarsArray.add(4);
        System.out.println(anvarsArray);

        anvarsArray.add(5);
        System.out.println(anvarsArray);

        anvarsArray.add(6);//выход за пределы массива
        anvarsArray.add(7);
        System.out.println(anvarsArray);

        for (Integer el : anvarsArray){
            System.out.println(el);
        }

    }
}