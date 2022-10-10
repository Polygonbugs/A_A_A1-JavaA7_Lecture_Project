package kr.co.exam03;

import java.util.Scanner;

public class Exam02 {

    public static void main(String[] args) {
        /*
         * 예시
         * 		시 : 0
         * 		분 : 10
         * 		초 : 20
         *
         * 		총 620초 입니다.
         *
         */
        Scanner sc = new Scanner(System.in);

        int hour, minute, second, total;

        System.out.print("시 : ");
        hour = sc.nextInt();

        System.out.print("분 : ");
        minute = sc.nextInt();

        System.out.print("초 : ");
        second = sc.nextInt();

        total = second;
        total = total + minute * 60; //total += minute * 60;
        total = total + hour * 3600; //total += hour * 3600;

        System.out.printf("총 %d초 입니다", total);

    }

}
