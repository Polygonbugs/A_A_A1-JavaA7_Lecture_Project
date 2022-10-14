package kr.co.exam;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Exam08_ans {
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

        Random rand = new Random();
        Scanner sc = new Scanner(System.in);

        int row = 0;
        while(true) {
            System.out.print("1 ~ 5 사이의 정수값 : ");
            row = sc.nextInt();

            if(row >= 1 && row <= 5) {
                break;
            }
        }

        int arr[][] = new int[row][];
        int tmp[] = new int[6];

        for(int i =0; i < arr.length; i++) {
            for(int j = 0; j < 6; j++) {
                int num = rand.nextInt(45) + 1;
                tmp[j] = num;
            }
            arr[i] = tmp.clone();
        }

        for(int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }



    }
}
