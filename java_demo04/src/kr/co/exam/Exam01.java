package kr.co.exam;

import java.util.Scanner;

public class Exam01 {
    public static void main(String[] args) {
        /*
         *  사용자 입력과 if 문을 활용하여 사용자로부터 정수 값을
         *  입력 받았을 때 1 ~ 45 사이의 값만 출력 하세요.
         */

        Scanner sc = new Scanner(System.in);

        int input;
        System.out.print("정수값을 입력 하세요 : ");
        input = sc.nextInt();

        if(input > 0 && input < 46) {
            System.out.printf("input 값 : %d", input);
        } else {
            System.out.println("정수 1 ~ 45를 넘는 값을 입력 하셨습니다.");
        }

        sc.close();
    }
}
