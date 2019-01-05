package com.daddarioc.unit1.exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Unit1ExerciseJava7 {

    public static void main(String[] args) {
        List<Person> peopleJava7;

        // step 1: sort by last name
        System.out.println("***********************************");
        System.out.println("STEP 1 - Sort");
        System.out.println("***********************************");

        peopleJava7 = stepOneJava7();

        // step 2: create method that prints all elements in the list
        System.out.println("***********************************");
        System.out.println("STEP 2 - Print all elements");
        System.out.println("***********************************");

        System.out.println("Java 7 People");
        printPeople(peopleJava7);

        // step 3: create method that prints all people beginning with 'C'
        System.out.println("***********************************");
        System.out.println("STEP 3 - Print all C people");
        System.out.println("***********************************");

        System.out.println("Java 7 People with last name starting with C");
        printConditionally(peopleJava7, new PrintCondition() {
            @Override
            public boolean test(Person p) {
                /*if (p.getLastName().toLowerCase().startsWith("c")) {
                    return true;
                }
                return false;*/
                return p.getLastName().toLowerCase().startsWith("c");
            }
        });

        System.out.println("Java 7 People with first name starting with C");
        printConditionally(peopleJava7, new PrintCondition() {
            @Override
            public boolean test(Person p) {
                /*if (p.getLastName().toLowerCase().startsWith("c")) {
                    return true;
                }
                return false;*/
                return p.getFirstName().toLowerCase().startsWith("c");
            }
        });
    }

    private static void printConditionally(List<Person> people, PrintCondition condition) {
        for (Person p : people) {
            if (condition.test(p)) {
                System.out.println(p);
            }
        }
    }

    public interface PrintCondition {
        boolean test(Person p);
    }

    public static void printPeople(List<Person> people) {
        for(Person p : people) {
            System.out.println(p);
        }
    }


    public static List<Person> stepOneJava7() {
        List<Person> people = Arrays.asList(
                new Person("Chris", "Matthews", 35),
                new Person("John", "Coruso", 30),
                new Person("Jamie", "Casack", 25),
                new Person("Amy", "Johnson", 22),
                new Person("Rick", "Sanchez", 66),
                new Person("Joan", "Cuscak", 22)

        );

        /*
            Java 7 Solution
         */

        System.out.println("\n\n\nSTEP 1: SORT - JAVA 7 SOLUTION\n\n\n");

        System.out.println("Before sorting, list is:");
        printPeople(people);

        // step 1: sort by last name

        // java 7 way
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getLastName().compareTo(o2.getLastName());
            }
        });

        System.out.println("After sorting, list is:");
        printPeople(people);

        return people;
    }
}
