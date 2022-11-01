package kr.co.demo06;

import java.io.Serializable;
import java.util.Objects;

public class Subject implements Serializable { // Object 관련 스트림을 쓸려면 사용하는 해당 객체에 serizable interface를 이용해야 한다.
    private String name;
    private int age;
    private char gender;

    public Subject(String name) {
        this.name = name;
    }

    public Subject(String name, int age) {
        this.name = name;
        this.age = age;
    }

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
        return "Subject{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return age == subject.age && gender == subject.gender && Objects.equals(name, subject.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, gender);
    }
}
