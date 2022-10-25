package kr.co.demo01;

public class Person {
    private String name;        // 자식이 private 속성까지 쓸 수 있는 것은 아니다.
    private int age;
    private char gender;

    public Person(String name) {    // 상위 클래스에 매개변수가 있는 생성자를 만들면
                                    // 하위 클래스에서 기본 생성자를 사용할 수 없다.
        this.name = name;
    }

    //public Person() {}        // 기본 생성자를 명시하면 자식에서도 생성자 없이 사용이 가능하다.

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }
}
