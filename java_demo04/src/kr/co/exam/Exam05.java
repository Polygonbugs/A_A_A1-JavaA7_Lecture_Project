package kr.co.exam;

import java.util.Scanner;

public class Exam05 {
    public static void main(String[] args) {
        /*
         *      다음 형식의 메뉴를 만들고 사용자에게 출력하세요.
         *
         *      1. Login
         *      2. Sign In
         *      3. ID/Password Find
         *
         *      위 메뉴 형식에서 사용자가 메뉴 번호에 해당하는 값을
         *      입력하면 각 메뉴에 적합한 출력 메시지가 나오게 하세요.
         *
         *      Login을 선택한 경우 "로그인 화면입니다."
         *      Sign In을 선택한 경우 "회원가입 화면입니다."
         *      ID/Password Find를 선택한 경우
         *      "아이디/패스워드 찾기 화면입니다."
         *
         */

        Scanner sc = new Scanner(System.in);

        System.out.println("1. Login");
        System.out.println("2. Sign In");
        System.out.println("3. ID/Password Find");

        int choice;
        System.out.print("메뉴를 선택하세요 (1, 2, 3번 중 선택) >> ");
        choice = sc.nextInt();

        if(choice == 1) {
            System.out.println("로그인 화면입니다.");
        } else if(choice == 2) {
            System.out.println("회원가입 화면입니다.");
        } else if(choice == 3) {
            System.out.println("아이디/패스워드 찾기 화면입니다.");
        } else {
            System.out.println("번호를 잘못 입력하셨습니다.");
        }

    }
}
