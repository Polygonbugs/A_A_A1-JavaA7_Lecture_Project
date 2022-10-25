package kr.co.exam03.ans;

public class Senior extends Staff{
    public Senior() {
        role = "대리";
    }

    public Senior(String name, int age) {
        this();
        setName(name);
        setAge(age);
    }

    public void call() {
        String message = String.format("%s이(가) 업체와 통화를 합니다.", role);
        System.out.println(message);
    }

    @Override
    public Employee elevate() {
        return new Manager(getName(), getAge());
    }

    @Override
    public Employee degrement() {
        return new Staff(getName(), getAge());
    }
}
