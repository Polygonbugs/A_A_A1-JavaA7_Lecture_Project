package kr.co.exam03.ans;

import java.util.Objects;

public class Employee {
    private String name;
    private int age;
    protected String role;

    public void workOn() {
        String message = String.format("%s %s이(가) 출근하였습니다.", role, name);
        System.out.println(message);
    }

    public void workOff() {
        String message = String.format("%s %s이(가) 퇴근하였습니다.", role, name);
        System.out.println(message);
    }

    public void Lunch() {
        String message = String.format("%s %s이(가) 점심을 먹으러 갑니다.", role, name);
        System.out.println(message);
    }

    public void night() {
        String message = String.format("%s %s이(가) 야근을 합니다.", role, name);
        System.out.println(message);
    }

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

    @Override
    public String toString() {
        return "Employee [name=" + name + ", age=" + age + ", role=" + role + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name, role);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        return age == other.age && Objects.equals(name, other.name) && Objects.equals(role, other.role);
    }
}
