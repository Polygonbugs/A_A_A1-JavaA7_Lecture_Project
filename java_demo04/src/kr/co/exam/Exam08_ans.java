package kr.co.exam;

public class Exam08_ans {
    public static void main(String[] args) {
        /*
         *      다음과 같은 모양의 출력을 만들어 보세요
         *      1
         *      2   3
         *      4   5   6
         *      7   8   9   10
         *      11  12  13  14  15
         */

        int colCount = 1, rowCount = 1;

        for(int i = 1; i <= 15; i++, colCount++) {
            System.out.printf("%d\t", i);

            if(colCount == rowCount) {
                System.out.println();
                colCount = 0;
                rowCount++;
            }
        }

        System.out.println("-----------------------");

        int n = 0;
        for(int i = 1; i <= 5; i++) {
            for(int j = 1; j<= i; j++) {
                n++;
                System.out.printf("%d\t", n);
            }
            System.out.print("\n");
        }
    }
}
