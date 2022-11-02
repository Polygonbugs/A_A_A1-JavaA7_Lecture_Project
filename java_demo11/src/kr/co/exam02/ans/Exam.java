package kr.co.exam02.ans;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

public class Exam {

    public static HashSet<Integer> getLottoNumber() {
        HashSet<Integer> numbers = new HashSet<Integer>();
        Random rand = new Random();
        while(numbers.size() < 6) {
            int num = rand.nextInt(45) + 1;
            Integer i = Integer.valueOf(num);
            numbers.add(i);
        }
        return numbers;
    }

    public static void main(String[] args) {
        /*
         * 로또 번호 생성
         *     - 1 ~ 45 까지의 랜덤 번호를 생성하여 리스트에 담는다.
         *     - 중복된 값 없이 리스트에 담도록 한다.
         *     - 총 6 개의 정수값이 리스트에 저장될 수 있도록 한다.
         *     - 마지막에 출력할 때 오름차순으로 정렬이 되도록 한다.
         */

        /*
         * 위에서 생성한 로또 번호 6개를 1셋트 라고 하자.
         *
         * 1. 사용자가 원하는 수의 셋트로 로또 번호가 생성되어 파일에 저장 될 수 있도록한다.
         * 2. 저장할 때 D:\\ 에 lotto.txt 파일로 저장되도록 한다.
         * 3. 한 줄에 1셋트의 번호가 출력되어야 한다.
         */
        File f = new File("/Users/houstonjustin/Documents/A.Project/A_A_A1-Lecture-Project/test/lotto.txt");

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(f))) {
            int setCount = 6;
            for(int i = 0; i < setCount; i++) {
                TreeSet<Integer> numbers = new TreeSet<Integer>(getLottoNumber());

                String[] sArr = new String[numbers.size()];
                int j = 0;
                for(Integer n: numbers) {
                    sArr[j++] = n.toString();
                }

                bw.write(String.join(", ", sArr));
                bw.newLine();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}