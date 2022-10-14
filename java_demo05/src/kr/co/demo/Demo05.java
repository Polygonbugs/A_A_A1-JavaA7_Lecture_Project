package kr.co.demo;

import java.util.Arrays;
import java.util.Scanner;

public class Demo05 {
    public static void main(String[] args) {
        /*
         *      동적 배열
         *          Arrays.copyOf를 이용한 깊은 복사
         *          배열 크기를 늘리거나 축소하는 등의
         *          새로운 배열을 복사하는 작업에서는 편함
         *
         *          만약 동일한 크기의 새로운 배열을 복사하고 싶은 경우
         *          이면 원본배열.clone() 하면 됨.
         */

        Scanner sc = new Scanner(System.in);

        int[] arr1 = new int[3];
        arr1[0] = 1; arr1[1] = 2; arr1[2] = 3;


        arr1 = Arrays.copyOf(arr1, arr1.length + 3);
        for(int i = 3; i > 0; i--) {
            arr1[arr1.length - i] = i;
        }

        int[] arr2 = arr1.clone();

        for(int i = 0; i < arr1.length; i++) {
            System.out.printf("arr1 : %d\t", arr1[i]);
        }

        System.out.println();

        System.out.println(Arrays.toString(arr2));

    }
}
