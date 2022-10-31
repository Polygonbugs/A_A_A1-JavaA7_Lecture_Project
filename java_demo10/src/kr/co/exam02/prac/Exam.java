package kr.co.exam02.prac;

import java.io.*;
import java.util.Arrays;

public class Exam {
    public static String load(String filepath) {
        File f = new File(filepath);
        StringBuilder sb = new StringBuilder(512);
        Subjects[] subjects;

        try(FileReader fr = new FileReader(f)) {
            char[] buffer = new char[8];

            while(true) {
                int readChars = fr.read(buffer);
                if(readChars == -1) {
                    break;
                }
                sb.append(buffer, 0, readChars);
            }

            String strDatas[] = sb.toString().split("\\n");
            subjects = new Subjects[strDatas.length];

            for(int i = 0; i < strDatas.length; i++) {
                String strSubject[] = strDatas[i].split(" ");
                Subjects s = new Subjects();
                s.setName(strSubject[0]);
                s.setScore(Double.parseDouble(strSubject[1]));
                s.setGrade(strSubject[2].charAt(0));
                subjects[i] = s;
            }

        return null;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    public static void save() {

    }

    public static void main(String[] args) {
        /*
         *      파일에 저장된 성적 데이터를 읽고 프로그램에서
         *      사용할 수 있는 Subject 객체로 변환한다.
         *      변환된 Subject를 활용하여 데이터 추가 및 수정, 삭제
         *      를 진행 후 다시 동일한 파일에 저장할 수 있게 한다.
         *      파일명은 "학생명.subjects"로 하며, 파일에 작성된 데이터는
         *      다음의 구조를 가진다.
         *
         *      학생명.subjects
         *          과목명1 점수1 등급1
         *          과목명2 점수2 등급2
         *          과목명3 점수3 등급3
         *          ...
         *          ...
         *
         *      load 메서드를 만들어서 홍길동.subjects
         *      파일을 읽고 문자열로 반환하는 기능을 구현하세요.
         *      (exam 클래스 안에 정적메소드로)
         *
         *      parseSubject 정적 메서드를 만들어서 "과목명 점수 등급"
         *      문자열이 Subject 인스턴스로 만들어져 반환될 수 있도록 하세요.
         *
         *      Subject 클래스의 메서드로 toString(String delimiter) 메서드를
         *      오버로딩 하여 delimiter를 구분자로 하는 문자열이 반환될 수 있도록 하세요
         *
         *      save 메서드를 만들어 Subject 객체들이 "홍길동.subjects" 파일로
         *      작성될 수 있도록 하세요. (exam 클래스 안에 정적메소드로)
         */

        load("/Users/houstonjustin/Documents/A.Project/A_A_A1-Lecture-Project/test/홍길동.subjects");


        try(FileReader fr = new FileReader(f)) {
            char[] buffer = new char[8];
            while(true) {
                int readChars = fr.read(buffer);
                if(readChars == -1) {
                    break;
                }
                sb.append(buffer, 0, readChars);
            }

            String strDatas[] = sb.toString().split("\\n");
            subjects = new Subjects[strDatas.length];

            for(int i = 0; i < strDatas.length; i++) {
                String strSubject[] = strDatas[i].split(" ");
                Subjects s = new Subjects();
                s.setName(strSubject[0]);
                s.setScore(Double.parseDouble(strSubject[1]));
                s.setGrade(strSubject[2].charAt(0));
                subjects[i] = s;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Subjects 파일 내용 변경
        for(int i =0; i < subjects.length; i++) {
            subjects[i].setScore(subjects[i].getScore() + 5);
        }

        System.out.println(Arrays.toString(subjects));

        f = new File("/Users/houstonjustin/Documents/A.Project/A_A_A1-Lecture-Project/test/홍길동.subjects");
        sb = new StringBuilder(512);

        for(int i = 0; i < subjects.length; i++) {
            sb.append(subjects[i].getName() + " ");
            sb.append(subjects[i].getScore() + " ");
            sb.append(subjects[i].getGrade() + "\n");
        }

        try(FileWriter fw = new FileWriter(f)) {
            fw.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
