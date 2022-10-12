package kr.co.exam;

import java.util.Scanner;

public class Exam09 {
    public static void main(String[] args) {
        /*
         *      사용자 입력으로 월, 시작 요일, 마지막 일자 정보를
         *      입력 받아 다음 예시와 같이 출력하세요.
         *      예시
         *          월 : 10
         *          시작요일 : 토
         * '        마지막일자 : 31
         *
         *          일   월   화   수   목   금   토
         *                                     1
         *          2   3   4   5   6   7   8
         *          9   10  11  12  13  14  15
         *          16  17  18  19  20  21  22
         *          23  24  25  26  27  28  29
         *          30  31
         */

        Scanner sc = new Scanner(System.in);

        int month, lastDate;
        String startWeekDay;

        System.out.print("월을 입력하세요 : ");
        month = sc.nextInt(); sc.nextLine();

        System.out.print("시작 요일을 입력하세요 : ");
        startWeekDay = sc.nextLine();

        System.out.print("마지막 일자를 입력하세요 : ");
        lastDate = sc.nextInt();

        int count = 0, date = 0, countWeek = 0, i, j = 0;

        if(lastDate > 31 || lastDate < 28) {
            System.out.println("일수를 잘못 입력하셨습니다.");
        } else if(lastDate == 31) {
            if(!startWeekDay.equals("목") && !startWeekDay.equals("금") && !startWeekDay.equals("토")) {
                countWeek = 6;
            } else {
                countWeek = 5;
            }
        } else if (lastDate == 30) {
            if(!startWeekDay.equals("금") && !startWeekDay.equals("토")) {
                countWeek = 6;
            } else {
                countWeek = 5;
            }
        } else {
            countWeek = 4;
        }

        switch(startWeekDay) {
            case "일":
                date = 1;
                break;
            case "월":
                date = 2;
                break;
            case "화":
                date = 3;
                break;
            case "수":
                date = 4;
                break;
            case "목":
                date = 5;
                break;
            case "금":
                date = 6;
                break;
            case "토":
                date = 7;
        }

        System.out.println("일\t월\t화\t수\t목\t금\t토");

        int status = 0;
        for(i = 1; i <= countWeek; i++) {
            for(j = 1; j <= 7; j++) {
                if(j >= date && status != 1) {
                    count++;
                    System.out.printf("%d\t", count);
                    status = 1;
                } else if(status != 0){
                    count++;
                    System.out.printf("%d\t", count);
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }



    }
}
