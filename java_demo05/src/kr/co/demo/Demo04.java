package kr.co.demo;

import java.util.Scanner;

public class Demo04 {
    public static void main(String[] args) {
        /*
         *      동적 배열
         *          System.arraycopy를 이용한 깊은 복사
         *          테스트
         */

        Scanner sc = new Scanner(System.in);

        int[] arr1 = new int[3];
        arr1[0] = 1; arr1[1] = 2; arr1[2] = 3;

        int tmp[];

        for(int i = 0; i < 5; i++) {
            System.out.print("정수값을 입력하세요 : ");
            int num = sc.nextInt();

            // 기존 배열 크기보다 +1 또는 -1 증감한 새로운 배열 생성
            tmp = new int[arr1.length + 1];

            // 기존 배열의 데이터를 새로 생성한 배열에 복사 -> 깊은 복사
            System.arraycopy(arr1, 0, tmp, 1, arr1.length);

            // 배열의 크기가 증가된 경우 새로우 값 추가.
            tmp[0] = num;

            // 얕은 복사 : 참조주소를 복사한다.
            arr1 = tmp;

            System.out.printf("arr1 배열의 크기가 %d 가 되었습니다.\n", arr1.length);
        }

        for(int i = 0; i < arr1.length; i++) {
            System.out.printf("%d\t", arr1[i]);
        }

    }
}
