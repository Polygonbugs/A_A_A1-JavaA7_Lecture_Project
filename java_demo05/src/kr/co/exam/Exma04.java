package kr.co.exam;

import java.util.Scanner;

public class Exma04 {
    public static void main(String[] args) {
        /*
         *      Exam04.java 파일을 생성 후 다음의 문제를 풀어보세요.
         *      Exam03.java와 동일한 과정으로 배열을 생성할 때
         *      중복된 값이 없도록 초기화 하게 하세요.
         */

        Scanner sc = new Scanner(System.in);

        System.out.print("2 ~ 5사이의 정수값을 입력 하세요 : ");
        int size = sc.nextInt();

        int arr[] = new int[size];

        for(int i = 0; i < arr.length; i++) {
            System.out.print("1 ~ 10까지의 수 중에서 초기화할 값을 입력하세요 : ");
            arr[i] = sc.nextInt();
        }
    }
}
