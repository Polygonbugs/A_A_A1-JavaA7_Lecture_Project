package kr.co.exam02.ans2;

import java.util.Scanner;

public class Exam {
    public static void main(String[] args) {
        /*
         * 사용자 입력을 사용하여 010-xxxx-xxxx 과 같은 형식의 전화번호를
         * 입력 받으세요.
         *     1. 전화번호는 반드시 010 으로 시작해야 합니다.
         *     2. - 으로 구분된 전화번호 형식이 입력되어야 합니다.
         *     3. 사용자가 입력하는 전화번호는 나중에 출력할 때 숨김 처리 되어
         *        출력이 되어야 합니다.
         *        입력 : 010-1234-5678
         *        출력 : 010-1234-****
         */
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.print("전화번호 입력 : ");
            String input = sc.nextLine();

            if(input.contains("exit")) {
                break;
            }

            Phone phone = Phone.valueOf(input);

            if(phone.isValid()) {
                System.out.println(phone.getNumber(true));
                break;
            }
        }

    }
}
