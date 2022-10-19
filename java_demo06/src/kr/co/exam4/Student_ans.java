package kr.co.exam4;

import java.util.Arrays;

public class Student_ans {
    public Subject_ans subjects[] = {
            new Subject_ans("국어", 70),
            new Subject_ans("수학", 80)
    };
    public String name;
    public int year;

    public Student_ans(String name) {
        this.name = name;
    }

    public Student_ans(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public String getGradeTable() {
        String result = "";
        for(int i = 0; i < subjects.length; i++) {
            Subject_ans s = this.subjects[i];
            result += String.format("%s\t%.2f\n", s.getName(), s.getScore());
        }
        return result;
    }

    public boolean isDuplicate(String subjectName) {

        return this.findIndex(subjectName) == -1 ? false : true;
    }

    public int findIndex(String subjectName) {
        for(int i = 0; i < this.subjects.length; i++) {
            Subject_ans s = this.subjects[i];
            if(s.isExists(subjectName)) {
                return i;
            }
        }
        return -1;
    }
    public double getScore(String subjectName) {
        double result = -1.0;

        int idx = this.findIndex(subjectName);

        if(idx >= 0) {
            result = this.subjects[idx].getScore();
        }

        return result;
    }

    public void addSubject(String subjectName, double score) {
        if(!this.isDuplicate(subjectName)) {
            int len = this.subjects.length;
            this.subjects = Arrays.copyOf(this.subjects, len + 1);
            this.subjects[len] = new Subject_ans(subjectName, score);           // len은 그대로 남아 있으므로 그대로 두면 된다.
        }
    }

    public void updateSubject(String subjectName, double score) {

    }

    public void removeSubject(String subjectName) {

    }

}
