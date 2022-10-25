package kr.co.exam03.prac;

public class Intern extends Person {

    public Intern(String name, int age, String rank) {
        super(name, age, rank);
    }

    public void filing() {
        System.out.printf("%s %s가 서류를 정리합니다.", super.getRank(), super.getName());
    }

    public void filCopy() {
        System.out.printf("%s %s가 자료를 복사합니다.", super.getRank(), super.getName());
    }
}
