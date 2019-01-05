package com.daddarioc;

public class Greeter {
    public void greet(Greeting greeting) {
        greeting.perform();
    }

    public static void main(String[] args) {
        Greeter greeter = new Greeter();
        //greeter.greet();

        // an instance of a class that implements the Greeting interface
        // this also could have been an anonymous inner class (below)
        Greeting helloWorldGreeting = new HelloWorldGreeting();
        helloWorldGreeting.perform();

        //anonymous inner class
        Greeting innerClassGreeting = new Greeting() {
            @Override
            public void perform() {
                System.out.println("Hello innerClass world!");
            }
        };
        innerClassGreeting.perform();

        // an instance of the inter
        Greeting myLambdaFunction = () -> System.out.println("Hello Lambda world!");

        //helloWorldGreeting.perform();

        myLambdaFunction.perform();

        // since the lambda and the class implement the interface,
        // greeter doesn't care what one it gets
        greeter.greet(myLambdaFunction);
        greeter.greet(innerClassGreeting);


    }
}

interface MyLambda {
    void foo();
}