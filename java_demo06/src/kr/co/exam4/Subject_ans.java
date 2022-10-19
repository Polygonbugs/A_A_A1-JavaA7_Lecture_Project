package kr.co.exam4;

public class Subject_ans {
    private String name;
    private double score;
    private char grade;

    public Subject_ans(String name) {
        this.name = name;
    }

    public Subject_ans(String name, double score) {
        this.name = name;
        this.score = score;
        this.setGrade();
    }

    public String getName() {
        return this.name;
    }

    public void setScore(double score) {
        this.score = score;
        this.setGrade();
    }

    public double getScore() {
        return this.score;
    }

    private void setGrade() {
        switch((int)(this.score / 10)) {
            case 10:
            case 9:
                this.grade = 'A'; break;
            case 8:
                this.grade = 'B'; break;
            case 7:
                this.grade = 'C'; break;
            case 6:
                this.grade = 'D'; break;
            case 5:
                this.grade = 'E'; break;
            default:
                this.grade = 'F';
        }
    }

    public char getGrade() {
        return this.grade;
    }

    public boolean isExists(String name) {
        return this.name.equals(name);
    }
}
