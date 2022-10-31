package kr.co.demo01;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        /*
         *      입출력(IO)
         *          - 컴퓨터 내부/외부 장치간에 데이터를 교환하기 위해 사용
         *          - 프로그램을 기준으로 내부/외부 장치에서 데이터가 현재 동작하는
         *            프로그램으로 들어오면 입력, 반대로 현재 동작하는 프로그램에서
         *            내부/외부 장치로 나가면 출력이라고 한다.
         *            (하드디스크의 파일을 프로그램 내에서 사용할 수 있도록 불러올 때는
         *            입력 반대로 프로그램에서 생성한 데이터를 하드디스크의 파일로 내보낼 때에는 출력)
         *
         *          - 입출력은 입력스트림, 출력스트림이 개별로 존재하며 하나의 스트림가지고 입출력은
         *            동시에 작업을 할 수 없기 때문에 반드시 입력과 출력을 구분하여 진행해야 한다.
         *
         *       스트림(Stream)
         *          - 두 장치간에 데이터를 교환하기 위해 생성한 데이터 이동 통로
         *          - 스트림은 입력/출력 스트림으로 나누어져 있고,
         *            또한 그 안에서 바이트기반스트림, 문자기반스트림으로 분리되어 있다.
         *          - 바이트기반스트림은 데이터 입/출력에 사용하는 데이터가 바이트로 이루어짐.
         *            (이미지, 영상, 실행파일 등의 바이트기반 데이터를 입출력 할 때 사용/ .docx, .hwp)
         *          - 문자기반스트림은 입/출력에 사용하는 데이터가 문자로 이루어짐.
         *            (텍스트 문서등의 문자기반 데이터를 입출력할 때 사용/.txt, .ini)
         */

        File f = new File("/Users/houstonjustin/Documents/A.Project/A_A_A1-Lecture-Project/test/입출력텍스트.txt");
        System.out.printf("%d byte\n", f.length());
        System.out.printf("%1$tY년 %1$tm월 %1$td일\n", new Date(f.lastModified()));

        System.out.printf("파일유무 : %s\n", f.isFile());
        System.out.printf("폴더유무 : %s\n", f.isDirectory());
        System.out.printf("숨김유무 : %s\n", f.isHidden());

        System.out.printf("파일/폴더명 : %s\n", f.getName());
        System.out.printf("파일/폴더 상위 경로 : %s\n", f.getParent());
        System.out.printf("파일/폴더 전체 경로 : %s\n", f.getPath());

        System.out.printf("존재유무 : %s\n", f.exists());

        File f2 = new File("/Users/houstonjustin/Documents/A.Project/A_A_A1-Lecture-Project/temp/src/project");

        // .mkdirs() 상위 디렉토리가 없을때 만들어주는 디렉토리 설정 메소드
        if(!f2.exists()) {
            f2.mkdirs();
        } else {
            f2.delete();
        }

        File f3 = new File("/Users/houstonjustin/Documents/A.Project/A_A_A1-Lecture-Project/temp/main.java");

        if(!f3.exists()) {
            try {
                f3.createNewFile();
                System.out.println("파일 파일 생성이 완료되었습니다.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            f3.delete();
        }

        File f4 = new File("/Users/houstonjustin/Documents/A.Project/A_A_A1-Lecture-Project/temp");
        f4.delete(); // 파일만 삭제되지 폴더는 삭제 되지 않는다.

    }
}
