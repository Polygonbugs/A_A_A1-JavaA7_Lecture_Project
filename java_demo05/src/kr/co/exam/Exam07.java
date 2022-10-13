package kr.co.exam;

import java.util.Scanner;

public class Exam07 {
    public static void main(String[] args) {
        /*
         *      사용자 입력을 받아서 다음의 기능을 수행하는 코드를 작성
         *          1. 입력한 횟수 만큼 정수 값을 입력 받아서 배열에 저장한다.
         *          2. 배열에 저장된 모든 정수의 합과 평균을 구하여 출력
         *          3. -1 입력이 들어오면 더 이상 사용자 입력을 받지 않는 것으로 한다.
         *
         *      예제
         *          1번째 정수값 입력 : 7
         *          2번째 정수값 입력 : 12
         *          3번째 정수값 입력 : 24
         *          4번째 정수갑 입력 : -1
         *
         *          총합 : 43
         *          평균 : 14.3
         */


        Scanner sc = new Scanner(System.in);
        int arr[] = new int[0];
        int count, sum = 0;
        double avg;

        System.out.print("입력 횟수를 입력하세요 : ");
        count = sc.nextInt();

        for(int i = 0; i < count; i++){
            System.out.printf("%d번째 정수값 입력 : ", i + 1);
            int num = sc.nextInt();

            if(num == -1) {
                break;
            }

            int tmp[];
            tmp = new int[arr.length + 1];

            for(int j = 0; j < arr.length; j++) {
                tmp[j] = arr[j];
            }

            tmp[tmp.length - 1] = num;

            arr = tmp;
        }

        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        avg = (double)sum / arr.length;

        System.out.printf("총합 : %d\n", sum);
        System.out.printf("평균 : %.1f\n", avg);
    }
}
