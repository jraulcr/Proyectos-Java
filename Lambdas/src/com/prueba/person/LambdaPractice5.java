/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.person;

import java.util.function.Function;

/**
 * LAMBDA EXPRESSIONS - SOLUTIONS FOR PRACTICE #5
 */
public class LambdaPractice5 {
    
    public static void main(String[] args) {
        Person person = Person.getSomePeople().get(0);
        
        // EXERCISE #1
        // Create a lambda expression that returns the first name, last name and
        // city of a person. Then print the information of the variable 'person'
        // using this function.
        Function<Person, String> personInfo = p -> p.getFirstName()
                                                    .concat(" ")
                                                    .concat(p.getLastName())
                                                    .concat(" ")
                                                    .concat(p.getCity());
        System.out.println(personInfo.apply(person));
    }
}
