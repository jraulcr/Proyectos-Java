/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.person;
import java.util.Comparator;
import java.util.List;

/**
 * STREAMS - SOLUTIONS FOR PRACTICE #1
 */
public class StreamsPractice1 {
    
    public static void main(String[] args) {
        List<Person> people = Person.getSomePeople();
        
        // EXERCISE #1
        // Use a stream to count how many people there are in the list
        long countPeople = people.stream().count();
        System.out.println("People in the list: " + countPeople);
        
        
        // EXERCISE #2
        // Use a stream to filter the people over 18 and count them.
        long countPeopleOver18 = people.stream().filter(p -> p.getAge() >= 18).count();
        System.out.println("People over 18: " + countPeopleOver18);
        
        
        System.out.println("\n-- Last names over 18");
        // EXERCISE #3
        // Use the filter(), map() and forEach() operations to print the last names
        // of the people over 18. Use method references where possible.
        people.stream()
              .filter(p -> p.getAge() >= 18)
              .map(Person::getLastName)
              .forEach(name -> System.out.println(name));
        
        
        System.out.println("\n-- Cities where people live");
        // EXERCISE #4
        // Print all the distinct cities of the people, sorted alphabetically.
        people.stream()
              .map(Person::getCity)
              .distinct()
              .sorted()
              .forEach(city -> System.out.println(city));
        
        
        System.out.println("\n-- People sorted from oldest to youngest");
        // EXERCISE #5
        // Sort the people from oldest to youngest and then print their first name
        // and age. Use method references where possible.
        people.stream()
              .sorted(Comparator.comparingInt(Person::getAge).reversed())
              .map(p -> p.getFirstName().concat("-") + p.getAge())
              .forEach(name -> System.out.println(name));        
    }
    
}
