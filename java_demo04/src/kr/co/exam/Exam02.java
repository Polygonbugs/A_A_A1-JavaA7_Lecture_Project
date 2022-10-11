package kr.co.exam;

import java.util.Scanner;

public class Exam02 {
    public static void main(String[] args) {
        /*
         *     사용자 입력과 if문을 활용하여 사용자로부터 정수값을
         *     입력 받았을 때 5의 배수 값만 출력하게 하세요
         */

        Scanner sc = new Scanner(System.in);

        int input;
        System.out.print("정수 값을 입력하세요 : ");
        input = sc.nextInt();

        if(input % 5 ==0) {
            System.out.printf("5의 배수 %d 입니다", input);
        } else {
            System.out.printf("%d은(는) 5의 배수가 아닙니다.", input);
        }

        sc.close();
    }
}
