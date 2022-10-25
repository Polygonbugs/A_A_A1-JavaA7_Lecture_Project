package kr.co.demo04;

public class Demo {
    public static void main(String[] args) {
        /*
         *      추상(abstract) 클래스
         *          - 미완성 클래스로 클래스 안의 메서드가 전부 구현되어 있지는 않다.
         *          - 메서드 선언부만 있고 구현은 하지 않은 추상 메서드를 가지는 클래스
         *          - 추상 메서드를 반드시 포함하는 것은 아니다.
         *          - abstract 키워드를 만들어서 사용
         *          - 추상 클래스로는 직접 객체를 생성할 수 없다.
         *            (단, 참조 타입으로는 사용가능 -> 다형성으로 사용 가능)
         *          - 추상 클래스를 상속하는 일반 클래스는 미완성 메서드에 대해서 반드시
         *            구현을 해야하는 강제성을 띄고 있다.
         *
         *      추상 클래스를 사용할 때의 이점
         *          - 추상 클래스를 상속하는 자식 클래스들의 메서드는 일관성 있는 이름으로 사용가능
         *          - 반드시 필요한 기능에 대해서는 강제하여 사용할 수 있다.
         */

        Person p1 = new Student();
        p1.setName("홍길동");
        p1.setAge(23);
        p1.setGender('M');

        System.out.println(p1);
        System.out.println(p1.getFirstName());
        System.out.println(p1.getLastName());
    }
}
