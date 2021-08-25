/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.person;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.function.ToLongFunction;

/**
 * LAMBDA EXPRESSIONS - SOLUTIONS FOR PRACTICE #2
 */
public class LambdaPractice2 {
    
    public static void main(String[] args) {
        List<Person> people = Person.getSomePeople();
        LambdaPractice2 practice2 = new LambdaPractice2();
        
        System.out.println("-- Calling people from Arizona");
        // EXERCISE #1
        // Use the predicate variable to create a lambda expression that selects
        // all the people whose state is 'AZ'.
        Predicate<Person> predicate = p -> Person.State.AZ.equals(p.getState());
        practice2.callPeople(people, predicate);
        
        
        System.out.println("\n-- Printing people's first name");
        // EXERCISE #2
        // Use the consumer variable to create a lambda expression that prints
        // the first name of a person.
        Consumer<Person> consumer = p -> System.out.println("Calling: " + p.getFirstName());
        practice2.callPeople(people, consumer);
        
        
        System.out.println("\n-- Printing people's last name");
        // EXERCISE #3
        // Use the function variable to create a method reference that returns
        // the last name of a person.
        Function<Person, String> function = Person::getLastName;
        practice2.callPeople(people, function);
        
        
        System.out.println("\n-- Calling people over 30");
        // EXERCISE #4
        // Use the intPredicate variable to create a lambda expression that selects
        // all the people who are over 30 years old.
        IntPredicate intPredicate = age -> age >= 30;
        practice2.callPeople(people, intPredicate);
        
        
        System.out.println("\n-- Printing people's ID");
        // EXERCISE #5
        // Use the toLongFunction variable to create a variable with a method reference
        // that returns the ID of a person.
        ToLongFunction<Person> toLongFunction = Person::getId;
        practice2.callPeople(people, toLongFunction);
        
        
        System.out.println("\n-- Calling people whose first name begins like their city");
        // EXERCISE #6
        // Use the biPredicate variable to create a lambda expression that receives
        // the first name and city of a person as parameters and selects those that
        // begin with the same letter.
        BiPredicate<String, String> biPredicate = (fn, c) -> fn.charAt(0) == c.charAt(0);
        practice2.callPeople(people, biPredicate);    
        
    }
    
    public void callPeople(List<Person> people, Predicate<Person> predicate) {
        for(Person person : people) {
            if(predicate.test(person)) {
                System.out.println("Calling: " + person);
            }
        }
    }
    
    public void callPeople(List<Person> people, Consumer<Person> consumer) {
        for(Person person : people) {
            consumer.accept(person);
        }
    }
    
    public void callPeople(List<Person> people, Function<Person, String> function) {
        for(Person person : people) {
            System.out.println("Calling: " + function.apply(person));
        }
    }
    
    public void callPeople(List<Person> people, IntPredicate intPredicate) {
        for(Person person : people) {
            if(intPredicate.test(person.getAge())) {
                System.out.println("Calling: " + person);
            }
        }
    }
    
    public void callPeople(List<Person> people, ToLongFunction<Person> toLongFunction) {
        for(Person person : people) {
            System.out.println("Calling person #" + toLongFunction.applyAsLong(person));
        }
    }
    
    public void callPeople(List<Person> people, BiPredicate<String, String> biPredicate) {
        for(Person person : people) {
            if(biPredicate.test(person.getFirstName(), person.getCity())) {
                System.out.println("Calling: " + person);
            }
        }
    }
    
}
