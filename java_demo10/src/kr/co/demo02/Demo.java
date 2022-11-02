package kr.co.demo02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Demo {
    public static void main(String[] args) {
        /*
         *      FileInputStream 클래스
         *          - 바이트 기반 스트림으로 바이트 단위로 파일을 읽는다.
         */
        File f = new File("/Users/houstonjustin/Documents/A.Project/A_A_A1-Lecture-Project/test/입출력텍스트.txt");

        // try ~ with ~ resource : finally 안에 f.close()를 안해도 됨. 기본 파일 입출력은 지원한다.
        try(FileInputStream fis = new FileInputStream(f)) {
            byte[] bArr = new byte[(int)f.length()];
            byte[] buffer = new byte[8];

            int idx = 0;
            while(true) {
                int readBytes = fis.read(buffer);     // -1이 반환되면 더 이상 읽을 데이터가 없다.
                if(readBytes == -1) {
                    break;
                }
                System.arraycopy(buffer, 0, bArr, idx, readBytes);
                idx += readBytes;
            }

            System.out.println(new String(bArr));   // println은 byte[]를 출력할 수 없다.

        } catch (FileNotFoundException e) {
            System.out.println(f.getPath() + "경로에 파일이 존재하지 않습니다.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("파일을 읽는 과정 중에 문제가 발생하였습니다.");
            e.printStackTrace();
        }

    }
}
