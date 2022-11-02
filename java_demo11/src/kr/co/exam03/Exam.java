package kr.co.exam03;

import java.util.*;

public class Exam {
    public static void main(String[] args) {
        /*
         *  과목 정보를 담기 위한 HashMap을 사용해 보세요.
         *  다음의 과목명과 과목 점수가 HashMap에 저장될 수 있게 하세요.
         *
         *      과목명 : 국어, 영어, 수학, 사회, 과학, 체육, 미술
         *
         *  실수형의 임의의 점수로 저장하여 HashMap에 저장된 과목의
         *  총합과 평균을 구하여 출력하세요.
         */

        HashMap<String, Double> subjectMap = new HashMap<String, Double>();

        subjectMap.put("국어", Double.valueOf(76.4));
        subjectMap.put("영어", Double.valueOf(87.1));
        subjectMap.put("수학", Double.valueOf(75.2));
        subjectMap.put("사회", Double.valueOf(93.5));
        subjectMap.put("과학", Double.valueOf(83.6));
        subjectMap.put("체육", Double.valueOf(89.0));
        subjectMap.put("미술", Double.valueOf(78.9));

        double sum = 0;
        for(Double score: subjectMap.values()) {
            sum += score;
        }

        double avg = sum / subjectMap.size();

        System.out.println("총점 : " + sum);
        System.out.println("총점 : " + avg);

    }
}
