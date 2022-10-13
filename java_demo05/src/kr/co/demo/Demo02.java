package kr.co.demo;

import java.util.Random;

public class Demo02 {
    public static void main(String[] args) {
        /*
         *      Random 클래스
         *          난숫값을 생성하기 위한 클래스
         */

        Random random = new Random();
        int[] lotto = new int[6];

        for(int i = 0; i < 6; i++) {
            lotto[i] = random.nextInt(45) + 1;     // "Random 자료형의 변수명".nextInt(범위값) : 0 ~ (범위값 - 1)의 수를 랜덤하게 넣는다.
        }

        for(int i = 0; i < 6; i++) {
            System.out.printf("%d\t", lotto[i]);
        }
        System.out.println();

    }
}
