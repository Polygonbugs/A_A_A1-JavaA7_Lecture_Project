package kr.co.demo01;

public class Student extends Person {
    private int year;
    private int classRoom;

    public Student(String name) {
        super(name);
        // this.setName(name);과 같은 역할이지만 super를 써야 한다.
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

}
