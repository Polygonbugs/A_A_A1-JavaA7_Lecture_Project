package kr.co.exam02.ans;

import java.util.Scanner;

public class Exam {
    public static void main(String[] args) {
        /*
         *      사용자 입력을 사용하여 010-xxxx-xxxx와 같은 형식의 전화번호를 입력 받으세요
         *
         *      1. 전화번호는 반드시 010으로 시작해야 합니다.
         *      2. - 으로 구분된 전화번호 형식이 입력되어야 합니다.
         *      3. 사용자가 입력하는 전화번호는 나중에 출력할 때 숨김 처리 되어
         *         출력이 되어야 합니다.
         *         입력 : 010-1234-5678
         *         출력 : 010-1234-****
         *
         */

        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.print("전화번호 입력 : ");
            String input = sc.nextLine();

            if(input.contains("exit")) {
                break;
            }

            if(!input.startsWith("010")) {
                System.out.println("010 으로 시작해야 합니다.");
                continue;
            }

            if(input.length() != 13) {
                System.out.println("하이픈(-) 을 포함한 13 자리 번호를 입력하세요.");
                continue;
            }

            if(input.split("-").length != 3) {
                System.out.println("올바른 전화번호 형식이 아닙니다.");
                continue;
            }

            boolean isNumber = true;
            String phoneArr[] = input.split("-");

            for(int i = 1; i < phoneArr.length; i++) {
                for(int j = 0; j < phoneArr[i].length(); j++) {
                    if(!(phoneArr[i].charAt(j) >= '0' && phoneArr[i].charAt(j) <= '9')) {
                        System.out.println("0 ~ 9 에 해당하는 숫자가 아닙니다.");
                        isNumber = false;
                        break;
                    }
                }
                if(!isNumber) {
                    break;
                }
            }
            if(!isNumber) {
                continue;
            }

            boolean cntError = false;
            for(int i = 1; i < phoneArr.length; i++) {
                if(phoneArr[i].length() != 4) {
                    cntError = true;
                    break;
                }
            }

            if(cntError) {
                System.out.println("전화번호는 2번째 3번째 숫자가 4자리 이어야 합니다.");
                continue;
            }

            phoneArr[2] = "****";
            System.out.println("전화번호 출력 : " + String.join("-", phoneArr));
            break;

        }
    }
}
