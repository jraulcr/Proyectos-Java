/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.person;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

/**
 * STREAMS - SOLUTIONS FOR PRACTICE #3
 */
public class StreamsPractice3 {
    
    public static void main(String[] args) {
        List<Person> people = Person.getSomePeople();
        BiConsumer mapListPrinter = (k, v) -> {
            System.out.println(k + ":");
            ((List)v).forEach(p -> System.out.println(p));
        };
        BiConsumer mapPrinter = (k, v) -> System.out.println(k + " --> " + v);
        
        System.out.println("\n-- People over 18");
        // EXERCISE #1
        // Collect the people over 18 in a new list.
        List<Person> peopleOver18 = people.stream()
                                          .filter(p -> p.getAge() >= 18)
                                          .collect(Collectors.toList());
        peopleOver18.forEach(p -> System.out.println(p));
        
        
        System.out.println("\n-- Group people by state");
        // EXERCISE #2
        // Group all the people by their state.
        Map<Person.State, List<Person>> peopleByState = people.stream()
                                                              .collect(Collectors.groupingBy(Person::getState));
        peopleByState.forEach(mapListPrinter);
        
        
        System.out.println("\n-- People under and over 18");
        // EXERCISE #3
        // Separate people of under and over 18
        Map<Boolean, List<Person>> peopleByAge = people.stream()
                                                       .collect(Collectors.partitioningBy(p -> p.getAge() >= 18));
        peopleByAge.forEach(mapListPrinter);
        
        
        System.out.println("\n-- Mapped people");
        // EXERCISE #4
        // Convert the list of people to a map, using the ID as the key.
        Map<Long, Person> peopleMap = people.stream()
                                            .collect(Collectors.toMap(Person::getId, p -> p));
        peopleMap.forEach(mapPrinter);
        
        
        // EXERCISE #5
        // Concatenate all the last names sorted alphabetically, separated by ', '.
        String lastNames = people.stream()
                                 .map(Person::getLastName)
                                 .sorted()
                                 .collect(Collectors.joining(", "));
        System.out.println("\nLast names: " + lastNames);
        
        
    }
    
}
