package com.daddarioc.unit1;

public class TypeInferenceExample {

    public static void main(String[] args) {
        //initial implementation example
        StringLengthLambda myLambda = (String s) -> s.length();

        // since the lambda expression is backed by the interface
        // the compiler can get all the info it needs, so the
        // statement can be reduced to the following
        StringLengthLambda myLambda2 = (s) -> s.length();

        // can even be stripped down further as
        StringLengthLambda myLambda3 = s -> s.length();

        System.out.println(myLambda.getLength("Hello world!"));
        System.out.println(myLambda2.getLength("Hello Lambda!"));
        System.out.println(myLambda3.getLength("Hello even more!"));

        // the method will accept the lambda as an argument
        // resulting in the same output each time
        // this is type inference in action
        printLambda(myLambda);
        printLambda(myLambda2);
        printLambda(myLambda3);
    }

    public static void printLambda(StringLengthLambda l) {
        System.out.println(l.getLength("Hello lambda!"));
    }

    interface StringLengthLambda {
        int getLength(String s);
    }
}
