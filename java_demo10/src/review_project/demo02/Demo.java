            System.out.println(f.getPath() + "경로에 파일이 존재하지 않습니다.");
package review_project.demo02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Demo {
    // 범위 : 메인메서드(무대함수) 블럭기호 내부
    // 역할 : FileInputStream 클래스를 이용해서 운영체제에 존재하는(프로그램 밖에 존재하는) 파일을 프로그램에서 읽어서(input) 콘솔(Output)에 출력하는 역할
    public static void main(String[] args) {

        // 범위 : 19번 라인
        // 역할 : 파일 내용을 프로그램으로 로드하기 위해 필요한 객체(필드 - 저장공간, 메소드 - 동작) 생성.
        File f = new File("/Users/houstonjustin/Documents/A.Project/A_A_A1-Lecture-Project/test/입출력텍스트.txt");

        // 범위 : try ~ with ~ resource 구문의 블럭기호 내부
        // 역할 : 입력 스트림을 생성해서 외부의 데이터를 프로그램 내부로 받아오고 그것을 콘솔에 출력하는 역할
        // 범위 : catch 구문들의 블럭기호 내부
        // 역할 : try ~ with ~ resource 구문에서 발생할 수 있는 예외 : 찾는 파일 없음, 읽을 때 오류를 해결
        try(FileInputStream fis = new FileInputStream(f)) {
            byte[] bArr = new byte[(int)f.length()];        // 이 라인(범위) 역할 : 파일 객체에 있는 모든 내용물을 최종적으로 임시 저장하는 역할
            byte[] buffer = new byte[8];                    // 이 라인(범위) 역할 : 한번에 읽어 들일 수 있는 내용을 임시로 저장하는 역할

            int idx = 0;            // 이 라인(범위) 역할 : 복사할 때 읽은 부분까지를 체크하는 index(포인터)를 저장하기 위한 역할

            // 범위 : while 문
            // 역할 : 파일에 있는 내용을 한번에 읽어 들일 수 있는 내용의 양만큼 반복적으로 읽어서 그것을 bArr 변수에 누적 저장
            while(true) {
                // 범위 : 34번 라인
                // 역할 : 스트림을 통해서 읽은 데이터를 "buffer"에 저장하고, 읽은 양(size)을 readBytes에 저장한다
                int readBytes = fis.read(buffer);

                // 범위 : if문
                // 역할 : 파일을 끝까지 읽으면 반복문을 종료한다.
                if(readBytes == -1) {
                    break;
                }

                // 범위 : 42번 라인
                // 역할 : 파일에서 한 번에 읽은 내용(buffer)을 최종적으로 저장하고자 하는 변수(bArr)에 저장한다.
                System.arraycopy(buffer, 0, bArr, idx, readBytes);

                // 범위 : 46번 라인
                // 역할 : index(포인터)를 읽은 양(readBytes)만큼 늘린다.
                idx += readBytes;
            }

            System.out.println(new String(bArr));       // 이 라인(범위) 역할 : 파일 끝까지 읽은 데이터(파일 전체)를 출력

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
