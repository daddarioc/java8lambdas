package com.daddarioc.unit3;

import com.daddarioc.unit1.exercise.Person;

import java.util.Arrays;
import java.util.List;

public class CollectionIterationExample {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Chris", "Matthews", 35),
                new Person("John", "Coruso", 30),
                new Person("Jamie", "Casack", 25),
                new Person("Amy", "Johnson", 22),
                new Person("Rick", "Sanchez", 66),
                new Person("Joan", "Cuscak", 22)
        );

        System.out.println("Example 1 - standard for loop - external iterator");
        // standard way to iterate the collection, an external iterator
        for (int i = 0; i < people.size(); i++) {
            System.out.println(people.get(i));
        }

        System.out.println("\nExample 2 - 'for in' loop - external iterator");
        // standard way to iterate the collection, an external iterator
        for (Person p : people) {
            System.out.println(p);
        }

        System.out.println("\nExample 3 - internal iterator .forEach");
        // example of an internal iterator with lamba expression
        people.forEach(p -> System.out.println(p));

        System.out.println("\nExample 4 - internal iterator .forEach");
        // example of an internal iterator with method reference
        people.forEach(System.out::println);

        //so this is a method referenced, passed into a function, executed for each item in the collection
        //since the runtime is controlling 'how' things are iterated, this is ideal for parallel processing
    }
}
