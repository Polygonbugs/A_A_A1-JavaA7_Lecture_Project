package kr.co.exam;

import java.util.Scanner;

public class Exam03_ans {
    public static void main(String[] args) {
        /*
         *      사용자 입력과 if문을 활용하여 사용자로부터 정수값
         *      2개를 입력받아 나누기 계산을 수행하고 그 결과를
         *      출력하세요. 만약 사용자 입력값 중에 0이 있어서
         *      산술에러가 발생하는 경우 이를 처리하기 위한 if문을
         *      추가로 작성하세요.
         */

        Scanner sc = new Scanner(System.in);

        int x, y;

        System.out.print("첫번째 정수 값 입력 : ");
        x = sc.nextInt();

        System.out.print("두번째 정수 값 입력 : ");
        y = sc.nextInt();

        if(y == 0) {
            System.out.println("0으로 나누기 계산을 수행할 수 없습니다.");
            System.out.println("대신 1로 대체하여 수행합니다.");
            y = 1;
        }
        System.out.printf("입력한 정수값에 대한 나누기 계산 결과 -> %d ", x / y);


        /*
        if(y != 0) {
            System.out.printf("입력한 정수값에 대한 나누기 계산 결과 -> %d ", x / y);
        } else {
            System.out.println("두번째로 입력한 정수가 0이기 때문에 나누기 계산을 수행할 수 없습니다.");
            System.out.println("대신 0을 1로 변경하여 수행합니다.");
            System.out.printf("계산 결과 -> %d", x / 1);
        }
        */

    }
}
