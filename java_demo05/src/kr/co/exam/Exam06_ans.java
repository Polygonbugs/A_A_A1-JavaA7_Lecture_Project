package kr.co.exam;

import java.util.Random;

public class Exam06_ans {
    public static void main(String[] args) {
        /*      1번 문제
         *      크기가 0인 배열을 생성 후 Random을 사용하여
         *      배열의 값들을 초기화 한다.
         *      Random은 0 ~ 100사이의 난수값이 생성되도록 함
         *      배열에는 홀수에 해당하는 값만 5개 저장되도록 한다.
         */

        Random rand = new Random();
        int odd[] = new int[0];

        for(int i = 0; i < 5;) {
            int num = rand.nextInt(101);


            if(num % 2 == 1) {
                // 배열 추가
                int tmp[] = new int[odd.length + 1];

                // 새로운 배열에 값 옮기기(깊은 복사)
                for(int j = 0; j < odd.length; j++) {
                    tmp[j] = odd[j];
                }

                // 새로운 배열의 마지막 요소에 값 추가하기
                tmp[tmp.length - 1] = num;

                // 참조 주소 변경하기(얕은 복사)
                odd = tmp;

                // 홀수인 경우에만 배열의 다음 요소에 값을 저장
                i++;

                // 디버깅 코드
                System.out.printf("%d 값 추가함 \n", num);
                for(int j = 0; j < odd.length; j++) {
                    System.out.printf("%d\t",odd[j]);
                }
            }
        }

       /* for(int i = 0; i < odd.length; i++) {
            System.out.printf("%d\t",odd[i]);
        }*/
    }
}
