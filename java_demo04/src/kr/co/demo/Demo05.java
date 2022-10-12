package kr.co.demo;

public class Demo05 {
    public static void main(String[] args)  {
        /*
         *          while 반복문
         *
         *          while(조건식) {
         *              실행 코드;
         *          }
         *
         *          조건식의 갑이 참일 때 반복을 수행하며, 거짓이 되면 반복을 중단한다.
         *
         *          break, continue 사용으로 반복문을 제어할 수 있다.
         */

        int i = 1;          // 초기식
        while(i <= 5) {     // 조건식
            System.out.printf("%d\n", i);
            i++;            // 증감식
        }

        // 무한 반복
        while(true) {
            System.out.printf("%d\n", i);
            if(i >= 10) {
                break;
            }
            i++;
        }

        // 초기값을 0부터 시작하여 총 10번 반복하는 반복문
        int x6 = 0;

        while(x6 < 10) {
            System.out.printf("총 10번 반복중 %d번 반복함\n", x6++ + 1);
        }

        // 1 ~ n까지의 범위에서 m의 배수에 해당하는 값만 출력
        int n = 100;
        int m = 7;
        int x7 = 1;

        while(x7 < n) {
            if(x7 % m == 0) {
                System.out.printf("%d\n", x7);
            }
            x7++;
        }

        // 중첩 반복문
        int a= 1;
        while(a <= 9) {
            int b = 1;
            while(b <= 9) {
                System.out.printf("%d x %d = %d\t", b, a, b * a);
                b++;
            }
            System.out.println();
            a++;
        }

        /*
         *      do while
         *          일단 1회는 무조건 수행한다.
         *
         *      do {
         *          반복 실행 코드;
         *      } while(조건식);
         */


    }
}
