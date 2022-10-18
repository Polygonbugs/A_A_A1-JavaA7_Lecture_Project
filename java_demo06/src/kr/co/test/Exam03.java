package kr.co.test;

public class Exam03 {
    public static void main(String[] args) {
        Subject sub1 = new Subject("영어", 32);

        sub1.registerScore(95);
        sub1.showTitle();
        sub1.showScore();
        sub1.showRank();
    }
}
