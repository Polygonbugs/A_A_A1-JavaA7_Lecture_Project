package kr.co.exam;

public class MonthRangeException extends RuntimeException {
    public MonthRangeException() {
        super("날짜에 사용한 월 범위가 잘못되었습니다.");
    }

    public MonthRangeException(String message) {
        super(message);
    }

}
