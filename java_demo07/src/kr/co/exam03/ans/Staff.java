package kr.co.exam03.ans;

public class Staff extends Intern{
    public Staff() {
        role = "사원";
    }

    public Staff(String name, int age) {
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

    public void care() {
        String message = String.format("%s이(가) 인턴을 관리 합니다.", role);
        System.out.println(message);
    }

    @Override
    public Employee elevate() {
        return new Senior(getName(), getAge());
    }

    @Override
    public Employee degrement() {
        return new Employee(getName(), getAge());
    }
}
