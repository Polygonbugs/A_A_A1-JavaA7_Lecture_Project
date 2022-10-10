package kr.co.demo;

public class Demo04 {
    public static void main(String[] args) {
        // 출력 :	System.out.print() 메서드로 변수에 저장된 데이터를
        //			터미널에 출력하기 위해 사용된다.
        //			출력 메서드는 .print() 외에 .printf() / .println() 이 있다.

        //	.print()는 개행(줄바꿈) 없이 한 줄에 계속 출력을 할 때 사용
        //	.printf()는 .print() 기능에 특정 형식(포멧)을 갖추어 출력할 때 사용
        //	.println()은 .print() 기능을 수행 후 개행(줄바꿈)을 추가할 때 사용

        System.out.print('A');
        System.out.print('B');
        System.out.print('C');

        System.out.println();

        System.out.println('A');
        System.out.println('B');
        System.out.println('C');

        System.out.printf("%s", "A");


    }
}