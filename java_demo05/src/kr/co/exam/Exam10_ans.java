package kr.co.exam;

import java.util.Arrays;
import java.util.Random;

public class Exam10_ans {
    public static void main(String[] args) {
        /*
         *      1. 10 ~ 99 사이의 랜덤값을 10개 생성하여 정수 배열에 추가한다.
         */
        Random rand = new Random();

        int arr[] = new int[0];

        for(; arr.length < 10;) {
            arr = Arrays.copyOf(arr, arr.length + 1);
            arr[arr.length - 1] = rand.nextInt(90) + 10;
        }
        System.out.println(Arrays.toString(arr));

        /*
         *      2. 1번에서 생성한 정수값을 짝수와 홀수로 나누어 2차 배열에 추가한다.
         *         { {8, 6, 4, 6}, {1, 5, 3, 9, 5, 5} }
         */

        int arr1[][] = new int[2][0];

        for(int i = 0; i < arr.length; i++) {
            int idx = arr[i] % 2;
            arr1[idx] = Arrays.copyOf(arr1[idx], arr1[idx].length + 1);
            arr1[idx][arr1[idx].length - 1] = arr[i];
        }

        System.out.println(Arrays.toString(arr1[0]));
        System.out.println(Arrays.toString(arr1[1]));


        /*
         *      3. 2번에서 생성된 2차 배열에 추가로 10 ~ 99 사이의 랜덤을 생성하여
         *         저장할 때 짝수는 짝수배열에 홀수는 홀수배열에 저장되도록 한다.
         *         (여기에 추가하는 정수는 2차 배열의 중첩된 배열의 크기가 10개가
         *          될 때까지 수행한다.)
         *          { {8, 6, 4, 6, 6, 8, 4, 2, 6, 8}, {1, 5, 3, 9, 5, 5, 7, 1, 3, 9} }
         */

        while(arr1[0].length < 10 || arr1[1].length < 10) {
            int num = rand.nextInt(90) + 10;
            int idx = num % 2;

            if(arr1[idx].length < 10) {
                arr1[idx] = Arrays.copyOf(arr1[idx], arr1[idx].length + 1);
                arr1[idx][arr1[idx].length - 1] = num;
            }
        }

        System.out.println("짝수 : " + Arrays.toString(arr1[0]));
        System.out.println("홀수 : " + Arrays.toString(arr1[1]));
        /*
         *      4. 3번에서 완성된 2차 배열의 동일한 열(인덱스)의 값의 합을 구하여
         *         3번째(2번 인덱스)에 추가할 배열로 만들어 추가한다.
         *
         *         {{8,     6,      4,      6,      6,      8,      4,      2,      6,      8},
         *          {1,     5,      3,      9,      5,      5,      7,      1,      3,      9},
         *          {9,     11,     7,      15,     11,     13,     11,     3,      9,      17} }
         */
        int arr2[][] = Arrays.copyOf(arr1, arr1.length + 1);
        arr2[2] = new int[0];

        for(int i = 0; i < arr2[0].length; i++) {
            arr2[2] = Arrays.copyOf(arr2[2], arr2[2].length + 1);
            arr2[2][i] = arr2[0][i] + arr2[1][i];
        }

        System.out.println("\n짝수 : " + Arrays.toString(arr2[0]));
        System.out.println("홀수 : " + Arrays.toString(arr2[1]));
        System.out.println("합 : " + Arrays.toString(arr2[2]));


    }
}
