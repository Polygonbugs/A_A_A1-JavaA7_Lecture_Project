package kr.co.manager;

import kr.co.controller.AccountController;
import kr.co.vo.AccountVO;

import java.util.Scanner;

public class AccountManager {
    private Scanner sc = new Scanner(System.in);
    private AccountVO user = null;

    public void start() {
        while(true) {
            System.out.println("[1] 회원 가입 요청 목록");
            System.out.println("[2] 회원 가입 요청");
            System.out.println("[3] 회원 가입 요청 승인");
            if(user == null) {
                System.out.println("[4] 로그인");
            } else {
                System.out.println("[4] 로그아웃");
                System.out.println("[5] 패스워드 변경");
            }
            System.out.println("[9] 프로그램 종료");

            int menu = 0;

            while(true) {
                System.out.print("메뉴 번호 입력 : ");
                if(sc.hasNextInt()) {
                    menu = sc.nextInt(); sc.nextLine();
                    break;
                }

            }

            switch(menu) {
                case 1:
                    this.getAccountRequestList();
                    break;
                case 2:
                    this.setAccountRequest();
                    break;
                case 3:
                    this.acceptAccountRequest();
                    break;
                case 4:
                    if(user == null) {
                        this.login();
                    } else {
                        this.logout();
                    }
                    break;
                case 5:
                    if(user != null) {
                        this.changePassword();
                    }
                    break;
                case 9:
                    System.out.println("프로그램을 종료 합니다.");
                    System.exit(0);
            }

        }
    }

    private void changePassword() {
        AccountController ac = new AccountController();

        System.out.print("변경할 패스워드 입력 : ");
        String newPassword = sc.nextLine();

        System.out.print("현재 패스워드 입력 : ");
        String oldPassword = sc.nextLine();

        if(this.user.getPassword().equals(oldPassword)) {
            this.user = ac.changePassword(this.user, newPassword);
        }

    }

    private void logout() {
        AccountController ac = new AccountController();
        ac.logout(this.user);
        this.user = null;
    }

    private void login() {
        AccountController ac = new AccountController();

        System.out.print("닉네임 : ");
        String nickname = sc.nextLine();

        System.out.print("암호 : ");
        String password = sc.nextLine();

        user = ac.login(nickname, password);
    }

    private void acceptAccountRequest() {
        AccountController ac = new AccountController();

        ac.getAccountRequest();

        System.out.println("위 목록 중 승인할 ID를 입력하세요.");
        System.out.println("예) ");
        System.out.println("    ID 입력 : 1 3 6 9");

        System.out.print("ID 입력 : ");
        String[] ids = sc.nextLine().split(" ");

        int[] temp = new int[ids.length];
        int i = 0;
        for(String id: ids) {
            temp[i++] = Integer.parseInt(id);
        }

        ac.acceptAccountRequest(temp);
    }

    private void setAccountRequest() {
        AccountController ac = new AccountController();

        System.out.print("닉네임 입력 : ");
        String nickname = sc.nextLine();

        System.out.print("이메일 입력 : ");
        String email = sc.nextLine();

        ac.setAccountRequest(nickname, email);
    }

    private void getAccountRequestList() {
        AccountController ac = new AccountController();
        ac.getAccountRequest();
    }
}
