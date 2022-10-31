package kr.co.exam02.ans;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Exam {

    public static void main(String[] args) {
        /*
         * 파일에 저장된 성적 데이터를 읽고 프로그램에서
         * 사용할 수 있는 Subject 객체로 변환한다.
         * 변환된 Subject 를 활용하여 데이터 추가 및 수정, 삭제
         * 를 진행 후 다시 동일한 파일에 저장할 수 있게 한다.
         * 파일명은 "학생명.subjects" 로 하며, 파일에 작성된 데이터는
         * 다음의 구조를 가진다.
         *
         * 학생명.subjects
         *     과목명1 점수1 등급1
         *     과목명2 점수2 등급2
         *     과목명3 점수3 등급3
         *     ...
         *     ...
         */

        File f = new File("/Users/houstonjustin/Documents/A.Project/A_A_A1-Lecture-Project/test/홍길동.subjects");

        Subject subjects[] = null;

        StringBuilder sb = new StringBuilder(512);

        try(FileReader fr = new FileReader(f)) {
            char[] buffer = new char[8];
            while(true) {
                int readChars = fr.read(buffer);
                if(readChars == -1) {
                    break;
                }
                sb.append(buffer, 0, readChars);
            }

            String strDatas[] = sb.toString().split("\\r\\n");
            subjects = new Subject[strDatas.length];

            for(int i = 0; i < strDatas.length; i++) {
                String strSubject[] = strDatas[i].split(" ");
                Subject s = new Subject();
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


        // Subject 데이터 변경
        for(int i = 0; i < subjects.length; i++) {
            subjects[i].setScore(subjects[i].getScore() + 5);
        }

        System.out.println(Arrays.toString(subjects));

        sb = new StringBuilder(512);
        for(int i = 0; i < subjects.length; i++) {
            sb.append(subjects[i].getName() + " ");
            sb.append(subjects[i].getScore() + " ");
            sb.append(subjects[i].getGrade() + "\r\n");
        }

        f = new File("D:\\홍길동.subjects");
        try(FileWriter fw = new FileWriter(f)) {
            fw.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}