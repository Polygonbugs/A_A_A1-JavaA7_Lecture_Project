package kr.co.exam;

import java.util.Random;

public class Exam06 {
    public static void main(String[] args) {
        /*      1번 문제
         *      크기가 0인 배열을 생성 후 Random을 사용하여
         *      배열의 값들을 초기화 한다.
         *      Random은 0 ~ 100사이의 난수값이 생성되도록 함
         *      배열에는 홀수에 해당하는 값만 5개 저장되도록 한다.
         */
        /*
         *      1번 문제 알고리즘
         *      1. 크기가 0인 배열을 생성
         *      2. 동적할당을 이용해 배열의 개수를 늘리면서 동시에 값을 저장한다.
         *      (조건. 난수는 0 ~ 100사이의 값을 저장한다. 배열의 개수는 5개까지 동적할당으로 늘린다. 홀수에 해당하는 값만 5개 저장한다.)
         */

        Random random = new Random();

        int odd[] = new int[0];

        for(int i = 0; i < 5;) {
            int num = random.nextInt(101);

            int[] tmp = new int[odd.length + 1];

            for(int j = 0; j < odd.length; j++) {
                tmp[j] = odd[j];
            }

            if(num % 2 != 0) {
                tmp[tmp.length - 1] = num;
                i++;
                odd = tmp;
            }

            System.out.printf("odd 배열의 크기가 %d 가 되었습니다.\n", odd.length);
        }

        for(int i = 0; i < odd.length; i++) {
            System.out.printf("%d\t", odd[i]);
        }







    }
}
