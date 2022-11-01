package kr.co.demo01;

import java.util.Comparator;
import java.util.Objects;

public class Subject implements Comparable<Subject> {

    private String name;
    private double score;

    public Subject(String name, double score) {
        this.name = name;
        this.score = score;
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

    @Override
    public String toString() {
        return "Subject{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
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
