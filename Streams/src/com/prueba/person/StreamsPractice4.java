/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.person;

import java.util.List;
import java.util.Optional;

/**
 * STREAMS - SOLUTIONS FOR PRACTICE #4
 */
public class StreamsPractice4 {
    
    public static void main(String[] args) {
        List<Person> people = Person.getSomePeople();
        
        System.out.println("-- Any first name (sequentially)");
        // EXERCISE #1
        // Get any first name in the list sequentially. Then check the results.
        for(int i = 0; i < 50; i++) {
            Optional<String> anyFirstName = people.stream().map(Person::getFirstName).findAny();
            System.out.println(anyFirstName.get());
        }
        
        System.out.println("\n-- Any first name (parallel)");
        // EXERCISE #2
        // Get any first name in the list in parallel. Then check the results.
        for(int i = 0; i < 50; i++) {
            Optional<String> anyFirstName = people.stream().parallel().map(Person::getFirstName).findAny();
            System.out.println(anyFirstName.get());
        }
        
        System.out.println("\n-- Any first name (sequential & parallel)");
        // EXERCISE #3
        // Get any first name in the list combining the parallel (first)
        // and sequential (second) operations. Then check the results.
        for(int i = 0; i < 50; i++) {
            Optional<String> anyFirstName = people.stream().parallel().map(Person::getFirstName).sequential().findAny();
            System.out.println(anyFirstName.get());
        }
        
    }
    
}
