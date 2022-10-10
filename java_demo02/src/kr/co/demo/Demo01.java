package kr.co.demo;

public class Demo01 {

    public static void main(String[] args) {
        // 변수 : 컴퓨터 메모리에 값(데이터)를 저장하기 위한 공간
        //		  변수 공간에 저장한 값을 쉽게 사용하기 위해 변수에는
        //		  이름이 부여되어야 한다. -> 변수명

        // 변수명에는 작명 규칙이 있어 다음의 규칙을 반드시 지켜서 작성해야 한다.
        // 1. 영문자, 숫자, 한글등의 문자, 특수문자(_,$) 만 사용할 수 있다.
        // 2. 숫자로 시작하면 안된다.
        // 3. 공백이 있으면 안된다.
        // 4. 예약어는 사용할 수 없다.
        // 5. 영문자 대/소문자는 구분을 한다.

        // 다음의 규칙은 필수는 아니지만 관습적으로 굳어진 규칙이다.
        // 1. 변수명은 소문자로 작성해야 한다.
        // 2. 2개 이상의 단어로 조합을 하는 경우 2번째 단어의
        // 	  첫번째 문자는 대문자로 작성한다. -> 카멜케이스(Camel Case) 방식

        // 자료형
        // 1. 정수
        //		- 1 바이트 크기 정수 -> byte
        //		- 2 바이트 크기 정수 -> short
        //		- 4 바이트 크기 정수 -> int
        //		- 8 바이트 크기 정수 -> long
        // 2. 실수
        //		- 4 바이트 크기 실수 -> float
        //		- 8 바이트 크기 실수 -> double
        // 3. 문자
        //		- 2 바이트크기 -> char
        // 4. 문자열
        //		- 참조형 -> String
        // 5. 불린
        //		- 1 바이트 크기 -> boolean

        short x = 65;		// 00000000 01000001
        char y = 65;		// 00000000	01000001

        System.out.print(x);
        System.out.print(y);

        // 변수 선언
        int x1;
        int y1;
        int z1;

        x1 = 10;
        y1 = 20;
        z1 = 30;

        // 변수 선언과 동시에 할당
        int x2 = 10;
        int y2 = 20;
        int z2 = 30;

        System.out.print(x1);
        System.out.print(y1);
        System.out.print(z1);

        // 변수 선언만 하고 할당(저장)을 하지 않은 경우
        //int x3;
        //System.out.print(x3);

        // 다양한 자료형을 사용하여 변수에 데이터 저장
        boolean bool1 = true;
        boolean bool2 = false;

        byte bt1 = 0;
        byte bt2 = 127;
        byte bt3 = -128;

        short st1 = 0;
        short st2 = 32767;
        short st3 = -32768;

        int it1 = 0;
        int it2 = 2147483647;
        int it3 = -2147483648;

        long lg1 = 0L;
        long lg2 = 9223372036854775807L;
        long lg3 = -9223372036854775808L;

        float ft = 0.0f;
        float ft2 = .0f;

        double db1 = 0.0;
        double db2 = .0;

        char ch1 = 65;
        char ch2 = 'A';		// 작은 따옴표로 감싸야 한다.

        String st = "ABCDEFG";	// 큰 따옴표로 감싸야 한다.


    }

}
