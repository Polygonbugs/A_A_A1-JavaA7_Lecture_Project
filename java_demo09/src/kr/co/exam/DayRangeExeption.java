package kr.co.exam;

public class DayRangeExeption extends RuntimeException {
    public DayRangeExeption() {
        super("날짜에 사용할 일자 범위가 잘못되었습니다");
    }

    public DayRangeExeption(String message) {
        super(message);
    }
}
