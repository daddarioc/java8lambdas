package com.daddarioc.unit3;

public class MethodReferenceExample1 {

    public static void main(String[] args) {

        // regular lambda expression
        // the following lambda expression is essentially a method execution...
        // it is taking in no arguments, and executing the method printMessage()
        Thread t = new Thread(() -> printMessage());
        t.start();

        // method reference lambda expression, functionally equivalent to above
        Thread u = new Thread(MethodReferenceExample1::printMessage);
        u.start();
    }

    public static void printMessage() {
        System.out.println("Hello");
    }
}
