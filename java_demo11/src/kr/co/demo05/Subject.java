package kr.co.demo05;

import java.util.Objects;

public class Subject implements Comparable<Subject>{
    private String name;
    private double score;
    private char grade;

    public Subject(String name, double score) {
        this.name = name;
        this.score = score;
        setGrade();
    }

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

    public void setGrade() {
        switch ((int) this.score / 10) {
            case 10:
            case 9:
                this.grade = 'A';
                break;
            case 8:
                this.grade = 'B';
                break;
            case 7:
                this.grade = 'C';
                break;
            case 6:
                this.grade = 'D';
                break;
            case 5:
                this.grade = 'E';
                break;
            default:
                this.grade = 'F';
        }
    }

    @Override
    public String toString() {
        return "Subject{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", grade=" + grade +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return Double.compare(subject.score, score) == 0 && grade == subject.grade && Objects.equals(name, subject.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score, grade);
    }

    @Override
    public int compareTo(Subject o) {
        if(this.score > o.score) {
            return 1;
        } else if(this.score < o.score) {
            return -1;
        }
        return 0;
    }
}
