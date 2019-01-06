package com.daddarioc.unit2;

import java.util.function.BiConsumer;

public class ExceptionHandlingExample {

    public static void main(String[] args) {
        int[] someNumbers = {1, 2, 3, 4};
        int key = 0;    // will generate exception

        /*
        could do a try/catch in the process method, but it doesn't know what
        the behavior/input is going to be, so it doesn't always make sense..
        so handle the exception where the behavior is defined
         */

        // this is one option...but makes our nice lambda look ugly
        process(someNumbers, key, (a, b) -> {
            try {
                System.out.println(a / b);
            } catch (ArithmeticException e) {
                e.printStackTrace();
            }
        });

        // another option is to wrap the lambda in another lambda
        process(someNumbers, key, wrapperLambda((a, b) -> System.out.println(a / b)));

    }

    private static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> biConsumer) {
        // initial wrapper behavior
        //return (a, b) -> System.out.println(a + b);

        // now a true wrapper with try catch outside of the actual lambda
        // still not the most elegant since it's just relocated
        return (a, b) -> {
            try {
                System.out.println("Executing from wrapper...");
                biConsumer.accept(a, b);
            } catch (ArithmeticException e) {
                System.out.println("Exception caught in wrapper lambda");
            }
        };
    }


    private static void process(int[] someNumbers, int key, BiConsumer<Integer, Integer> biConsumer) {
        System.out.println("\nProcessing...\n");
        for (int i : someNumbers) {
            biConsumer.accept(i, key);
        }
    }
}
