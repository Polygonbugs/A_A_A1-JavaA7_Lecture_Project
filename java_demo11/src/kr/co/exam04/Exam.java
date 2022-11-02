package kr.co.exam04;


import java.util.HashMap;
import java.util.Map;

public class Exam {
    public static void main(String[] args) {
        /*
         *      Map 컬렉션에 사용할 값을 사용자 정의 객체로 지정하여 사용해 본다.
         *
         *      Subject 클래스에 등급(A ~ F), 점수 멤버 필드를 만들어서 사용한다.
         *
         *      Map 컬렉션에 사용할 키에는 과목명 문자열을 사용하도록 한다.
         *
         *          과목명 : 국어, 영어, 수학, 사회, 과학, 체육, 미술
         *
         *  모든 과목의 이름과 등급이 출력될 수 있게 하세요.
         *  추가로 총합과 평균을 구하여 출력하세요.
         */

        HashMap<String, Subject> subjectMap = new HashMap<String, Subject>();

        subjectMap.put("국어", new Subject(76.4, 'C'));
        subjectMap.put("영어", new Subject(87.1, 'B'));
        subjectMap.put("수학", new Subject(75.2, 'C'));
        subjectMap.put("사회", new Subject(93.5, 'A'));
        subjectMap.put("과학", new Subject(83.6, 'B'));
        subjectMap.put("체육", new Subject(89.0, 'B'));
        subjectMap.put("미술", new Subject(78.9, 'C'));

        double sum = 0;
        double avg = 0;
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, Subject> e : subjectMap.entrySet()) {
            sb.append(e.getKey() + ":");
            sb.append(e.getValue().getGrade() + "\t");
            sum += e.getValue().getScore();
        }
        avg = sum / subjectMap.size();
        sb.append("총합 : " + sum + "\n");
        sb.append("평균 : " + avg + "\n");

        System.out.println(sb.toString());

    }
}
