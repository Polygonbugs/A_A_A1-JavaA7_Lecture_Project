package kr.co.exam;

import java.util.Arrays;
import java.util.Random;

public class Exam10 {
    public static void main(String[] args) {
        /*
         *      1. 10 ~ 99 사이의 랜덤값을 10개 생성하여 정수 배열에 추가한다.
         */
        Random random = new Random();
        int[][] rand = new int[2][10];

        for(int i = 0; i < rand.length; i++) {
            for(int j = 0; j < rand[i].length; j++){
                rand[i][j] = random.nextInt(89) + 10;
            }
        }

        /*
         *      2. 1번에서 생성한 정수값을 짝수와 홀수로 나누어 2차 배열에 추가한다.
         *         { {8, 6, 4, 6}, {1, 5, 3, 9, 5, 5} }
         */
        int[][] arr = new int[2][10];
        int odd_cnt = 0;
        int even_cnt = 0;

        for(int i = 0; i < rand.length; i++) {
            for(int j = 0; j < rand[i].length; j++){
                if(rand[i][j] % 2 == 0){
                    even_cnt++;
                } else {
                    odd_cnt++;
                }
            }
        }

        arr[0] = new int[even_cnt];
        arr[1] = new int[odd_cnt];

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++)
                if(rand[k] % 2 == 0) {
                    arr[0][j] = rand[k];
                } else {
                    arr[1][j] = rand[k];
                }
        }

        for(int i =0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }

        /*
         *      3. 2번에서 생성된 2차 배열에 추가로 10 ~ 99 사이의 랜덤을 생성하여
         *         저장할 때 짝수는 짝수배열에 홀수는 홀수배열에 저장되도록 한다.
         *         (여기에 추가하는 정수는 2차 배열의 중첩된 배열의 크기가 10개가
         *          될 때까지 수행한다.)
         *          { {8, 6, 4, 6, 6, 8, 4, 2, 6, 8}, {1, 5, 3, 9, 5, 5, 7, 1, 3, 9} }
         */


        /*
         *      4. 3번에서 완성된 2차 배열의 동일한 열(인덱스)의 값의 합을 구하여
         *         3번째(2번 인덱스)에 추가할 배열로 만들어 추가한다.
         *
         *         {{8,     6,      4,      6,      6,      8,      4,      2,      6,      8},
         *          {1,     5,      3,      9,      5,      5,      7,      1,      3,      9},
         *          {9,     11,     7,      15,     11,     13,     11,     3,      9,      17} }
         */
    }
}
