package kr.co.exam03.prac;

import java.util.Objects;

public class Person {
    private String name;
    private int age;
    private String rank;

    public Person() {}

    public Person(String name, int age, String rank) {
        this.name = name;
        this.age = age;
        this.rank = rank;
    }

    public void workOn() {
        System.out.printf("%s %s이(가) 출근을 했습니다.", rank, name);
    }

    public void workOff() {
        System.out.printf("%s %s이(가) 퇴근을 했습니다.", rank, name);
    }

    public void getLunch() {
        System.out.printf("%s %s이(가) 점심식사를 했습니다.", rank, name);
    }

    public void nightShift() {
        System.out.printf("%s %s이(가) 야근을 했습니다.", rank, name);
    }

    public void researchData() {
        System.out.printf("%s %s이(가) 자료조사를 했습니다.", rank, name);
    }

    public void createDocument() {
        System.out.printf("%s %s이(가) 문서작성을 했습니다.", rank, name);
    }

    public void callBusiness() {
        System.out.printf("%s %s이(가) 업체에 전화를 했습니다.", rank, name);
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

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", rank='" + rank + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name) && Objects.equals(rank, person.rank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, rank);
    }
}
