package kr.co.exam02.prac;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Exam {
    public static HashSet<Integer> getLottoNumber() {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        Random rand = new Random();

        while(numbers.size() < 6) {
            int num = rand.nextInt(45) + 1;

            Integer i = Integer.valueOf(num);
            if(!numbers.contains(i)) {
                numbers.add(i);
            }

            System.out.println(numbers);

            return numbers;
        }
    public static void main(String[] args) {
            /*
             *  로또 번호 생성
             *      - 1 ~ 45까지의 랜덤 번호를 생성하여 리스트에 담는다.
             *      - 중복된 값 없이 리스트에 담도록 한다.
             *      - 총 6개의 정수값이 리스트에 저장될 수 있도록 한다.
             *      - 마지막에 출력할 때 오름차순으로 정렬이 되도록 한다.
             */

            /*
             *  위에서 생성한 로또 번호 6개를 1셋트라고 하자
             *
             *  1. 사용자가 원하는 수의 셋트로 로또 번호가 생성되어 파일에 저장 될 수 있도록 한다.
             *  2. 저장할 때 D:\\에 lotto.txt 파일로 저장되도록 한다.
             *  3. 한 줄에 1셋트의 번호가 출력되어야 한다.
             *
             */

                File f = new File("/Users/houstonjustin/Documents/A.Project/A_A_A1-Lecture-Project/test/lotto.txt");

                try(BufferedWriter bw = new BufferedWriter(new FileWriter(f))) {
                    int setCount = 6;
                    for(int i = 0; i < setCount; i++) {
                        TreeSet<Integer> number = new TreeSet<Integer>(getLottoNumber());
                        Collections.sort(number);
                        String[] sArr = new String[number.size()];

                        int j = 0;
                        for(Integer n : number) {
                            sArr[j++] = n.toString();
                        }
                        bw.write(String.join(",", sArr));
                        bw.newLine();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

}
