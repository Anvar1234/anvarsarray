package org.example;

public class FuncInterfaceANDLambdas {
    public static void main(String[] args) {
        //Задача 4.
        Task4able task4able = (x, y) -> x.length() > y.length() ? x : x.length() < y.length() ? y : "Stringi ravny";
        System.out.println(task4able.selectString("asdfa", "asdfaa"));

        //Задача 3.
        Task3able<Integer> task3able = x -> x % 13 == 0;
        System.out.println(task3able.numberDivisibleBy13(26));

        //Задача 4 без лямбда.
        Task4able task4able2 = new Task4able() {
            @Override
            public String selectString(String a, String b) {
                if (a.length() > b.length()) return a;
                else if (a.length() < b.length()) return b;
                else return "значения равны";
            }
        };
        System.out.println(task4able2.selectString("asdf", "asdf"));

        //Задача 3 без лямбда.
        Task3able<Integer> task3able2 = new Task3able<Integer>() {
            @Override
            public boolean numberDivisibleBy13(Integer integer) {
                return integer % 13 == 0;
            }
        };
        System.out.println(task3able2.numberDivisibleBy13(39));
    }


}

/**
 * Задача 4. Написать функциональный интерфейс с методом, который принимает две строки и возвращает тоже строку.
 * Написать реализацию такого интерфейса в виде лямбды, которая возвращает ту строку, которая длиннее.
 */
interface Task4able {
    public String selectString(String a, String b);
}

/**
 * Задача 3. Написать функциональный интерфейс с методом, который принимает число и возвращает булево значение.
 * Написать реализацию такого интерфейса в виде лямбда-выражения, которое возвращает true если переданное число делится
 * без остатка на 13.
 */
interface Task3able<T extends Number> {
    public boolean numberDivisibleBy13(T t);
}



