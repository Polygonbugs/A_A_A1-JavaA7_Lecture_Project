package kr.co.exam05.prac;

public class Subject {
    private String subName;
    private int score;
    private char rank;

    public Subject(String subName, int score) {
        this.subName = subName;
        this.score = score;
        setRank();
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
                break;
            case 8:
                this.rank = 'B';
                break;
            case 7:
                this.rank = 'C';
                break;
            case 6:
                this.rank = 'D';
                break;
            case 5:
                this.rank = 'E';
                break;
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
