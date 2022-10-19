package kr.co.exam4;

public class Exam {
    public static void main(String[ ] args) {
        /*
         *      학생들의 성적을 관리하기 위한 용도의 클래스 생성
         *          학생 클래스
         *              멤버변수 : 성적배열, 이름, 학년
         *              멤버메서드 : 성적표출력, 과목점수출력, 과목점수수정, 성적추가/삭제
         *
         *          성적 클래스
         *              멤버변수 : 과목명, 점수, 등급
         *              멤버메서드 : 점수로 등급을 산출하는 메서드
         */


        Student s1 = new Student("꿀꿀이");

        s1.addSubjectScore("영어", 97);
        s1.addSubjectScore("수학", 57);
        s1.addSubjectScore("국어", 100);
        System.out.println(s1.showSubjectScore("수학"));
        System.out.println(s1.showScoreBoard());

        s1.updateSubjectScore("영어", 50);
        System.out.println(s1.showScoreBoard());

        s1.deleteSubjectScore("영어");
        System.out.println(s1.showScoreBoard());
        //System.out.println(s1.showScoreBoard());

        System.out.println("-----------------------");
        System.out.println("-----------------------");

        Subject_ans s = new Subject_ans("국어");

        s.setScore(65.8);

        System.out.println(s.getName());
        System.out.println(s.getScore());
        System.out.println(s.getGrade());



    }
}
