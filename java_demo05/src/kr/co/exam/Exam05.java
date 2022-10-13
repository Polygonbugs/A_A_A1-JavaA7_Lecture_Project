package kr.co.exam;

import java.util.Random;

public class Exam05 {
    public static void main(String[] args) {
        /*      1번 문제
         *      크기가 10인 배열을 생성 후 Random을 사용하여
         *      배열의 값들을 초기화 한다.
         *      Random은 0 ~ 100사이의 난수값이 생성되도록 함
         */
        /*      1번 문제 알고리즘
         *      1. 크기가 10인 배열을 생성한다
         *      2. 생성된 배열에 Random 함수를 이용해 값을 할당한다.
         *      (조건, 0 ~ 100사이의 난수값이 생성되어야 한다)
         */

        Random random = new Random();
        int[] arr1 = new int[10];

        for(int i =0; i < arr1.length; i++) {
            arr1[i] = random.nextInt(101);
        }

        /*      2번 문제
         *      1번에서 생성한 배열을 그대로 사용하여 배열 안에 있는
         *      정수값 중 짝수에 해당하는 값만 분류하여 출력하도록 한다.
         *      (짝수값의 수량도 마지막에 출력되게 한다.)
         */
        /*      2번 문제 알고리즘
         *      1. 배열안에 있는 값을 출력한다
         *      (조건, 출력값은 짝수이다)
         *      2. 배열 안에 있는 짝수 값 개수를 출력한다.
         */
        int count = 0;

        for(int i = 0; i < arr1.length; i++) {
            if(arr1[i] % 2 == 0) {
                System.out.printf("index %d번 : %d\n", i, arr1[i]);
                count++;
            }
        }
        System.out.printf("배열 안에 있는 짝수의 갯수 : %d\n", count);

        /*      3번 문제
         *      2번에 의해 분류된 짝수들만을 모아두기 위한 새로운 정수
         *      배열을 만들고 저장한다.
         */
        /*      3번 문제 알고리즘
         *      1. 짝수 값을 새로운 배열에 저장한다.
         *      (조건, 자료형은 정수배열 사용)
         */

        int arr2[] = new int[10];

        for(int i = 0; i < arr2.length; i++) {

            if(arr1[i] % 2 == 0) {
                arr2[i] = arr1[i];
            }
        }

        for(int i = 0; i < arr2.length; i++) {
            System.out.printf("%d\t", arr2[i]);
        }


    }
}
