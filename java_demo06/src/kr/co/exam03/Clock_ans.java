package kr.co.exam03;

public class Clock_ans {
    // 멤버 변수/상수
    private int hour;
    private int minute;
    private int second;

    // 생성자
    public Clock_ans(int hour, int minute, int second) {
        this.setHour(hour);
        this.setMinute(minute);
        this.setSecond(second);
    }

    // 멤버 메서드
    public String getTimeString() {     // return은 void일때만 생략가능하다
        return this.hour + ":" + this.minute + ":" + this.second;                      // method는 return을 만나면 함수가 종료된다.
    }                                   // return 되는 값은 반드시 1개여야 한다.

    // getter 메서드
    public int getHour() {
        return this.hour;
    }

    public int getMinute() {
        return this.minute;
    }

    public int getSecond() {
        return this.second;
    }

    private void setHour(int hour) {
        this.hour = hour % 24;
    }

    private void setMinute(int minute) {
        this.minute = minute % 60;
    }

    private void setSecond(int second) {
        this.second = second % 60;
    }
}
