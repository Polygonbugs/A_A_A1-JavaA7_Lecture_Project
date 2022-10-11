package kr.co.demo;

import java.util.Scanner;

public class Demo02 {
    public static void main(String[] args) {
        /*
         *      문자열 비교
         */

        Scanner sc = new Scanner(System.in);
        String s1, s2;
        s1 = "Hello";

        System.out.print("문자열 입력 : ");
        s2 = sc.nextLine();

        /*
        if(s1 == s2) {
            System.out.println("코드에 저장된 리터럴 값 s1과 사용자가 입력한 문장려 s2가 같습니다.");
        } else {
            System.out.println("코드에 저장된 리터럴 값 s1과 사용자가 입력한 문자열 값 s2가 다릅니다.");
        }

         */
        if(s1.equals(s2)) {
            System.out.println("코드에 저장된 리터럴 값 s1과 사용자가 입력한 문자열 s2가 같습니다.");
        } else {
            System.out.println("코드에 저장된 리터럴 값 s1과 사용자가 입력한 문자열 값 s2가 다릅니다.");
        }


    }
}
