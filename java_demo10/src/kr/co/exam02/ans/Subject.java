package kr.co.exam02.ans;

import java.util.Objects;

public class Subject {

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
        return "Subject [name=" + name + ", score=" + score + ", grade=" + grade + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(grade, name, score);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Subject other = (Subject) obj;
        return grade == other.grade && Objects.equals(name, other.name)
                && Double.doubleToLongBits(score) == Double.doubleToLongBits(other.score);
    }
}