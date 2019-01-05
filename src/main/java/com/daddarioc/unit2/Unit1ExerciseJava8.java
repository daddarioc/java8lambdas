package com.daddarioc.unit2;

import com.daddarioc.unit1.exercise.Person;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Unit1ExerciseJava8 {
    public static void main(String[] args) {
        List<Person> peopleJava7;
        List<Person> peopleJava8;

        // step 1: sort by last name
        System.out.println("***********************************");
        System.out.println("STEP 1 - Sort");
        System.out.println("***********************************");


        peopleJava8 = stepOneJava8();

        // step 2: create method that prints all elements in the list
        System.out.println("***********************************");
        System.out.println("STEP 2 - Print all elements");
        System.out.println("***********************************");

        System.out.println("Java 8 People");

        //use the condition of printing all people
        printConditionally(peopleJava8, p->true);

        // step 3: create method that prints all people beginning with 'C'
        System.out.println("***********************************");
        System.out.println("STEP 3 - Print all C people");
        System.out.println("***********************************");

        System.out.println("Print last name with C:");
        printConditionally(peopleJava8, (Person p) -> p.getLastName().toLowerCase().startsWith("c"));

        System.out.println("Print first name with C:");
        printConditionally(peopleJava8, (Person p) -> p.getFirstName().toLowerCase().startsWith("c"));
    }

    //re-written to show the use of the available Predicate type
    private static void printConditionally(List<Person> people, Predicate<Person> predicate) {
        for (Person p : people) {
            if (predicate.test(p)) {
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

    public static List<Person> stepOneJava8() {
        List<Person> people = Arrays.asList(
                new Person("Chris", "Matthews", 35),
                new Person("John", "Coruso", 30),
                new Person("Jamie", "Casack", 25),
                new Person("Amy", "Johnson", 22),
                new Person("Rick", "Sanchez", 66),
                new Person("Joan", "Cuscak", 22)

        );

         /*
            Java 8 Solution
         */

        System.out.println("\n\n\nSTEP 1: SORT - JAVA 8 SOLUTION\n\n\n");

        System.out.println("Before sorting, list is:");
        // and example of the condition of printing ALL people
        printConditionally(people, p -> true);

        // step 1: sort by last name

        // java 8 way
        Collections.sort(people,
                (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));

        System.out.println("After sorting, list is:");
        printPeople(people);

        return people;
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
