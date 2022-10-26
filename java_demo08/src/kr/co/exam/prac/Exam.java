package kr.co.exam.prac;

import java.util.Arrays;
import java.util.Scanner;

public class Exam {
    public static void main(String[] args) {
        /*
         *   Scanner 클래스를 사용하여 사용자 입력을 받고 다음의 작업을 수행해 보세요
         *
         *      1. nextLine() 메서드를 사용하여 정수에 해당하는 문자열을 입력받으세요.
         *         입력 형식은 "10 20 30 40 ..." 형식으로 정수에 해당하는 값 중간에
         *         공백으로 띄어진 형태입니다.
         *         이와 같이 입력 받은 정수 형태의 문자열을 공백을 기준으로 분류하여 문자열
         *         배열에 저장하세요.
         *         만약 공백이 아닌 ","와 같은 문자를 구분자로 사용한 경우 다시 입력하도록 하세요.
         *
         */

        Scanner sc = new Scanner(System.in);

        String[ ] arr = null;

        String str = null;

        int idx = 0;


        while(true) {
            if(idx == 0) {
                System.out.println("문자열을 입력하세요 : ");
                str = sc.nextLine();
            }
            if(str.contains(",")) {
                System.out.println("문자열을 잘못 입력하셨습니다. 다시 입력하세요");
                continue;
            } else {
                arr = str.split(" ");
                break;
            }
        }

        System.out.println(Arrays.toString(arr));

    }
}
