/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.person;

import java.util.List;

/**
 * LAMBDA EXPRESSIONS - SOLUTIONS FOR PRACTICE #1
 */
public class LambdaPractice1 {

    public static void main(String[] args) {
        List<Person> people = Person.getSomePeople();
        LambdaPractice1 practice1 = new LambdaPractice1();

        System.out.println("-- Calling people over 18");
        // EXERCISE #1
        // Replace the anonymous inner class with a full lambda expression.
        practice1.callPeople(people, (Person person) -> { return person.getAge() >= 18; });

        System.out.println("\n-- Calling people from Houston");
        // EXERCISE #2
        // Replace the anonymous inner class with a short lambda expression.
        practice1.callPeople(people, p -> "Houston".equals(p.getCity()));

        System.out.println("\n-- Calling people whose initials are a repeated letter");
        // EXERCISE #3
        // Replace the aononymous inner class with a multi line code block lambda expression.
        practice1.callPeople(people, person -> {
                char firstNameInitial = person.getFirstName().charAt(0);
                char lastNameInitial = person.getLastName().charAt(0);
                return firstNameInitial == lastNameInitial;
        });
    }

    public void callPeople(List<Person> people, Check<Person> check) {
        for(Person person : people) {
            if(check.check(person)) {
                System.out.println("Calling: " + person);
            }
        }
    }

}
