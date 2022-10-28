package kr.co.demo03;

import kr.co.demo03.user.Member;
import kr.co.demo03.user.exception.UserException;

public class Demo {
    public static void main(String[] args) throws UserException {
        /*
         *  사용자 정의 예외
         *      Exception 클래스를 상속 받아 자신만의 예외클래스를 만드는 것.
         */

        Member m = new Member(null);

        m.setName(null);

        System.out.println(m.getName());
        System.out.println("Test");
    }
}
