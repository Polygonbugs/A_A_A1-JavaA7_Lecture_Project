package kr.co.exam;

import java.util.Scanner;

public class Exam04 {
    public static void main(String[] args) {
        /*
         *      사용자 입력과 if문을 활용하여 사용자로부터 문자열을
         *      2개 입력 받아 다음의 문제를 풀어보세요.
         *
         *      아이디와, 패스워드에 해당하는 문자열을 입력 받고 미리
         *      설정한 아이디와 패스워드가 사용자가 입력한 문자열과 일치
         *      하는 경우 "로그인 성공" 메시지를 출력하세요. 아이디 또는 패스워드가
         *      일치하지 않는 경우 "해당하는 아이디가 없습니다",
         *      "패스워드가 잘못되었습니다." 메시지도 출력되도록 하세요
         */

        Scanner sc = new Scanner(System.in);

        String username, password;

        System.out.print("사용자 아이디를 입력하세요 : ");
        username = sc.nextLine();

        System.out.print("사용자 비밀번호를 입력하세요 : ");
        password = sc.nextLine();

        if(username.equals("Hello") && password.equals("test1234")) {
            System.out.println("로그인 성공");
        } else if (!username.equals("Hello") && password.equals("test1234")){
            System.out.println("사용자 아이디를 잘못 입력 하셨습니다");
        } else if (username.equals("Hello") && !password.equals("test1234")){
            System.out.println("사용자 비밀번호를 잘못 입력 하셨습니다");
        } else {
            System.out.println("둘 다 잘못 입력하셨습니다");
        }

    }
}
