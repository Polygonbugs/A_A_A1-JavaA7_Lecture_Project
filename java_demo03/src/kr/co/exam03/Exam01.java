package kr.co.exam03;

import java.util.Scanner;

public class Exam01 {

    public static void main(String[] args) {
        /*
         * 사용자 입력을 활용하여 다음의 데이터를 입력 받고 출력하시오.
         *
         * 키, 몸무게 정보를 입력 받아 각각 tall, weight 변수에 저장을 하고
         * BMI 계산 후 출력 하세요
         *
         * BMI 계산은 키^2 / 몸무게 입니다
         *
         * 출력 형식은 다음과 같습니다.
         *
         * 당신의 체질량 지수는 23.35 입니다.
         */

        Scanner sc = new Scanner(System.in);

        double tall, weight, bmi;

        System.out.print("키(m) : ");
        tall = sc.nextDouble();

        System.out.print("몸무게(kg) : ");
        weight = sc.nextDouble();

        bmi = weight / (tall * tall);

        System.out.printf("당신의 체질량 지수는 %.2f 입니다.", bmi);


    }

}
