package kr.co.exam03.ans;

public class Senior extends Employee{
    public Senior() {
        role = "대리";
    }

    public Senior(String name, int age) {
        this();
        setName(name);
        setAge(age);
    }

    public void research() {
        String message = String.format("%s이(가) 자료 조사를 합니다.", role);
        System.out.println(message);
    }

    public void document() {
        String message = String.format("%s이(가) 문서 작성을 합니다.", role);
        System.out.println(message);
    }

    public void call() {
        String message = String.format("%s이(가) 업체와 통화를 합니다.", role);
        System.out.println(message);
    }
}
