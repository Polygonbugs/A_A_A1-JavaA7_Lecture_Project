package kr.co.exam02.prac;

import java.util.Objects;

public class Subjects {
    private String name;
    private double score;
    private char grade;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public char getGrade() {
        return grade;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Subjects{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", grade=" + grade +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subjects subjects = (Subjects) o;
        return Double.compare(subjects.score, score) == 0 && grade == subjects.grade && Objects.equals(name, subjects.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score, grade);
    }
}
