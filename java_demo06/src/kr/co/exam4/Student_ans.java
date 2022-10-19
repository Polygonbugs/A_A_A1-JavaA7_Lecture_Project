package kr.co.exam4;

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

    public double getScore(String subjectName) {
        double result = -1.0;

        for(int i = 0; i < this.subjects.length; i++) {
            Subject_ans s = this.subjects[i];
            if(s.getName().equals(subjectName)) {
                result = s.getScore();
                return result;
            }
        }

        return result;
    }

    public void updateSubject(String subjectName, double score) {

    }

    public void addSubject(String subjectName, double score) {

    }

    public void removeSubject(String subjectName) {

    }

}
