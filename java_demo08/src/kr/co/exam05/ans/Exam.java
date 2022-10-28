package kr.co.exam05.ans;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Exam {
    public static void main(String[] args) {
        /*
         * 자신의 생년월일을 입력하면 현재로 부터 몇 일 남았는지 알려주는 D-DAY 정보를
         * 출력하세요.
         *     - GregorianCalendar 의 isLeapYear() 를 사용하면 윤년을 알 수 있습니다.
         *     - GregorianCalendar 의 getMaximum(Calendar.DAY_OF_MONTH) 을
         *       사용하면 해당 월의 최대 일자를 알 수 있습니다.
         */
        Scanner sc = new Scanner(System.in);

        System.out.print("8자리 혹은 6자리 생년월일을 입력하세요 : ");
        String birthDay = sc.nextLine();

        int birthYear = 0;
        int birthMonth = 0;
        int birthDate = 0;

        if(birthDay.length() == 8) {
            birthYear = Integer.parseInt(birthDay.substring(0, 4));
            birthMonth = Integer.parseInt(birthDay.substring(4, 6));
            birthDate = Integer.parseInt(birthDay.substring(6, 8));
        } else if(birthDay.length() == 6) {
            birthYear = Integer.parseInt(birthDay.substring(0, 2));
            birthYear = birthYear >= 30 ? birthYear + 1900 : birthYear + 2000;
            birthMonth = Integer.parseInt(birthDay.substring(2, 4));
            birthDate = Integer.parseInt(birthDay.substring(4, 6));
        }

        System.out.printf("당신이 태어난 날은 %d년 %d월 %d일 입니다.\n", birthYear, birthMonth, birthDate);

        GregorianCalendar cNow = new GregorianCalendar();
        GregorianCalendar cBirthDay = new GregorianCalendar(cNow.get(Calendar.YEAR), birthMonth - 1, birthDate);
        SimpleDateFormat df = new SimpleDateFormat("yyyy년 MM월 dd일");

        int nowMonth = cNow.get(Calendar.MONTH) + 1;
        int nowDate = cNow.get(Calendar.DATE);

        int nowMonthDate = (nowMonth * 100) + nowDate;
        int birthMonthDate = (birthMonth * 100) + birthDate;

        if(nowMonthDate > birthMonthDate) {
            cBirthDay.add(Calendar.YEAR, 1);
        }

        int nowYear = cNow.get(Calendar.YEAR);
        birthYear = cBirthDay.get(Calendar.YEAR);

        /*
         * 1. 년/월이 동일한 경우
         *     - 생일일자 - 현재일자 -> D-Day
         *
         * 2. 년/월이 동일하지 않은 경우
         *     - 현재 월의 남은 일수 = 해당 월의 최대일자 - 현재일자 -> A
         *     - 다음 월 부터 생일 전달 까지의 모든 일수 = 전달까지 개별월의 최대일자 누적 -> B
         *     - 생일달의 1 ~ 부터 생일까지의 일수 -> C
         *     - A + B + C -> D-DAY
         */
        int dDay = 0;
        if(nowYear == birthYear && nowMonth == birthMonth) {
            dDay += birthDate - nowDate;                    // 월에 따른 일수를 추가 : 생일년도와 현재년도가 같고, 생일달과 현재달도 같을때
        } else {
            dDay += cNow.getActualMaximum(Calendar.DAY_OF_MONTH) - nowDate;     // 월에 따른 일수를 추가 : 생일년도와 현재년도는 다르지만, 생일달과 현재달이 같을때
            cBirthDay.add(Calendar.MONTH, -1);
            while(!(cNow.get(Calendar.YEAR) <= cBirthDay.get(Calendar.YEAR)     // 월에 따른 일수를 추가 : 생일년도와 현재년도도 다르고, 생일달과 현재달도 다를때
                    && cNow.get(Calendar.MONTH) == cBirthDay.get(Calendar.MONTH))) {
                cNow.add(Calendar.MONTH, 1);                            // 월을 하나씩 더해주며 긱 달의 최대일수를 dDay에 더한다.
                dDay += cNow.getActualMaximum(Calendar.DAY_OF_MONTH);
            }
            dDay += birthDate; // 일수를 추가
            cBirthDay.add(Calendar.MONTH, 1);
        }

        cNow = new GregorianCalendar();

        System.out.printf("현재 날짜는 %s 입니다.\n", df.format(cNow.getTime()));
        System.out.printf("당신의 다음 생일 %s 입니다.\n", df.format(cBirthDay.getTime()));
        System.out.printf("D-DAY : %d 일\n", dDay);
    }
}
