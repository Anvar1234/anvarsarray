package org.example.hw;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * What's wrong with to {@link Task2#calculate(char, double...)} method code?
 * You'll need to correct it and add square root calculation.
 */
public class Task2 {

    static final Map<Character, Countable> countableMap = new HashMap<>();
    static final Map<Character, Integer> operatorsAccount = new HashMap<>();

    static {
        countableMap.put('+', args -> args[0] + args[1]);
        countableMap.put('-', args -> args[0] - args[1]);
        countableMap.put('*', args -> args[0] * args[1]);
//        countableMap.put('/', new Countable() {
//            @Override
//            public double countableCalculate(double... args) {
//                if (args[1] == 0) throw new ArithmeticException("Divide by zero");
//                return args[0] / args[1];
//            }
//        });
        countableMap.put('/', args -> Optional.of(args[0] / args[1]).orElseThrow(() -> new ArithmeticException("Divide by zero")));
        countableMap.put('&', args -> Math.sqrt(args[0]));

        operatorsAccount.put('+', 2);
        operatorsAccount.put('-', 2);
        operatorsAccount.put('*', 2);
        operatorsAccount.put('/', 2);
        operatorsAccount.put('&', 1);
    }


////Было так:
//    public static void main(String[] args) { //метод без Optional
//        Task2 task2 = new Task2();
//        task2.calculate('-', 9, 2); //а как сделать так, чтобы второй операнд было необязательно вводить и
//        // чтобы автоматически выбирался нужный метод - перегрузка?
//    }
//    public double calculate(char operator, double a, double b) {
//        double result = countableMap.get(operator).countableCalculate(a, b);
//        System.out.printf("Result: %s", result);
//        return result;
//    }



    // Вариант без Optional
    // не введен ни один операнд, вместо операнда приходит null, кол-во операндов не соответствует оператору,
    // приходит не верный оператор

//    public static void main(String[] args) { //метод без Optional
//        Task2 task2 = new Task2();
//        task2.calculate('_', 9);
//    }

//    public double calculate(char operator, double... arguments) { //метод без Optional
//        if(arguments == null || !operatorsAccount.containsKey(operator)) {
//            System.out.println("Не верный оператор или количество операндов");
//            return 0;
//        }
//        if (arguments.length == 2 && arguments.length == operatorsAccount.get(operator)) {
//            double result = countableMap.get(operator).countableCalculate(arguments[0], arguments[1]);
//            System.out.printf("Result: %s", result);
//            return result;
//        }
//        if (arguments.length == 1 && arguments.length == operatorsAccount.get(operator)) {
//            double result = countableMap.get(operator).countableCalculate(arguments[0]);
//            System.out.printf("Result: %s", result);
//            return result;
//        }
//
//        System.out.println("Не верный оператор или количество операндов");
//        return 0;
//    }


    // Вариант с Optional
    // не введен ни один операнд, вместо операнда приходит null, кол-во операндов не соответствует оператору,
    // приходит не верный оператор.
    public static void main(String[] args) { //метод с Optional
        Task2 task2 = new Task2();
        Optional<Double> resultOptional = task2.calculate('&', 10);

        resultOptional.ifPresentOrElse(x -> System.out.printf("Результат: %s", x),
                () -> System.out.println("Не верный оператор или количество операндов"));

    }
    public Optional<Double> calculate(char operator, double... arguments) {//метод с Optional
        if(arguments == null || !operatorsAccount.containsKey(operator)) return Optional.empty();
        if (arguments.length == 2 && arguments.length == operatorsAccount.get(operator)) {
            double result = countableMap.get(operator).countableCalculate(arguments[0], arguments[1]);
            return Optional.of(result);
        }
        if (arguments.length == 1 && arguments.length == operatorsAccount.get(operator)) {
            double result = countableMap.get(operator).countableCalculate(arguments[0]);
            return Optional.of(result);
        }
        return Optional.empty();
    }
}

interface Countable {
    double countableCalculate(double... args);
}
