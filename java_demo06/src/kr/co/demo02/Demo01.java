package kr.co.demo02;

import kr.co.demo02.subject.*;      // subject package 안에 있는 모든 클래스

public class Demo01 {
    public static void main(String[] args) {
        Student student1 = new Student("홍길동", 16);

        System.out.println(student1.getName());
        System.out.println(student1.getAge());
        System.out.println(student1.getGrade());

        Subject subject1 = new Subject("국어", 80);
        System.out.println(subject1.getName());
        System.out.println(subject1.getScore());
        System.out.println(subject1.getGrade());

    }
}
