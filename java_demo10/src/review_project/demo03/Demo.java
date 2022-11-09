package review_project.demo03;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Demo {
    // 맥락(관점) : [범위1 + 범위2]의 관계
    // 범위 1 : 프로그램의 사용용도
    // 범위 2 : 프로그래밍 코드, 메인 메소드 블럭 내부
    // 범위들의 관계(역할) : FileReader(문자기반 스트림)을 이용해서 프로그램 외부의 파일을 읽어서 콘솔창에 출력하는 것
    public static void main(String[] args) {

        File f = new File("/Users/houstonjustin/Documents/A.Project/A_A_A1-Lecture-Project/test/입출력텍스트.txt");

        try(FileReader fr = new FileReader(f)) {
            char[] cArr = new char[(int)f.length()];
            char[] buffer = new char[8];

            while(true) {
                int readChars = fr.read(buffer);

                if(readChars == -1) {
                    break;
                }

                cArr = Arrays.copyOf(cArr, cArr.length + readChars);
                System.arraycopy(buffer, 0, cArr, cArr.length - readChars, readChars);
            }

            System.out.println(cArr);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
