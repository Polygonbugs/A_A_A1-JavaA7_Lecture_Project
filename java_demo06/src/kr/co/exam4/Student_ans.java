package kr.co.exam4;

import java.util.Arrays;

public class Student_ans {
    public Subject_ans subjects[];
    public String name;
    public int year;

    public Student_ans(String name) {
        this.subjects = new Subject_ans[0];
        this.name = name;
        System.out.println(this.toString());
    }

    public Student_ans(String name, int year) {
        this(name);
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

    // 굳이 외부에서 사용할 필요가 없는 경우 접근제한자를 private으로 바꿔주자
    private boolean isDuplicate(String subjectName) {

        return this.findIndex(subjectName) == -1 ? false : true;
    }

    private int findIndex(String subjectName) {
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

    // 메소드 오버로딩(Overloading) : 동일한 이름의 메서드를 여러개 작성하는 것이다.
    //
    //      매개변수 타입 / 매개변수 수량이 이미 작성된 메서드와 달라야 한다.
    //      (단, 순서를 본다. 타입이 다른 경우에만 다른 메소드로 판단한다)
    //
    //      오버로딩된 메서드를 사용하는 사용자 입장에서는 해당 메서드를 사용할 때
    //      타입에 대한 부분을 신경쓰지 않아도 되며, 다양한 타입을 사용해서 동일한
    //      결과를 얻을 수도 있다.
    public void addSubject(String subjectName) {
        this.addSubject(subjectName, 0);
    }

    public void addSubject(String subjectName, byte score) {
        this.addSubject(subjectName, score);
    }

    public void addSubject(String subjectName, short score) {
        this.addSubject(subjectName, score);
    }

    public void addSubject(String subjectName, int score) {
        this.addSubject(subjectName, (double)score);
    }

    public void addSubject(String subjectName, double score) {
        if(!this.isDuplicate(subjectName)) {
            int len = this.subjects.length;
            this.subjects = Arrays.copyOf(this.subjects, len + 1);
            this.subjects[len] = new Subject_ans(subjectName, score);           // len은 그대로 남아 있으므로 그대로 두면 된다.
        }
    }

    public void addSubject(double score, String subjectName) {
        if(!this.isDuplicate(subjectName)) {
            int len = this.subjects.length;
            this.subjects = Arrays.copyOf(this.subjects, len + 1);
            this.subjects[len] = new Subject_ans(subjectName, score);           // len은 그대로 남아 있으므로 그대로 두면 된다.
        }
    }

    public void updateSubject(String subjectName, double score) {
        int idx = this.findIndex(subjectName);

        if(idx >= 0) {
            Subject_ans s = this.subjects[idx];
            s.setScore(score);
        }
    }

    public void removeSubject(String subjectName) {
        int idx = this.findIndex(subjectName);

        if (idx >= 0) {
            for (int i = idx; i < this.subjects.length - 1; i++) {
                this.subjects[i] = this.subjects[i + 1];
            }
        }

        this.subjects = Arrays.copyOf(this.subjects, this.subjects.length - 1);
    }
}
