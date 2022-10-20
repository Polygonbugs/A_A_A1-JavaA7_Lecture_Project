package kr.co.exam4;

import java.util.Arrays;

public class Exam {
    public static void main(String[ ] args) {
        /*
         *      학생들의 성적을 관리하기 위한 용도의 클래스 생성
         *          학생 클래스(Student_ans, Student)
         *              멤버변수 : 성적배열, 이름, 학년
         *              멤버메서드 : 성적표출력, 과목점수출력, 과목점수수정, 성적추가/삭제
         *
         *          성적 클래스(Subject_ans, Score)
         *              멤버변수 : 과목명, 점수, 등급
         *              멤버메서드 : 점수로 등급을 산출하는 메서드
         */


        /*Student s1 = new Student("꿀꿀이");

        s1.addSubjectScore("영어", 97);
        s1.addSubjectScore("수학", 57);
        s1.addSubjectScore("국어", 100);
        System.out.println(s1.showSubjectScore("수학"));
        System.out.println(s1.showScoreBoard());

        s1.updateSubjectScore("영어", 50);
        System.out.println(s1.showScoreBoard());
        s1.updateSubjectScore("수학", 99);
        System.out.println(s1.showScoreBoard());

        s1.deleteSubjectScore("영어");
        System.out.println(s1.showScoreBoard());*/


        System.out.println("-----------------------");
        System.out.println("-----------------------");

        System.out.println("인스턴스 객체 정보1");
        Student_ans s = new Student_ans("홍길동");
        System.out.println(s);

        System.out.println("인스턴스 객체 정보2");
        Student_ans s2 = new Student_ans("홍길동");
        System.out.println(s2.toString());

        String table = s.getGradeTable();
        System.out.println(table);

        double score = s.getScore("국어");
        System.out.println(score);

        s.addSubject("과학", 76.5);
        s.addSubject("국어", 76.5);
        s.addSubject("수학", 76.5);
        table = s.getGradeTable();
        System.out.println(table);

        s.updateSubject("과학", 95);
        table = s.getGradeTable();
        System.out.println(table);

        s.removeSubject("수학");
        table = s.getGradeTable();
        System.out.println(table);

        Subject_ans sub = s.getSubject("과학");
        System.out.print(sub.getName() + "\t");
        System.out.print(sub.getName() + "\t");
        System.out.print(sub.getName() + "\n");

        //String finds[] = ;
        Subject_ans sArr[] = s.getSubjects("영어", "국어", "수학", "과학");
        System.out.println(Arrays.toString(sArr));

        s.updateSubject(sub, 50);
        table = s.getGradeTable();
        System.out.println(table);

        s.removeSubject(sub);
        table = s.getGradeTable();
        System.out.println(table);
    }
}
