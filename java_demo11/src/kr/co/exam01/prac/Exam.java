package kr.co.exam01.prac;

import java.io.*;
import java.util.*;

public class Exam {
    public static ArrayList<Integer> createLotto() {
        Random rand = new Random();

        ArrayList<Integer> arr = new ArrayList<Integer>();

        int isDuplicate = 0;
        int idx = 0;

        for(int i = 0; i < 6;) {
            if(isDuplicate == 0) {
                arr.add(rand.nextInt(45) + 1);
            } else {
                arr.set(idx, rand.nextInt(45) + 1);
            }

            for(int j = 0; j < i; j++) {
                if(arr.get(j) == arr.get(i)) {
                    isDuplicate = 1;
                    idx = j;
                    break;
                }
            }

            if(isDuplicate == 1) {
                continue;
            }

            i++;

        }

        return arr;
    }

    public static void writeFile(ArrayList<Integer> tmp) {
        File f = new File("/Users/houstonjustin/Documents/A.Project/A_A_A1-Lecture-Project/test/lotto.txt");

        try(FileOutputStream fos = new FileOutputStream(f, true)) { // append : true로하면 파일의 내용을 추가하는 모드로 만드는 것이다.

            for(int i = 0; i < tmp.size(); i++) {
                fos.write(Integer.valueOf(tmp.get(i)));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFile() {
        File f = new File("/Users/houstonjustin/Documents/A.Project/A_A_A1-Lecture-Project/test/lotto.txt");

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

            System.out.println(new String(bArr));

        } catch (FileNotFoundException e) {
            System.out.println(f.getPath() + "경로에 파일이 존재하지 않습니다.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("파일을 읽는 과정 중에 문제가 발생하였습니다.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        /*
         *  로또 번호 생성
         *      - 1 ~ 45까지의 랜덤 번호를 생성하여 리스트에 담는다.
         *      - 중복된 값 없이 리스트에 담도록 한다.
         *      - 총 6개의 정수값이 리스트에 저장될 수 있도록 한다.
         *      - 마지막에 출력할 때 오름차순으로 정렬이 되도록 한다.
         */

        ArrayList<Integer> arr = createLotto();

        Collections.sort(arr);
        System.out.println(arr);


        /*
         *  위에서 생성한 로또 번호 6개를 1셋트라고 하자
         *
         *  1. 사용자가 원하는 수의 셋트로 로또 번호가 생성되어 파일에 저장 될 수 있도록 한다.
         *  2. 저장할 때 D:\\에 lotto.txt 파일로 저장되도록 한다.
         *  3. 한 줄에 1셋트의 번호가 출력되어야 한다.
         *
         */

        Scanner sc = new Scanner(System.in);
        System.out.print("뽑을 로또 개수를 입력하세요 : ");
        int inputLength = sc.nextInt();

        for(int i = 0; i < inputLength; i++) {
            writeFile(createLotto());
        }

        //Exam.readFile();


    }
}
