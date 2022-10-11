package kr.co.exam;

import java.util.Scanner;

public class Exam03 {
    public static void main(String[] args) {
        /*
         *      사용자 입력과 if문을 활용하여 사용자로부터 정수값
         *      2개를 입력받아 나누기 계산을 수행하고 그 결과를
         *      출력하세요. 만약 사용자 입력값 중에 0이 있어서
         *      산술에러가 발생하는 경우 이를 처리하기 위한 if문을
         *      추가로 작성하세요.
         */

        Scanner sc = new Scanner(System.in);

        int input1, input2;
        double result;

        System.out.print("첫번째 정수 갑을 입력하세요 : ");
        input1 = sc.nextInt();
        System.out.print("두번째 정수 갑을 입력하세요 : ");
        input2 = sc.nextInt();

        if(input2 != 0) {
            result = (double)input1 / input2;
            System.out.printf("결과값 : %.2f", result);
        } else {
            System.out.println("두번째 입력값에는 0을 대입할 수 없습니다.");
        }

        sc.close();
    }
}
