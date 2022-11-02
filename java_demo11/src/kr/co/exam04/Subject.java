package kr.co.exam04;

import java.util.Objects;

public class Subject {
    private double score;
    private char grade;


    public Subject(double score, char grade) {
        this.score = score;
        this.grade = grade;
    }

    public char getGrade() {
        return grade;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "score=" + score +
                ", grade=" + grade +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return Double.compare(subject.score, score) == 0 && grade == subject.grade;
    }

    @Override
    public int hashCode() {
        return Objects.hash(score, grade);
    }
}