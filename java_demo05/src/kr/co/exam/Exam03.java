package kr.co.exam;

import java.util.Scanner;

public class Exam03 {
    public static void main(String[] args) {
        /*
         * Exam03.java 파일을 생성 후 다음의 문제를 풀어보세요.
         * 사용자 입력으로 2 ~ 5 사이의 정수 값을 입력 받아
         * 입력 받은 정수값과 동일한 크기의 배열을 생성하고,
         * 배열의 값을 초기화 하기 위해 다시 사용자 입력을 사용하여
         * 1 ~ 10 사이의 값만을 입력 받아 초기화 하세요.
         */

        Scanner sc = new Scanner(System.in);

        System.out.print("2 ~ 5사이의 정수값을 입력 하세요 : ");
        int size = sc.nextInt();

        int arr[] = new int[size];


        for(int i = 0; i < arr.length; i++) {
            System.out.print("1 ~ 10까지의 수중에서 초기화할 값을 입력하세요 : ");
            arr[i] = sc.nextInt(); //sc.nextLine();
            System.out.println();
        }

        for(int i = 0; i < arr.length; i++) {
            System.out.printf("%d\n", arr[i]);
        }

    }
}
