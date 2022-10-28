package kr.co.exam04.ans;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Exam {
    public static void main(String[] args) {
        /*
         *  현재 날짜를 구하고 다음 형식에 맞추어 출력하세요
         *      1. 2022/01/01
         *      2. 2022년 01월 01일
         *      3. 12시 15분 45초
         *      4. 12:15:45
         */

        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");

        String strDate = df.format(date);
        System.out.println(strDate);

        df.applyPattern("yyyy년 MM월 dd일");
        strDate = df.format(date);
        System.out.println(strDate);

        df.applyPattern("HH시 mm분 ss초");
        strDate = df.format(date);
        System.out.println(strDate);

        df.applyPattern("HH:mm:ss");
        strDate = df.format(date);
        System.out.println(strDate);

        /*
         * 2022년 10월 중 주말에 해당하는 날짜만 문자열 배열에 담아 출력하세요.
         */


        df = new SimpleDateFormat("yyyy/MM/dd EEEE");
        GregorianCalendar gc = new GregorianCalendar(2022, 9, 1);

        Date[] weekend = new Date[0];
        for(int i = 0; i < gc.getMaximum(Calendar.DAY_OF_MONTH); i++) {
            switch(gc.get(Calendar.DAY_OF_WEEK)) {
                case Calendar.SATURDAY:
                case Calendar.SUNDAY:
                    weekend = Arrays.copyOf(weekend, weekend.length + 1);
                    weekend[weekend.length - 1] = gc.getTime();
            }

            gc.add(Calendar.DATE, 1);
        }

        for(int i = 0; i < weekend.length; i++) {
            System.out.println(df.format(weekend[i]));
        }


    }
}
