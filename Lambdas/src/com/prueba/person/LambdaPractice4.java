/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.person;

import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * LAMBDA EXPRESSIONS - SOLUTIONS FOR PRACTICE #4
 */
public class LambdaPractice4 {
    
    public static void main(String[] args) {
        Map<String, String> people = Person.getSomePeopleInMap();
        BiConsumer<String, String> printPerson = (k, v) -> System.out.println(k + " --> " + v);
        Function<String, String> newPerson = k -> "NEW: ".concat(k.toUpperCase());
        BiFunction<String, String, String> updatedPerson = (k, v) -> "UPDATED: ".concat(k.toUpperCase());
        BiFunction<String, String, String> computedPerson = (k, v) -> "COMPUTED: ".concat(k.toUpperCase());
        BiFunction<String, String, String> replacedPerson = (k, v) -> "REPLACED: ".concat(k.toUpperCase());
        
        System.out.println("-- Print everyone");
        // EXERCISE #1
        // Use the Map.forEach() method and printPerson variable to print all
        // the people in the map.
        people.forEach(printPerson);
        
        System.out.println("\n-- Add people");
        // EXERCISE #2
        // Use the Map.computeIfAbsent() method and newPerson variable to compute
        // a new name and an existing name. Then, print again all the people in
        // the map and check what has changed.
        people.computeIfAbsent("Andrew", newPerson);
        people.computeIfAbsent("Diane", newPerson);
        people.forEach(printPerson);
        
        System.out.println("\n-- Update exisiting people");
        // EXERCISE #3
        // Use the Map.computeIfPresent() method and updatedPerson variable to
        // compute a new name and an existing name. Then, print again all the
        // people in the map and check what has changed.
        people.computeIfPresent("Sonia", updatedPerson);
        people.computeIfPresent("Diane", updatedPerson);
        people.forEach(printPerson);
        
        System.out.println("\n-- Compute people");
        // EXERCISE #4
        // Use the Map.compute() method and computedPerson variable to compute
        // a new name and a different existing name. Then, print again all the
        // people in the map and check what has changed.
        people.compute("Bob", computedPerson);
        people.compute("Rob", computedPerson);
        people.forEach(printPerson);
        
        System.out.println("\n-- Replace all people");
        // EXERCISE #5
        // Use the Map.replaceAll() method and replacedPerson variable to replace
        // all the people in the map. Then, print again all the people in the map
        // and check what has changed.
        people.replaceAll(replacedPerson);
        people.forEach(printPerson);
    }
    
}
