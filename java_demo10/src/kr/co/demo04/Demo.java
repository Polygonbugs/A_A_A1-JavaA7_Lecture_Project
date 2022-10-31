package kr.co.demo04;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Demo {
    public static void main(String[] args) {
        /*
         *      FileOutputStream 클래스
         */
        File f = new File("/Users/houstonjustin/Documents/A.Project/A_A_A1-Lecture-Project/test/입출력텍스트.txt");

        try(FileOutputStream fos = new FileOutputStream(f, true)) { // append : true로하면 파일의 내용을 추가하는 모드로 만드는 것이다.

            fos.write(65);
            fos.write(66);
            fos.write(67);
            fos.write(68);

            fos.write("\r\n한글문자열".getBytes());      // 한글은 일반적으로 출력해줄수는 없다. 이렇게 함수를 써야한다.

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
