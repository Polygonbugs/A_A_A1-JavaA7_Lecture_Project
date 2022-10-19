package kr.co.exam4;

import kr.co.demo04.Food;

import java.util.Arrays;

public class Student {
    private Score[] studentScores = new Score[0];
    private String name;
    private int grade;

    public Student(String name) {
        this.name = name;
    }

    public void addSubjectScore(String inputSubject, int inputScore) {
        this.studentScores = Arrays.copyOf(this.studentScores, this.studentScores.length + 1);
        this.studentScores[this.studentScores.length - 1] = new Score(inputSubject, inputScore);
    }

    public int findSubject(String Subject) {
        int idx = -1;

        for(int i = 0; i < this.studentScores.length; i++) {
            if(this.studentScores[i].getSubject().equals(Subject)) {
                idx = i;
            }
        }

        return idx;
    }
    public String showSubjectScore(String inputSubject) {
        String res = "";
        int index = findSubject(inputSubject);

        for(int i = 0; i < this.studentScores.length; i++) {
            if(this.studentScores[i].getSubject().equals(inputSubject)) {
                res += String.format("%s학생 %s과목 등급 : %c\n", this.name ,this.studentScores[i].getSubject(), studentScores[i].getRank());
            }
        }

        return res;
    }
    public String showScoreBoard() {
        String res = "";

        for(int i = 0; i < this.studentScores.length; i++) {
            res += String.format("%s학생 %s과목 등급 : %c\n", this.name ,this.studentScores[i].getSubject(), studentScores[i].getRank());
        }

        return res;
    }



    public boolean updateSubjectScore(String inputSubject, int inputScore) {
        int idx = this.findSubject(inputSubject);

        if (idx != -1) {
            this.studentScores[idx].setScore(inputScore);
            return true;
        }
        return false;
    }


    public boolean deleteSubjectScore(String subjectName) {
        int idx = this.findSubject(subjectName);
        if(idx != -1) {
            Score[] tmpScore = new Score[this.studentScores.length - 1];
            for(int i = 0, j = 0; i < this.studentScores.length; i++) {
                if(idx != i) {
                    tmpScore[j] = this.studentScores[i];
                    j++;
                }
            }
            this.studentScores = tmpScore;
            return true;
        }

        return false;
    }
}
