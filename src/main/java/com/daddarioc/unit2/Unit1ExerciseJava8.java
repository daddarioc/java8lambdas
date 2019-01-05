package com.daddarioc.unit2;

import com.daddarioc.unit1.exercise.Person;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class Unit1ExerciseJava8 {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Chris", "Matthews", 35),
                new Person("John", "Coruso", 30),
                new Person("Jamie", "Casack", 25),
                new Person("Amy", "Johnson", 22),
                new Person("Rick", "Sanchez", 66),
                new Person("Joan", "Cuscak", 22)
        );

        // step 1: sort by last name
        System.out.println("***********************************");
        System.out.println("STEP 1 - Sort");
        System.out.println("***********************************");

        Collections.sort(people, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));

        // step 2: create method that prints all elements in the list
        System.out.println("***********************************");
        System.out.println("STEP 2 - Print all elements");
        System.out.println("***********************************");

        //use the condition of printing all people
        performConditionally(people, p->true);

        // step 3: create method that prints all people beginning with 'C'
        System.out.println("***********************************");
        System.out.println("STEP 3 - Print all C people");
        System.out.println("***********************************");

        System.out.println("Print last name with C:");
        performConditionally(people, (Person p) -> p.getLastName().toLowerCase().startsWith("c"));

        System.out.println("Print first name with C:");
        performConditionally(people, (Person p) -> p.getFirstName().toLowerCase().startsWith("c"));
    }

    //re-written to show the use of the available Predicate type
    private static void performConditionally(List<Person> people, Predicate<Person> predicate) {
        for (Person p : people) {
            if (predicate.test(p)) {
                System.out.println(p);
            }
        }
    }

}
