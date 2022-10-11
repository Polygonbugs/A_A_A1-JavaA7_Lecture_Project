package kr.co.exam;

import java.util.Scanner;

public class Exam06_ans {
    public static void main(String[] args) {
        /*
         *  사용자 입력과 if, for 문을 활용하여 사용자로부터 정수 값을
         *  입력 받았을 때 1 ~ 45 사이의 값이 아니면 다시 입력을 받아서
         *  1 ~ 45 사이의 값이 저장될 수 있게 한다.
         *  (단, 3번의 입력 기회만 부여하고 3번의 기회를 넘기면 0 값이 저장되게 한다.)
         */

        Scanner sc = new Scanner(System.in);
        int num = 0;

        for(int cnt = 1; cnt <= 3; cnt++) {
            System.out.print("1 ~ 45 사이의 정수 입력 : ");
            int input = sc.nextInt();
            if(input >= 1 && input <= 45) {
                num = input;
                break;
            } else {
                if(3 - cnt != 0){
                    System.out.printf("다시 입력하세요. 입력 기회 %d회 남음\n", 3 - cnt);
                } else {
                    System.out.println("모든 입력 기회를 소진하였습니다.");
                }
            }
        }

        System.out.printf("사용자 입력 값 %d를 변수 Num에 저장하였습니다.", num);

    }
}
