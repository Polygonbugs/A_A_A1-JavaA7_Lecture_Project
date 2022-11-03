package kr.co.exam05.prac;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Exam {
    public static void saveFile(HashMap<Student, ArrayList<Subject>> scoreBoard) {
        File f = new File("/Users/houstonjustin/Documents/A.Project/A_A_A1-Lecture-Project/test/학생성적정보관리.info");

        try(FileWriter fw = new FileWriter(f, true)) {
            for(Map.Entry<Student, ArrayList<Subject>> tmpScoreBoard : scoreBoard.entrySet()) {
                String stuProp = String.format("학생명 : %s, %d학년, %d반, 학생번호 : %d\n", tmpScoreBoard.getKey().getName(), tmpScoreBoard.getKey().getGrade(),
                        tmpScoreBoard.getKey().getClas(), tmpScoreBoard.getKey().getStudentNumber());

                fw.write(stuProp);

                for(Subject sub : tmpScoreBoard.getValue()){
                    String subProp = String.format("%s : %s, %d점, %c등급\n", tmpScoreBoard.getKey().getName(), sub.getSubName(), sub.getScore(), sub.getRank());
                    fw.write(subProp);
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        /*
         *  학생들의 성적을 관리하기 위한 프로그램을 컬렉션을 활용하여 만들어본다.
         *
         *  Student 클래스에는 학생의 정보를 담기 위한 클래스로 사용한다.
         *      멤버 필드 : 이름, 학년, 반, 번호
         *      멤버 메서드 : 반드시 hashCode(), equals() 구현할 것
         *                    기본 Getter/Setter toString() 구현할 것
         *
         *  Subject 클래스에는 과목 정보를 담기 위한 클래스로 사용한다.
         *      멤버 필드 : 과목명, 점수, 등급
         *      멤버 메서드 : Getter/Setter, toString() 구현할 것
         *
         *  HashMap을 기본으로 Key에는 Student 클래스를 사용하고 Value에는
         *  ArrayList를 사용하도록 한다. 그리고 ArrayList에 Subject 클래스를
         *  담아 사용하도록 한다.
         *
         *  성적 관리 프로그램으로 관리하는 모든 정보는 파일에 저장하여 다음번에 다시
         *  프로그램을 실행 했을 때 이전 상태가 저장되어 있어야 한다.
         *  파일명은 "학생성적관리정보.info"로 한다.
         */

        HashMap<Student, ArrayList<Subject>> scoreBoard = new HashMap<Student, ArrayList<Subject>>();
        Random rand = new Random();

        Student stu1 = new Student("가길동", 3, 2, 1);
        Student stu2 = new Student("나길동", 2, 1, 2);
        Student stu3 = new Student("다길동", 1, 4, 3);

        ArrayList<Subject> totalSub = new ArrayList<Subject>();
        totalSub.add(new Subject("국어", rand.nextInt(99) + 1));
        totalSub.add(new Subject("영어", rand.nextInt(99) + 1));
        totalSub.add(new Subject("수학", rand.nextInt(99) + 1));
        totalSub.add(new Subject("과학", rand.nextInt(99) + 1));
        totalSub.add(new Subject("사회", rand.nextInt(99) + 1));

        scoreBoard.put(stu1, totalSub);
        scoreBoard.put(stu2, totalSub);
        scoreBoard.put(stu3, totalSub);

        //System.out.println(scoreBoard);
        //System.out.println(scoreBoard.get(stu1));

        saveFile(scoreBoard);

    }
}
