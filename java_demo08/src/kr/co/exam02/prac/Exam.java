package kr.co.exam02.prac;

import java.util.Scanner;

public class Exam {
    public static void main(String[] args) {
        /*
         *      사용자 입력을 사용하여 010-xxxx-xxxx와 같은 형식의 전화번호를 입력 받으세요
         *
         *      1. 전화번호는 반드시 010으로 시작해야 합니다.
         *      2. - 으로 구분된 전화번호 형식이 입력되어야 합니다.
         *      3. 사용자가 입력하는 전화번호는 나중에 출력할 때 숨김 처리 되어
         *         출력이 되어야 합니다.
         *         입력 : 010-1234-5678
         *         출력 : 010-1234-****
         * 
         *      사용자가 입력한 주민등록번호를 통해 남자인지 여자인지를 구분하세요.
         *          1. 주민등록번호는 7번째 숫자가 1, 3 이면 남자입니다.
         *          2. 주민등록번호는 7번째 숫자가 2, 4 이면 여자입니다.
         */

        Scanner sc = new Scanner(System.in);
        String phoneNumber = null;
        String ssn = null;

        int idx = 0, count = 0;

        while(true) {
            System.out.print("휴대폰 번호를 입력하세요 : ");
            phoneNumber = sc.nextLine();

            if(!phoneNumber.startsWith("010")) {
                System.out.println("휴대폰 번호를 잘못 입력 하셨습니다. 다시 입력하세요");
                continue;
            }

            idx = phoneNumber.indexOf("-", idx);

            if(idx == -1) {
                System.out.println("휴대폰 번호에 - 를 붙여서 입력하세요.");
                continue;
            }

            idx++; count++;

            System.out.print("주민등록 번호를 입력하세요 : ");
            ssn = sc.nextLine();

            //if((ssn.indexOf("1",8)) {
            //    System.out.println("남자입니다.");
            //}
        }

 /*       for(int i = 0; i < ; )
        System.out.println();*/

    }
}
