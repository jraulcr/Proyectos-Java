/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.person;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * STREAMS - SOLUTIONS FOR PRACTICE #2
 */
public class StreamsPractice2 {
    
    public static void main(String[] args) {
        List<Person> people = Person.getSomePeople();
        
        // EXERCISE #1
        // Use the max() terminal operation to get the PERSON under 18 with the highest last name.
        Optional<Person> lastUnder18 = people.stream()
                                             .filter(p -> p.getAge() < 18)
                                             .max(Comparator.comparing(Person::getLastName));
        System.out.println("Last person under 18: " + lastUnder18.get());
        
        
        // EXERCISE #2
        // Use the min() terminal operation to get the lowest FIRST NAME in Arizona.
        Optional<String> firstInArizona = people.stream()
                                                .filter(p -> Person.State.AZ.equals(p.getState()))
                                                .map(Person::getFirstName)
                                                .min(Comparator.naturalOrder());
        System.out.println("First first name in Arizona: " + firstInArizona.get());
        
        
        // EXERCISE #3
        // Check if there is any female living in Texas
        boolean femaleInTexas = people.stream()
                                      .anyMatch(p -> Person.Gender.Female.equals(p.getGender()) && Person.State.TX.equals(p.getState()));
        System.out.println("Female living in Texas: " + femaleInTexas);
        

        // EXERCISE #4
        // Check if all the males are over 18
        boolean allMalesOver18 = people.stream()
                                       .filter(p -> Person.Gender.Male.equals(p.getGender()))
                                       .allMatch(p -> p.getAge() >= 18);
        System.out.println("All males are over 18: " + allMalesOver18);
    }
    
}
