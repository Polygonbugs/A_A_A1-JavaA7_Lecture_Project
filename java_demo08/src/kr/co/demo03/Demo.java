package kr.co.demo03;

import java.util.StringTokenizer;

public class Demo {
    public static void main(String[] args) {
        /*
         *      StringTokenizer
         *          문자열을 특정 구분 문자를 기준으로 분리하는 클래스
         *          배열을 사용하지 않고 String으로 반환한다.
         */

        String str = "A, B, C, D, E, F";
        StringTokenizer sToken = new StringTokenizer(str, ",");

        while(sToken.hasMoreTokens()) {
            System.out.println(sToken.nextToken());
        }
    }
}
