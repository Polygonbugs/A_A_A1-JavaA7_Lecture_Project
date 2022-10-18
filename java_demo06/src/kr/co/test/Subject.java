package kr.co.test;

public class Subject {
    /*
     * 과목명은 한 번 정해지면 변경할 수 없어야 한다.
     * 점수는 언제든 변경할 수 있으나 0 ~100 사이의 값만 저장해야 한다.
     * 등급은 점수에 의해 결정되며, A ~ F 등급까지 부여한다.(등급을 별도로 설정하는 것은 안된다.)
     * 과목 객체의 멤버 변수에 저장된 값을 확인할 수 있게 해야 한다.
     */

    private final String title;
    private int score;
    private char rank;

    public Subject(String title, int score) {
        this.title = title;
        this.registerScore(score);
    }

    public void registerScore(int score) {
            if(score >= 0 && score <= 100) {
                this.score = score;
            } else {
                System.out.println("0 ~ 100사이의 점수로 입력해주세요");
                System.out.println("일단 0으로 입력합니다");
                this.score = 0;
            }

        if(score <= 100 && score >= 90) { this.rank = 'A';}
        else if (score >= 80) {this.rank = 'B';}
        else if (score >= 70) {this.rank = 'C';}
        else if (score >= 60) {this.rank = 'D';}
        else if (score >= 50) {this.rank = 'E';}
        else {this.rank = 'F';}

    }

    public void showTitle() {
        System.out.printf("과목명 : %s\n", this.title);
    }

    public void showScore() {
        System.out.printf("점수 : %d\n", this.score);
    }

    public void showRank() {
        System.out.printf("등급 : %c\n", this.rank);
    }

}
