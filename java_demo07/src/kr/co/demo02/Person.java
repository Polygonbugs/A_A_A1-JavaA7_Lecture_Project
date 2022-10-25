package kr.co.demo02;

import java.util.Objects;

public class Person {
    private String name;
    private int age;
    private char gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return String.format("Person[name : %s, age : %d]", this.name, this.age);
    }

/*    @Override
    public boolean equals(Object obj) {
        Person person = (Person)obj;

        if(name.equals(person.getName()) &&
                age == person.getAge() &&
                gender == person.getGender()) {
            return true;
        }
        return false;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Person person = (Person) o;
        return age == person.age && gender == person.gender && Objects.equals(name, person.name);
    }

}
