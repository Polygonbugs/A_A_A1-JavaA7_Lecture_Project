package kr.co.exam01.ans;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Exam {

    public static String getBirthDay(String filePath) {
        File f = new File(filePath);

        try (FileInputStream fis = new FileInputStream(f)) {
            byte[] bArr = new byte[(int)f.length()];
            byte[] buffer = new byte[8];

            int idx = 0;
            while(true) {
                int readBytes = fis.read(buffer);
                if(readBytes == -1) {
                    break;
                }
                System.arraycopy(buffer, 0, bArr, idx, readBytes);
                idx += readBytes;
            }

            return new String(bArr);
        } catch (FileNotFoundException e) {
            System.out.println(f.getPath() + " 경로에 파일이 존재하지 않습니다.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("파일을 읽는 과정중에 문제가 발생하였습니다.");
            e.printStackTrace();
        }
        return null;
    }

    public static void writeBirthDay(String filePath, String data) {
        File f = new File(filePath);

        try(FileWriter fw = new FileWriter(f, true)) {
            fw.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws ParseException {
        /*
         * birthday.txt 파일에 작성된 생년월일을 읽고
         * 100년 동안의 생일에서 일 ~ 토요일 까지의 모든
         * 요일 정보를 birthday100.txt 에 저장하도록 한다.
         */

        // birthday.txt 파일에서 읽은 날짜를 사용
        String birthDay = getBirthDay("/Users/houstonjustin/Documents/A.Project/A_A_A1-Lecture-Project/test/birthday.txt");

        System.out.println(birthDay);

        SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
        Date d = df.parse(birthDay);
        int year = Integer.parseInt(String.format("%tY", d));
        int month = Integer.parseInt(String.format("%tm", d));
        int day = Integer.parseInt(String.format("%td", d));
        GregorianCalendar gc = new GregorianCalendar(year, month - 1, day);

        df.applyPattern("yyyy년 MM월 dd일 EEEE");

        StringBuilder sb = new StringBuilder(512);
        for(int i = 0; i < 100; i++) {
            // birthday100.txt 파일에 쓰기
            sb.append(df.format(gc.getTime()) + "\r\n");
            gc.add(Calendar.YEAR, 1);
        }
        writeBirthDay("/Users/houstonjustin/Documents/A.Project/A_A_A1-Lecture-Project/test/birthday100.txt", sb.toString());
    }

}