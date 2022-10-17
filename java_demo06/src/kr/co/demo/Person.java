package kr.co.demo;

public class Person {
        //멤버 변수(field)
        //생성자를 쓰지 않으면 기본값으로 초기화 되어있다.
        String name;
        int age;
        char gender;
        String phone;
        private String personId;
        String address;

        // 기본 생성자 : 클래스를 만들면 기본적으로 사용되는 생성자.
        //               별도의 생성자를 구현하지 않으면 기본 생성자를
        //               작성하지 않아도 사용된다.
        public Person() {}

        /*
         *  매개변수가 있는 생성자(Constructor)
         *      매개변수가 있는 생성자가 있으면 기본 생성자를 별도로 구현
         *      하지 않을 시 사용할 수 없다.
         */
        public Person(String name) {
                this.name = name;
        }

        public Person(String name, int age) {
                this.name = name;
                this.age = age;
        }

        public Person(String name, int age, char gender) {
                this.name = name;
                this.age = age;
                this.gender = gender;
        }
}
