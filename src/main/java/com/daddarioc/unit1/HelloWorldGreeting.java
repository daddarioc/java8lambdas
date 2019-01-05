package com.daddarioc.unit1;

public class HelloWorldGreeting implements Greeting {

    @Override
    public void perform() {
        System.out.println("Hello object world!");
    }
}
