/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.person;

import java.util.List;
import java.util.function.Consumer;

/**
 * LAMBDA EXPRESSIONS - SOLUTIONS FOR PRACTICE #3
 */
public class LambdaPractice3 {
    
    public static void main(String[] args) {
        List<Person> people = Person.getSomePeople();
        Consumer<Person> printPerson = p -> System.out.println(p);
        
        System.out.println("-- Print everyone");
        // EXERCISE #1
        // Use the List.forEach() method and the printPerson variable to print all
        // the people in the list.
        people.forEach(printPerson);
        
        
        System.out.println("\n-- Remove people under 18");
        // EXERCISE #2
        // Use the List.removeIf() method to remove all the people under 18.
        // Then print again all the people in the list.
        people.removeIf(p -> p.getAge() < 18);
        people.forEach(printPerson);
    }
}
