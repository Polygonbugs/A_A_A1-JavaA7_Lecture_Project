package kr.co.demo05;

import java.util.*;

public class Demo {
    public static void main(String[] args) {
        /*
         *      HashMap에 ArrayList를 담아서 사용하기
         *
         *      ArrayList에는 Subject 클래스가 담기게 한다.
         */

        HashMap<String, ArrayList<Subject>> datas = new HashMap<String, ArrayList<Subject>>();

        /*
         * {
         * "홍길동" : [Subject, Subject, Subject, ...],
         * "김철수" : [Subject, Subject, Subject, ...],
         * "박원정" : [Subject, Subject, Subject, ...]
         * }
         * 평균 점수가 가장 높은 학생을 구하시오.
         */


        Set<String> names = new HashSet<String>();
        names.add("홍길동");
        names.add("김철수");
        names.add("박원정");

        Set<String> subjects = new HashSet<String>();
        subjects.add("국어"); subjects.add("영어");
        subjects.add("수학"); subjects.add("사회");
        subjects.add("과학"); subjects.add("체육");
        subjects.add("미술");

        Random rand = new Random();
        for(String name: names) {
            datas.put(name, new ArrayList<Subject>());
            List<Subject> data = datas.get(name);
            for(String subject : subjects) {
                double score =  rand.nextInt(40) * rand.nextDouble() + 60;
                data.add(new Subject(subject, score));
            }
        }

        System.out.println("홍길동=" + datas.get("홍길동"));
        System.out.println("김철수=" + datas.get("김철수"));
        System.out.println("박원정=" + datas.get("박원정"));

        ArrayList<Subject> avgData = new ArrayList<Subject>();
        for(Map.Entry<String, ArrayList<Subject>> e : datas.entrySet()) {
            double sum = 0;
            double avg = 0;
            for(Subject s : e.getValue()) {
                sum += s.getScore();
            }
            avg = sum / e.getValue().size();
            avgData.add(new Subject(e.getKey(), avg));
        }

        Collections.sort(avgData);
        Collections.reverse(avgData);
        System.out.println(avgData);

    }
}
