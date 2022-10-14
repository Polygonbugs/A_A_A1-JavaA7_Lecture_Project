package kr.co.exam;

import java.util.Arrays;
import java.util.Random;

public class Exam06_ans3 {
    public static void main(String[] args) {
        /*      1번 문제
         *      크기가 0인 배열을 생성 후 Random을 사용하여
         *      배열의 값들을 초기화 한다.
         *      Random은 0 ~ 100사이의 난수값이 생성되도록 함
         *      배열에는 홀수에 해당하는 값만 5개 저장되도록 한다.
         *
         *      System.arraycopy() 이용
         */


        Random rand = new Random();
        int odd[] = new int[0];

        for(int i = 0; i < 5;) {
            int num = rand.nextInt(101);


            if(num % 2 == 1) {
                // 기존보다 길이가 크거나 작은 새로운 배열변수를 만들어서 기존 배열변수에 있는 값을 복사한다.
                odd = Arrays.copyOf(odd, odd.length + 1);

                // 새로운 배열변수의 마지막 요소에 값 추가하기
                odd[odd.length - 1] = num;      // 이 코드를 작성할 경우 "odd[odd.length - 1] num;"는 쓰지 않는다.

                // 홀수인 경우에만 배열의 다음 요소로 넘어가도록 한다.
                i++;

                // 디버깅 코드
                System.out.printf("%d 값 추가함 \n", num);
                for(int j = 0; j < odd.length; j++) {
                    System.out.printf("%d\t",odd[j]);
                }
            }
        }
    }
}
