package kr.co.exam05.prac;

import java.util.Objects;

public class Student {
    private String name;
    private int grade;
    private int clas;
    private int studentNumber;

    public Student(String name, int grade, int clas, int studentNumber) {
        this.name = name;
        this.grade = grade;
        this.clas = clas;
        this.studentNumber = studentNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                ", clas=" + clas +
                ", studentNumber=" + studentNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return grade == student.grade && clas == student.clas && studentNumber == student.studentNumber && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, grade, clas, studentNumber);
    }
}
