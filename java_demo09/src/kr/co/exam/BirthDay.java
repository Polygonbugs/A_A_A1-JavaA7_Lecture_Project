package kr.co.exam;

import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class BirthDay {
    public static final String FOUR_YEAR_FORMAT ="yyyyMMdd";
    public static final String TWO_YEAR_FORMAT = "yyMMdd";

    private Date date;
    private int year;
    private int month;
    private int day;
    private SimpleDateFormat dateFormat;
    /**
     * 6자리(yymmdd) 또는 8자리(yyyymmdd) 날짜 형식을 받아서 BirthDay
     * 객체를 생성하기 위한 생성자.
     *
     * @param dateFormat 날짜형식을 가지는 문자열
     */

    public BirthDay(String dateFormat) {
        switch(dateFormat.length()) {
            case 6:
                this.setDateFormat(BirthDay.TWO_YEAR_FORMAT);
                break;
            case 8:
                this.setDateFormat(BirthDay.FOUR_YEAR_FORMAT);
                break;
        }
        try {
            this.date = this.dateFormat.parse(dateFormat);
            this.dateSplit();
        } catch (ParseException e) {
            this.date = new Date();
            this.dateSplit();
            e.printStackTrace();
        }
    }

    /**
     * 정수값에 해당하는 년, 월, 일을 입력받아 BirthDay 객체를 생성하기 위한 생성자.
     * @param year   태어난 년도
     * @param month  태어난 달
     * @param day    태어난 일자
     */
    public BirthDay(int year, int month, int day) {
        if(!(month >= 1 && month <= 12)) {
            throw new MonthRangeException(month + "월은 잘못된 월입니다.");
        }

        if(!(day >= 1 && day <= 31)) {
            throw new DayRangeExeption(day + "일은 잘못된 일자입니다.");
        }

        this.date = (new GregorianCalendar(year, month - 1, day)).getTime();
        this.year = year;
        this.month = month;
        this.day = day;
    }

    /**
     * java.util.Date 클래스를 입력 받아 BirthDay 객체를 생성하기 위한 생성자.
     * @param date  java.util.Date 클래스
     */
    public BirthDay(Date date) {
        this.date = date;
        this.dateSplit();
    }

    /**
     * 밀리초에 해당하는 정수값을 받아 BirthDay 객체를 생성하기 위한 생성자. </br>
     * 1970년 01월 01일 00시 00분 00초 000밀리초를 기준으로 생성한다.
     * @param milliSecond Long 타입의 밀리초 값
     */
    public BirthDay(long milliSecond) {
        this.date = new Date(milliSecond);
    }

    /**
     * 지정한 날짜 형식으로 변환할 수 있도록 SimpleDateFormat 객체를 생성하여
     * 활용하기 위해 사용.
     * @param format BirthDay 클래스 상수에 정의된 포멧 문자열만 사용해야함.
     */
    private void setDateFormat(String format) {
        this.dateFormat = new SimpleDateFormat(format);
    }

    /**
     * Date 객체로 생성한 날짜를 year, month, day로 분리하여 멤버변수로
     * 저장 후 차후 다른 계산에 사용하기 위해 만듬
     */
    private void dateSplit() {
        this.year = Integer.parseInt(String.format("%tY", this.date));
        this.month = Integer.parseInt(String.format("%tm", this.date));
        this.day = Integer.parseInt(String.format("%td", this.date));
    }

    /**
     * 현재 날짜를 기준으로 다음 생일이 언제인지 반환한다. </br>
     * 이미 생일이 지난 경우 다음년도에 대한 BirthDay 객체를 반환하고 </br>
     * 아직 생일이 지나지 않은 경우 올해에 대한 BirthDay 객체를 반환한다.
     * @return BirthDay : 다음 생일에 대한 정보를 담아 반환한다.
     */
    public BirthDay nextBirthDay() {
        GregorianCalendar n = new GregorianCalendar();

        int year = n.get(Calendar.YEAR);
        int month = Integer.parseInt(String.format("%tm", this.date));
        int day = Integer.parseInt(String.format("%td", this.date));

        GregorianCalendar b = new GregorianCalendar(year, month - 1, day);

        if(n.before(b)) {
            return new BirthDay(year, month, day);
        } else {
            return new BirthDay(year + 1, month, day);
        }

    }

    /**
     * 현재 날짜 정보를 java.util.Date 객체로 반환한다.
     * @return Date : 현재 시스템 날짜
     */
    public Date currentDate() {
        return new Date();
    }

    /**
     *  현재 날짜 정보를 문자열로 반환한다. 기본 포맷을 yyyy년 mm월 dd일이다.
     * @return String : 날짜 형식의 문자열
     */
    public String currentDateToString() {
        return String.format("%1$tY년 %1$tm월 %1$td일", new Date());
    }

    /**
     *  만 나이를 구하여 반환한다.
     * @return int : 만 나이
     */
    public int getAge() {
        Date now = new Date();
        int nowYear = Integer.parseInt(String.format("%tY", now));
        int nowMonth = Integer.parseInt(String.format("%tm", now));
        int nowDay = Integer.parseInt(String.format("%td", now));

        int age = nowYear - this.year;
        if(nowMonth <= this.month ) {
            if(nowMonth == this.month && nowDay < this.day) {
                age -= 1;
            }
        }
        return age;
    }

    /**
     * zeroStart가 true이면, 만 나이를 구하여 반환하고</br>
     * zeroStart가 false이면, 태어난 날이 1살로부터 시작하는 나이를
     * 구하여 반환한다.
     * @return int : zeroStart 값에 따라 만 나이 혹은 1살부터 시작한 나이
     */
    public int getAge(boolean zeroStart) {
        int age = this.getAge();

        if(zeroStart) {
            return age;
        } else {
            return age + 1;
        }
    }

    @Override
    public String toString() {
        return String.format("%1$tY년 %1$tm월 %1$td일", this.date);        // %1$ "," 뒤에 매개변수의 순서를 맞춘다.
    }
}
