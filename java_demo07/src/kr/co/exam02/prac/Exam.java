package kr.co.exam02.prac;

public class Exam {
    public static void main(String[] args) {
        /*
         *      상속과 메서드 오버라이드 기능을 활용하여 학생과 선생님간의 관계에서
         *      부모 클래스와 자식 클래스를 나누어 보고 공통 메서드 및 필드는 부모에
         *      정의하여 작성하고 개별 메서드 및 필드는 자식에 정의하여 작성하도록 한다.
         *
         *      학생과 선생님은 개학을 하면 학년과 반을 배정받는 것은 동일하지만
         *      선생님의 경우 과목을 추가로 배정받아야 한다.
         *      그리고 학생의 경우 성적관리를 위한 과목배열 필드와 과목정보를 추가/수정/삭제/조회
         *      하기 위한 추가 메서드가 필요하다.
         *
         *      여기에서 작성하는 클래스는 3개만 있으면 된다.
         *      과목배열의 경우 과목 클래스가 필요하지 않다. 대신, String 배열로 작성한다.
         *      추가/수정/삭제/조회 구현은 필요 없다. 메서드만 있으면 된다.
         *
         */
        /*
         *      학생 필드 : subject[]
         *      학생 메서드 : 수정, 삭제, 조회
         *
         *      교사 필드 : subject
         *      교사 메서드 :
         *
         *      사람 필드 : 학년, 반
         *      사람 메서드 : 과목추가
         */

        Student s1 = new Student();
        Teacher t1 = new Teacher();

        s1.setGrade(3);
        s1.setClassroom(4);

        s1.setGrade(3);
        t1.setClassroom(4);

        t1.addSubject("영어");
        s1.addSubject("영어");

    }
}
