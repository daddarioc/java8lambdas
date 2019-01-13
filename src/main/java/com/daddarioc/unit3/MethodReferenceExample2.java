package com.daddarioc.unit3;

import com.daddarioc.unit1.exercise.Person;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MethodReferenceExample2 {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Chris", "Matthews", 35),
                new Person("John", "Coruso", 30),
                new Person("Jamie", "Casack", 25),
                new Person("Amy", "Johnson", 22),
                new Person("Rick", "Sanchez", 66),
                new Person("Joan", "Cuscak", 22)
        );


        //use the condition of printing all people, original version
        performConditionally(people, p->true, p -> System.out.println(p));

        // same statement, in method reference form
        performConditionally(people, p->true, System.out::println);

    }

    //re-written to show the use of the available Predicate type
    private static void performConditionally(List<Person> people, Predicate<Person> predicate,
                                             Consumer<Person> consumer) {
        for (Person p : people) {
            if (predicate.test(p)) {
                consumer.accept(p);
            }
        }
    }
}
