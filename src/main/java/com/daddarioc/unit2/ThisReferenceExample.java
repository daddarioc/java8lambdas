package com.daddarioc.unit2;

public class ThisReferenceExample {

    public void doProcess(int i, Process p) {
        p.process(i);
    }

    public void execute() {
        doProcess(10, i -> {
            System.out.println("Value of i: " + i);
            System.out.println(this); // this now works since we are not in a static context
        });
    }

    public static void main(String[] args) {

        ThisReferenceExample thisReferenceExample = new ThisReferenceExample();

        // original inner class implementation
        thisReferenceExample.doProcess(10, new Process() {
            @Override
            public void process(int i) {
                System.out.println("Value of i: " + i);
                // 'this' references the new instance of Process() that was created in doProcess
                System.out.println(this);
            }

            // since 'this' above is this anon inner class, its toString is called
            // when doing the print above
            @Override
            public String toString() {
                return "This is the anonymous inner class!";
            }
        });

       /* thisReferenceExample.doProcess(10, i -> {
            System.out.println("Value of i: " + i);
            //System.out.println(this); // this won't work
        });*/

        thisReferenceExample.execute();
    }

    @Override
    public String toString() {
        return "This is the main ThisReferenceExample class reference!";
    }
}
