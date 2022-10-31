package kr.co.exam01.prac;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Exam {
    public static void main(String[] args) throws ParseException {
        /*
         *  birthday.txt 파일에 작성된 생년월일을 읽고
         *  100년 동안의 생일에서 일 ~ 토요일까지의 모든
         *  요일 정보를 birthday100.txt에 저장하도록 한다.
         */

        // birthday.txt 파일에서 읽은 날짜를 사용

        File inF = new File("/Users/houstonjustin/Documents/A.Project/A_A_A1-Lecture-Project/test/birthday.txt");
        File outF = new File("/Users/houstonjustin/Documents/A.Project/A_A_A1-Lecture-Project/test/birthday100.txt");

        char[] cArr = new char[0];

        try(FileReader fr = new FileReader(inF)) {
            char[] buffer = new char[8];

            while(true) {
                int readChars = fr.read(buffer);
                if(readChars == -1) {
                    break;
                }
                cArr = Arrays.copyOf(cArr, cArr.length + readChars);
                System.arraycopy(buffer, 0, cArr, cArr.length - readChars, readChars);
            }

            System.out.println(cArr);   // 한글은 2바이트
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String birthday = null;

        for(int i = 0; i < cArr.length; i++) {
            if(i == 0) {
                birthday = "" + cArr[0];
            } else {
                birthday += "" + cArr[i];
            }
        }
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        Date d = df.parse(birthday);

        int year = Integer.parseInt(String.format("%tY", d));
        int month = Integer.parseInt(String.format("%tm", d));
        int day = Integer.parseInt(String.format("%td", d));
        GregorianCalendar gc = new GregorianCalendar(year, month - 1, day);

        df.applyPattern("yyyy년 MM월 dd일 EEEE");

        try(FileWriter fw = new FileWriter(outF, true)) { // append : true로하면 파일의 내용을 추가하는 모드로 만드는 것이다.
            for(int i = 0; i < 100; i++) {
                // birthday100.txt 파일에 쓰기
                System.out.println(df.format(gc.getTime()));
                fw.write(df.format(gc.getTime()) + "\n");
                gc.add(Calendar.YEAR, 1);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
