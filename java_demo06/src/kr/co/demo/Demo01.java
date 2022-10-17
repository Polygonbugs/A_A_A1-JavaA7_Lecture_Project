package kr.co.demo;

public class Demo01 {
    public static void main(String[] args) {
        /*
         *     객체
         *          현실 세계에서는 사물이나 개념처럼 독립되고 구분되는
         *          각각의 객체로 이루어져 있으며, 발생하는 모든 사건들은
         *          객체간의 상호작용으로 이루어져 있다. 이러한 개념을
         *          컴퓨터로 옮겨 유사하게 동작하도록 만든 것을 객체지향 언어
         *          라고 한다.
         *
         *      예시
         *          국가에서 국민 정보 관리용 프로그램을 만들려고 할 때,
         *          프로그램에서 요구하는 "국민" 이라는 한 사람의 정보를 객체화(추상화) 한다면,
         *
         *          국민 : 이름, 나이, 성별, 전화번호, 주민등록번호, 주소, ... 등
         *
         *          국민객체
         *              String 이름;
         *              int 나이;
         *              char 성별;
         *              String 전화번호;
         *              String 주민등록번호;
         *              String 주소;
         *
         *          public class 국민 {
         *              String 이름;
         *              int 나이;
         *              char 성별;
         *              String 전화번호;
         *              String 주민등록번호;
         *              String 주소;
         *         }
         */

        // 인스턴스화 : 클래스 객체를 인스턴스 객체로 만드는 과정
        Person p1 = new Person();
        Person p2 = new Person();
        SmartPhone phone1 = new SmartPhone();

        // 인스턴스 객체의 멤버변수에 데이터 할당
        p1.name = "홍길동";
        p1.age = 29;
        p2.name = "김철수";
        p2.age = 32;
        phone1.brand = "삼성 갤럭시 노트";
        phone1.model = "BSE-4567";
        phone1.number = "010-4567-8975";

        // 인스턴스 객체의 멤버변수에 저장된 데이터 확인
        System.out.println(p1.name);
        System.out.println(p1.age);

        System.out.println(p2.name);
        System.out.println(p2.age);
    }
}
