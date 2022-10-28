package kr.co.exam;

import java.util.Date;

public class Exam {
    public static void main(String[] args) {
        /*
         *
         */

        BirthDay birthDay1 = new BirthDay("19901015");
        BirthDay birthDay2 = new BirthDay("901030");
        BirthDay birthDay3 = new BirthDay(new Date());
        BirthDay birthDay4 = new BirthDay(new Date().getTime());
        BirthDay birthDay5 = new BirthDay(1990, 10, 15);

        System.out.println(birthDay1);
        System.out.println(birthDay2);
        System.out.println(birthDay3);
        System.out.println(birthDay4);
        System.out.println(birthDay5);

        System.out.println(birthDay1.nextBirthDay());
        System.out.println(birthDay2.nextBirthDay());
    }
}
