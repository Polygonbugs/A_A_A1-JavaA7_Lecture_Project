package kr.co.exam03.ans;

public class Exam {
    public static void main(String[] args) {
        /*
         * 직원을 관리하기 위한 프로그램을 만들기 위해 다음의 객체 정보가 필요하다.
         *     - 인턴 : 출근하여 하는 일은 서류정리 및 자료복사 이다.
         *     - 사원 : 출근하여 하는 일은 자료조사, 문서작성, 인턴봐주기 이다.
         *     - 대리 : 출근하여 하는 일은 자료조사, 문서작성, 업체와의통화,
         *             사원이작성한문서검토 이다.
         *     - 과장 : 출근하여 하는 일은 업체미팅, 외부출장, 업체와의통화 이다.
         *
         * 모든 객체는 이름, 나이 정보를 가지고 있으며 각 객체마다 기본적으로
         * 출근 및 퇴근, 점심, 야근을 수행한다.
         *
         * 위 관계를 파악하여 클래스의 상속, 오버로딩, 오버라이딩, 다형성을
         * 활용해본다.
         */
        Employee e1 = new Intern("홍길동", 24);
        Employee e2 = new Staff("박수원", 27);
        Employee e3 = new Senior("최정원", 30);
        Employee e4 = new Manager("박고현", 35);

        System.out.println(e1);
        System.out.println(e2);
        System.out.println(e3);
        System.out.println(e4);

        Employee emps[] = new Employee[4];
        emps[0] = e1; emps[1] = e2;
        emps[2] = e3; emps[3] = e4;

        for(int i = 0; i < emps.length; i++) {
            emps[i].night();
        }
    }
}
