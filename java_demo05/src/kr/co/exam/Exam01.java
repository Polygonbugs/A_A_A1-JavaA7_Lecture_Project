package kr.co.exam;

public class Exam01 {
    public static void main(String[] args) {
        /*
         *  배열 크기가 3인 정수 배열을 만들고 3부터 시작하는
         *  3의 배수 값으로 초기화 한 후 출력하세요.
         *
         */

        int arr[] = new int[3];

        for(int i = 0; i < arr.length; i++) {
            arr[i] = (i + 1) * 3;
            System.out.printf("%d\n", arr[i]);
        }


        /*
         *  배열 크기가 5인 정수 배열을 만들고 5부터 -1씩 감소된
         *  값으로 초기화 한 후 출력하세요
         */
        System.out.println("\n------------\n");

        int arr2[] = new int[5];

        for(int i = 0; i < arr2.length; i++) {
            arr2[i] = 5 - i;
            System.out.printf("%d\n", arr2[i]);
        }


    }
}
