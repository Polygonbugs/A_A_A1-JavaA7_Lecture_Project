package kr.co.demo05;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Demo {
    public static void main(String[] args) {
        /*
         *      FileWriter
         */

        File f = new File("/Users/houstonjustin/Documents/A.Project/A_A_A1-Lecture-Project/test/입출력텍스트.txt");

        try(FileWriter fw = new FileWriter(f, true)) { // append : true로하면 파일의 내용을 추가하는 모드로 만드는 것이다.
            fw.write(65);               // 아스키코드값?
            fw.write("문자열");
            fw.append("append로 출력");    // .write와 큰 차이가 없다

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
