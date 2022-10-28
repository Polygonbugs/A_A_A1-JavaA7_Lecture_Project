package kr.co.exam04.prac;


import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.spi.CalendarDataProvider;

public class Exam {
    public static void main(String[] args) {
        /*
         *  현재 날짜를 구하고 다음 형식에 맞추어 출력하세요
         *      1. 2022/01/01
         *      2. 2022년 01월 01일
         *      3. 12시 15분 45초
         *      4. 12:15:45
         *
         *  2022년 10월 중 주말에 해당하는 날짜만 문자열 배열에 담아 출력하세요.
         *

         *
         */

        Date date = new Date();

        int year1 = Integer.parseInt(String.format("%tY", date));
        int month1 = Integer.parseInt(String.format("%tm", date));
        int date1 = Integer.parseInt(String.format("%td", date));
        int hour1 = Integer.parseInt(String.format("%tH", date));
        int minute1 = Integer.parseInt(String.format("%tM", date));
        int second1 = Integer.parseInt(String.format("%tS", date));

        System.out.println(year1 + "/" + month1 + "/" + date1);
        System.out.println(year1 + "년 " + month1 + "월 " + date1 + "일");
        System.out.println(hour1 + "시 " + minute1 + "분 " + second1 +"초");
        System.out.println(hour1 + ":" + minute1 + ":" + second1);

        String[] dates;


        /*
         * 자신의 생년월일을 입력하면 현재로부터 몇 일 남았는지 알려주는 D-DAY 정보를 출력하세요.
         * - GregorianCalendar의 isLeapYear()를 사용하면 윤년을 알 수 있습니다.
         * - GregorianCalendar의 getActualMaximum(Calendar.DAY_OF_MONTH)을 사용하면
         * 해당 월의 최대 일자를 알 수 있습니다.
         */
        Scanner sc = new Scanner(System.in);

        GregorianCalendar gc1 = new GregorianCalendar(2023, 1, 2);
        GregorianCalendar gc2 = new GregorianCalendar();
        int byear = gc1.get(Calendar.YEAR);
        int bmonth = gc1.get(Calendar.MONTH);
        int bdate = gc1.get(Calendar.DATE);

        int cyear = gc2.get(Calendar.YEAR);
        int cmonth = gc2.get(Calendar.MONTH) + 1;
        int cdate = gc2.get(Calendar.DATE);


        int bTotalDate = 0;
        int cTotalDate = 0;

        if(gc1.isLeapYear(byear)) {
            bTotalDate += byear * 366;
        } else {
            bTotalDate += byear * 365;
        }

        if(gc2.isLeapYear(byear)) {
            cTotalDate += cyear * 366;
        } else {
            cTotalDate += cyear * 365;
        }

        GregorianCalendar tmpgc = new GregorianCalendar();

        for(int i = 0; i < bmonth; i++) {
            tmpgc.set(Calendar.MONTH, i);
            bTotalDate += tmpgc.getActualMaximum(Calendar.DAY_OF_MONTH);
        }

        for(int i = 0; i < cmonth; i++) {
            tmpgc.set(Calendar.MONTH, i);
            cTotalDate += tmpgc.getActualMaximum(Calendar.DAY_OF_MONTH);
        }

        bTotalDate += bdate;
        cTotalDate += cdate;

        System.out.printf("D-day까지 %d일 남음", bTotalDate - cTotalDate + 1);



    }
}
