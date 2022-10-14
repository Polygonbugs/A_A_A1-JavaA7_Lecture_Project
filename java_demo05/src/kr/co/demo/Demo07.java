package kr.co.demo;

import java.util.Arrays;

public class Demo07 {
    public static void main(String[] args) {
        /*
         *      가변 길이 배열
         *          중첩된 배열의 길이(크기)를 동일하지 않은 크기의 배열로
         *          만들어서 사용하는 형태
         */
        int arr[][] = new int[3][];

        arr[0] = new int[4];
        arr[1] = new int[8];
        arr[2] = new int[5];

        for(int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }

        for(int i = 0; i < arr.length; i++) {
            for(int j =0; j < arr[i].length; j++) { // 가변 배열의 길이는 arr[i].length를 이용
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }


    }
}
