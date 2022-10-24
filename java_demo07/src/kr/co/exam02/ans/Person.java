package kr.co.exam02.ans;

public class Person {
    private int year;
    private int classRoom;
    private String subject[];

    public Person() {
        this.subject = new String[0];
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(int classRoom) {
        this.classRoom = classRoom;
    }

    public void setSubject(String subject) {

    }

    public String getSubject(String subject) {
        return null;
    }

    public void updateSubject(String subject) {

    }
    public void removeSubject(String subject) {

    }
}
