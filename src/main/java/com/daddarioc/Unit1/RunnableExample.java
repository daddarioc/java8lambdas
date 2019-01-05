package com.daddarioc.Unit1;

public class RunnableExample {

    public static void main(String[] args) {

        // new thread using anon inner class
        Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("printed inside Runnable");
            }
        });

        myThread.run();

        // this is perfect candidate to rewrite as a lambda
        // since lambdas are based on interfaces, the thread constructor
        // is none the wiser as to what was sent into it
        Thread myThread2 = new Thread(() -> System.out.print("printed from lambda"));

        myThread2.run();


    }
}
