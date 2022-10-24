package kr.co.exam02.prac;

public class Person {
    private int grade;
    private int classroom;
    private String subject;

    public void addSubject(String subject){
        this.subject = subject;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getClassroom() {
        return classroom;
    }

    public void setClassroom(int classroom) {
        this.classroom = classroom;
    }
}
