package kr.co.exam;

import java.util.Scanner;

public class Exam06 {
    public static void main(String[] args) {
        /*
         *  사용자 입력과 if, for 문을 활용하여 사용자로부터 정수 값을
         *  입력 받았을 때 1 ~ 45 사이의 값이 아니면 다시 입력을 받아서
         *  1 ~ 45 사이의 값이 저장될 수 있게 한다.
         *  (단, 3번의 입력 기회만 부여하고 3번의 기회를 넘기면 0 값이 저장되게 한다.)
         */

        Scanner sc = new Scanner(System.in);

        int i, input;
        /*
        for(i = 0; i < 3; i++) {
            System.out.print("정수값을 입력하세요 : ");
            input = sc.nextInt();

            if(input >= 1 && input <= 45) {
                System.out.printf("성공적으로 %d의 수가 변수에 저장됬습니다.", input);
                break;
            }
        }

        if(i == 3) {
            input = 0;
            System.out.printf("세번의 시도가 모두 실패해 %d의 값이 저장되었습니다.", input);
        }

         */

        for(i = 0; i < 3; i++) {
            System.out.print("정수값을 입력하세요 : ");
            input = sc.nextInt();

            if(input >= 1 && input <= 45) {
                System.out.printf("성공적으로 %d의 수가 변수에 저장됬습니다.", input);
                break;
            } else if(i == 2) {
                input = 0;
                System.out.printf("세번의 시도가 모두 실패해 %d의 값이 저장되었습니다.\n", input);
            } else {
                System.out.printf("값이 1 ~ 45 사이에 있지 않습니다. 남은 입력 횟수 %d\n", 2 - i);
            }
        }


    }
}
