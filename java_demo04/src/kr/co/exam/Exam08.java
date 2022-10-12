package kr.co.exam;

public class Exam08 {
    public static void main(String[] args) {
        /*
         *      다음과 같은 모양의 출력을 만들어 보세요
         *      1
         *      2   3
         *      4   5   6
         *      7   8   9   10
         *      11  12  13  14  15
         */

        int count = 0;
        for(int i = 1; i <= 5; i++) {
            for(int j = 1; j <= i; j++) {
                count++;
                System.out.printf("%d\t", count);
            }
            System.out.println();
        }


    }
}
