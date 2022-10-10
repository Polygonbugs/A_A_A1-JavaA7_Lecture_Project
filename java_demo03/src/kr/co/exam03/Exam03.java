package kr.co.exam03;

import java.util.Scanner;

public class Exam03 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int totalAmount, count, perAmount, leftAmount;
        String bankNumber;

        System.out.print("입금 계좌 번호 : ");
        bankNumber = sc.nextLine();

        System.out.print("총금액 : ");
        totalAmount = sc.nextInt();

        System.out.print("인원수 : ");
        count = sc.nextInt();

        perAmount = totalAmount / count;
        leftAmount = totalAmount % count;

        String message = "총 금액 %d원을 %d명이 나누어 인당 %d원을 \n"
                + "다음의 계좌에 입금해주세요. 나머지 금액 %d원은 제가\n"
                + "부담할께요.\n"
                + "입금 계좌 : %s";

        System.out.printf(message, totalAmount, count, perAmount, leftAmount, bankNumber);

    }

}
