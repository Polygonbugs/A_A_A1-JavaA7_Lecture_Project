package kr.co.exam05.ans;

import java.util.Objects;

public class Student {
    private String name;
    private int classYear;
    private int classRoom;
    private int classNumber;

    public Student(String name, int classYear, int classRoom, int classNumber) {
        this.name = name;
        this.classYear = classYear;
        this.classRoom = classRoom;
        this.classNumber = classNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getClassYear() {
        return classYear;
    }

    public void setClassYear(int classYear) {
        this.classYear = classYear;
    }

    public int getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(int classRoom) {
        this.classRoom = classRoom;
    }

    public int getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(int classNumber) {
        this.classNumber = classNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", classYear=" + classYear +
                ", classRoom=" + classRoom +
                ", classNumber=" + classNumber +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return classYear == student.classYear && classRoom == student.classRoom && classNumber == student.classNumber && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, classYear, classRoom, classNumber);
    }
}
