package kr.co.exam02.prac;

import java.util.Arrays;

public class Student extends Person{
    private String[] subjects;

    @Override
    public void addSubject(String subject) {
        subjects = Arrays.copyOf(subjects, subjects.length + 1);

    }

    public void findSubject(String subject) {

    }

    public void updateSubject(String subject) {

    }

    public void deleteSubject(String subject) {

    }
}
