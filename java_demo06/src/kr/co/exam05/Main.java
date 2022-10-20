package kr.co.exam05;

public class Main {
    public static void main(String[ ] args) {
        Student s1 = new Student("홍길동", 24);

        s1.addSubject("a1", 99);
        s1.addSubject("a2", 50);
        s1.addSubject("a3", 70);
        s1.addSubject("a4", 30);

        s1.getMenu();
    }
}
