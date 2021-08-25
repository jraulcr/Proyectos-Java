package com.prueba.person;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Person {
	

    private long id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private int age;
    private String city;
    private State state;
    
    public enum Gender { Male, Female }
    
    public enum State { AZ, MA, FL, TX }
    
    public Person(long id, String firstName, String lastName, Gender gender, int age, String city, State state) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.city = city;
        this.state = state;
    }
    
    public String toString() {
        StringBuilder info = new StringBuilder();
        info.append("ID=").append(id);
        info.append(", First Name=").append(firstName);
        info.append(", Last Name=").append(lastName);
        info.append(", Gender=").append(gender);
        info.append(", Age=").append(age);
        info.append(", City=").append(city);
        info.append(", State=").append(state);
        return info.toString();
    }
    
    public static List<Person> getSomePeople() {
        List<Person> people = new ArrayList<>();
        people.add(new Person(1, "Michael", "McMillan", Gender.Male, 20, "Tucson", State.AZ));
        people.add(new Person(2, "Diane", "Scott", Gender.Female, 38, "Boston", State.MA));
        people.add(new Person(3, "Lisa", "Harris", Gender.Female, 15, "Tallahassee", State.FL));
        people.add(new Person(4, "Bob", "Lyles", Gender.Male, 52, "Houston", State.TX));
        people.add(new Person(5, "Samantha", "Yard", Gender.Female, 29, "Houston", State.TX));
        people.add(new Person(6, "Paul", "Vance", Gender.Male, 17, "Phoenix", State.AZ));
        return people;
    }
    
    public static Map<String, String> getSomePeopleInMap() {
        return getSomePeople().stream()
                              .collect(Collectors.toMap(Person::getFirstName, Person::getCity));
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
    

}
