package kr.co.demo05;

public class Demo {
    public static void main(String[] args) {
        /*
         *  인터페이스
         *      추상 클래스처럼 미완성된 클래스라고 볼 수 있으나
         *      다른점은 모든 메서드가 추상 메서드이고 멤버 변수는
         *      오직 상수만을 가질 수 있다.
         *
         *  - 모든 메서드는 암묵적으로 public abstract 이다.
         *  - 멤버 변수는 암묵적으로 public static final 이다.
         *  - 참조 타입으로만 사용할 수 있으며, 객체 생성에는 사용할 수 없다.
         *  - implements 키워드를 사용하여 적용한다.
         *  - 1개 이상의 인터페이스를 implements 할 수 있다.
         */
        Person[] pArr = new Person[2];
        pArr[0]= new MemberUser();
        pArr[1]= new MemberStaff();

        pArr[0].setName("홍길동");
        pArr[1].setName("김아현");

        for(int i = 0; i < pArr.length; i++) {
            System.out.println(pArr[i]);
            if(pArr[i] instanceof Staff) {
                Staff s = (Staff)pArr[i];
                s.notice();
                s.block();
                s.write();
                s.view();
                s.update();
                s.remove();
            } else if(pArr[i] instanceof Member) {
                Member m = (Member)pArr[i];
                m.write();
                m.view();
                m.update();
                m.remove();
            }
        }

    }
}
