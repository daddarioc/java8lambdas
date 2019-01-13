package com.daddarioc.unit2;

public class ClosuresExample {

    public static void main(String[] args) {

        int a = 10;
        int b = 20;

        // original inner class version
        /*doProcess(a, new Process() {
            @Override
            public void process(int i) {
                // b = 40; this causes an error since b isn't final
                System.out.println(i + b);
            }
        });*/

        // lambda expression doing the same thing
        doProcess(a, i -> System.out.println(i + b));
    }

    public static void doProcess(int i, Process p) {
        p.process(i);
    }
}

interface Process {
    void process(int i);
}