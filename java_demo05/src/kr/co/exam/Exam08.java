package kr.co.exam;

import java.util.Random;
import java.util.Scanner;

public class Exam08 {
    public static void main(String[] args) {
        /*      문제 08
         *      Random 클래스를 활용하여 다음의 문제를 풀어보세요.
         *          1. Scanner 클래스로 사용자로부터 1 ~ 5 사이의 정수 입력 받는다.
         *          2. 1 ~ 45 까지의 난수 6개를 생성한다.
         *          3. 2차 배열을 생성할 때 행의 크기는 사용자 입력값, 열의 크기는 6으로 생성
         *          4. 2번에서 생성한 난수를 3번에서 생성한 2차배열에 전부 저장.
         *          5. 2차 배열에 저장된 값 출력해서 확인.
         *
         */

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int input = 0;

        while(!(input >= 1 && input <= 5)) {
            System.out.print("배열 크기(1 ~ 5 사이의 값 )입력하세요 : ");
            input = sc.nextInt();
        }

        int[][] reg_arr = new int[0][6];

        for(int i = 0; i < input; i++) {
            int[] rand_arr  = new int[6];

            for(int j = 0; j < rand_arr.length; j++) {
                rand_arr[j] = random.nextInt(45) + 1;
            }

            int[][] tmp_arr = new int[reg_arr.length + 1][6];

            for(int j = 0; j < reg_arr.length; j++) {
                for(int k = 0; k < reg_arr[0].length; k++) {
                    tmp_arr[j][k] = reg_arr[j][k];
                    tmp_arr[tmp_arr.length - 1][k] = rand_arr[k];
                }
            }

            reg_arr = tmp_arr;
        }

        for(int i = 0; i < reg_arr.length; i++) {
            for(int j = 0; j < reg_arr[0].length; j++) {
                System.out.printf("%d\t", reg_arr[i][j]);
            }
            System.out.println();
        }


    }
}
