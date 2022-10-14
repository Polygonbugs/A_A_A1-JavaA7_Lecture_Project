package kr.co.exam;

import java.util.Arrays;
import java.util.Scanner;

public class Exam09_ans {
    public static void main(String[ ] args) {
        /*      문제09
         *      1. 다음의 문자열 배열을 생성한다.
         *          String subjects[] = {"국어", "영어", "수학"};
         *      2. 사용자로부터 1 ~ 5사이의 정수를 입력받는다.
         *      3. 1번에서 생성한 배열의 길이와 2번에서 입력한 정수의 값을
         *          사용하여 2차 배열을 생성한다.
         *      4. 3차 배열에 저장할 값을 사용자 입력을 통해 받는다
         *          국어 점수 입력 : 60
         *          수학 점수 입력 : 70
         *          영어 점수 입력 : 80
         *      5. 2차 배열에 저장된 값을 출력하여 확인한다.
         *          국어      영어      수학      평균      총점
         *          60        70        80        70.00     210
         *          60        75        82        72.33     217
         */

        Scanner sc = new Scanner(System.in);

        String subjects[] = {"국어", "영어", "수학"};

        int row = 0;
        while(true) {
            System.out.print("1 ~ 5 사이의 정수값 : ");
            row = sc.nextInt();

            if(row >= 1 && row <= 5) {
                break;
            }
        }

        int arr[][] = new int[row][subjects.length];

        for(int i = 0; i < arr.length; i++) {
            int sum = 0;
            System.out.printf("%d번 학생\n", i + 1);
            for(int j = 0; j < arr[i].length; j++) {
                System.out.printf("\t%s 점수 입력 : ", subjects[j]);
                int num = sc.nextInt();
                arr[i][j] = num;
                sum += num;
            }
            // 동적 배열을 활용해서 총점이 배열에 추가 될 수 있게 하세요
            arr[i] = Arrays.copyOf(arr[i], arr[i].length + 1);
            arr[i][arr[i].length - 1] = sum;
        }

        for(int j = 0; j < subjects.length; j++) {
            System.out.printf("%s\t", subjects[j]);
        }
        System.out.print("총점\t평균\n");

        for(int i = 0; i < arr.length; i++) {
            double avg;
            for(int j = 0; j < arr[i].length; j++) {
                System.out.printf("%d\t\t", arr[i][j]);
            }
            avg = (double)arr[i][arr[i].length - 1] / (arr[i].length - 1);
            System.out.printf("%.2f\n", avg);
        }


    }
}
