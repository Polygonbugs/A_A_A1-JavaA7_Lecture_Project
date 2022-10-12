package kr.co.demo;

public class Demo04 {
    public static void main(String[] args) {
        /*
         *  반복문
         *      프로그램 수행 흐름을 바꾸는 역할을 하는 제어문 중 하나로
         *      특정 문장을 반복해서 수행하도록 한다.
         *
         *      반복문은 for, while 두 가지의 반복문이 있다.
         *
         *      for(초기식 ; 조건식 ; 증감식) {
         *          반복 실행할 코드1;
         *          반복 실행할 코드2;
         *      }
         *
         *      초기식 : 변수를 초기화하기 위한 식이 위치한다. (생략가능 / ";" 꼭 붙여야 한다.)
         *             반복문이 시작할 때 최초 1회만 동작
         *      조건식 : 반복문을 계속 수행할지에 대한 조건이 위치한다. (생략가능)
         *             조건식의 결과가 참이면 반복문 안의 코드를 실행한다.
         *             조건식의 결과가 거짓이면 반복문을 중단하고 다음 코드로 넘어간다.
         *             반복문이 시작할 때 뿐만 아니라 반복이 이루어지면 계속 실행한다.
         *      증감식 : 보통 초기식에서 초기화한 변수의 값을 증감시키기 위해 사용 (생략가능)
         *             반복문의 마지막 코드가 실행된 후에 수행하는 코드.
         *             반복문이 시작할 때에는 동작하지 않는다.
         *             반복이 이루어지면 계속 실행한다.
         *
         *     for 반복문에서 초기식, 조건식, 증감식을 모두 생략하면 무한 반복이 된다.
         *     for 반복문에서 조건식을 잘못 설정하면 무한 반복 또는 반복 안함.
         *
         *     반복문 안에 break를 사용하면 반복문을 중단할 수 있다.
         *     반복문 안에 continue를 사용하면 반복문의 처음으로 이동한다.
         *     if문에는 break가 작용하지 않는다. switch문에는 break가 사용된다.
         *
         */

        /*
        int x;
        for(x = 1; x <= 3; x++) {
            System.out.printf("반복 횟수 및 변수 x에 저장된 값 -> %d 회 / 값 : %d\n", x, x);
        }

        System.out.printf("변수 x에 저장된 최종 값 -> %d", x);

         */

        /*
        for(int x2 = 1; x2 <= 3; x2++) {
            System.out.printf("반복 횟수 및 변수 x에 저장된 값 -> %d 회 / 값 : %d\n", x2, x2);
        }

        //System.out.printf("변수 x에 저장된 최종 값 -> %d", x2);

         */

        /*
        for(int x3 = 1; x3 <= 3;) {
            System.out.printf("%d 번째 반복\n", x3);
            x3++;
        }

         */

        /*
        for(int x4 = 1; ; x4++) {
            System.out.printf("%d번째 반복\n", x4);
            if(x4 >= 3) {
                break;
            }
        }
        */

        /*
        int x5 = 1;
        for(;x5 <= 3; x5++) {
            //x5 =1; // 반복문의 조건으로 사용하고 있는 변수를 초기화하면 무한 반복 된다.
            System.out.printf("%d번째 반복\n", x5);
        }

         */

        // 일정 횟수 반복을 위한 반복문 (1부터 시작)
        /*
        for(int x6 = 1; x6 <= 10; x6++) {
            System.out.printf("총 10번 반복중 %d번 반복함\n", x6);
        }

         */

        // 일정 횟수 반복을 위한 반복문 (0부터 시작 - 이게 보통 더 많이 쓰인다.)
        /*
        for(int x6 = 0; x6 < 10; x6++) {
            System.out.printf("총 10번 반복중 %d번 반복함\n", x6 + 1);
        }

         */


        // 1 ~ n까지의 범위에서 m의 배수에 해당하는 값만 출력
        /*
        int n = 100;
        int m = 2;
        for(int x7 = 1; x7 < n; x7++) {
            if(x7 % m == 0) {
                System.out.printf("%d\n", x7);
            }
        }

         */

        // 누적합을 구하기 위한 반복문
        /* int sum1 = 0;
        for(int x8 = 1; x8 <= 10; x8++) {
            sum1 += x8;
        }
        System.out.printf("1 ~ 10 까지의 누적합은 %d입니다.\n", sum1);

        int sum2 = 0;
        for(int x8 = 1; x8 <= 100; x8++) {
            if(x8 % 2 == 0) {
                sum2 += x8;
            }
        }
        System.out.printf("1 ~ 100 까지의 짝수의 누적합은 %d입니다.\n", sum2);

         */

        // 큰 값 -> 작은 값 감소하는 형식의 반복문
        /*
        for(int x9 = 10; x9 >= 1; x9--) {
            System.out.printf("%d\n", x9);
        }
        */

        // 중첩 반복문
        for(int i = 1; i <= 9; i++) {
            for(int j = 2; j <= 9; j++) {
                System.out.printf("%d X %d = %d\t", j, i, j * i);
            }
            System.out.println();
        }

    }
}
