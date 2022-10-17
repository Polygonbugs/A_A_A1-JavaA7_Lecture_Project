package kr.co.exam03;

import java.util.Scanner;

public class Clock {
    private int hour;
    private int minute;
    private int second;


    private final int second_to_hour= 3600;
    private final int second_to_minute = 60;


    public Clock() {
        Scanner sc = new Scanner(System.in);
        System.out.print("시간을 입력하세요 : ");
        this.hour = sc.nextInt();

        System.out.print("분을 입력하세요 : ");
        this.minute = sc.nextInt();

        System.out.print("초를 입력하세요 : ");
        this.second = sc.nextInt();
    }

    public Clock(int time) {
        this.hour = time / second_to_hour;
        this.minute = (time % second_to_hour) / second_to_minute;
        this.second = (time % second_to_hour) % second_to_minute;
    }

    public String getTimeString() {
        return this.hour + ":" + this.minute + ":" + this.second;
    }
}
