package kr.co.exam4;

public class Score {
    private String subject;
    private int score;
    private char rank;

    public Score(String subject) {
        this(subject, 0);
    }

    public Score(String subject, int score) {
        this.subject = subject;
        this.setScore(score);
    }

    public void setScore(int score) {
        if(score < 0 || score > 100) {
            System.out.println("값을 다시 입력하세요");
            return;
        }
        this.score = score;
    }

    public char getRank(){
        if(this.score >= 90) {
            this.rank = 'A';
        } else if(this.score >= 80) {
            this.rank = 'B';
        } else if(this.score >= 70) {
            this.rank = 'C';
        } else if(this.score >= 60) {
            this.rank = 'D';
        } else {
            this.rank = 'F';
        }
        return this.rank;
    }

    public String getSubject() {
        return this.subject;
    }

    public int getScore() {
        return this.score;
    }

}
