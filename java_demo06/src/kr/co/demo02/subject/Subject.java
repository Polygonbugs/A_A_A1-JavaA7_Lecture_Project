package kr.co.demo02.subject;

import kr.co.exam.Pen;

public class Subject {     // public을 지워보고 테스트 해보자
    private String name;
    private double score;

    public Subject(String name, double score) {
        this.name = name;
        this.score = score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public double getScore() {
        return this.score;
    }

    public String getGrade() {      // 반환형이 없는(void) 메서드를 제외한 메서드들은 반드시 return 을 써야한다.
        if(this.score >= 90 && this.score <= 100) {
            return "A";
        } else if(this.score >= 80 && this.score < 90) {
            return "B";
        } else if(this.score >= 70 && this.score < 80) {
            return "C";
        } else if(this.score >= 60 && this.score < 70) {
            return "D";
        } else {
            return "F";
        }
    }

}
