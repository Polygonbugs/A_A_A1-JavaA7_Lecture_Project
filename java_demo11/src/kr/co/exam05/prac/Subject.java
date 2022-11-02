package kr.co.exam05.prac;

public class Subject {
    private String subName;
    private int score;
    private char rank;

    public Subject(String subName, int score) {
        this.subName = subName;
        this.score = score;
        getRank();
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public char getRank() {
        return rank;
    }

    public void setRank() {
        switch(score/10) {
            case 10:
            case 9:
                this.rank = 'A';
            case 8:
                this.rank = 'B';
            case 7:
                this.rank = 'C';
            case 6:
                this.rank = 'D';
            case 5:
                this.rank = 'E';
            default:
                this.rank = 'F';
        }
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subName='" + subName + '\'' +
                ", score=" + score +
                ", rank=" + rank +
                '}';
    }
}
