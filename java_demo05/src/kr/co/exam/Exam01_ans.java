package kr.co.exam;

public class Exam01_ans {
    public static void main(String[] args) {
        /*
         *  배열 크기가 3인 정수 배열을 만들고, 3부터 시작하는
         *  3의 배수 값으로 초기화, 출력하세요.
         *
         */

        int arr1[] = new int[3];

        int i = 0;
        while(i < arr1.length) {
            arr1[i] = (i + 1) * 3;
            i++;
        }

        for(i = 0; i < arr1.length; i++) {
            System.out.printf("%d\t", arr1[i]);
        }
        System.out.println();

        /*
         *  배열 크기가 5인 정수 배열을 만들고 5부터 -1씩 감소된
         *  값으로 초기화 한 후 출력하세요
         */
        System.out.println("\n------------\n");

        int arr2[] = new int[5];

        i = 0;
        while(i < arr2.length) {
            arr2[i] = arr2.length - i;
            i++;
        }

        for(i = 0; i < arr2.length; i++) {
            System.out.printf("%d\t", arr2[i]);
        }
        System.out.println();


    }
}
