package kr.co.exam03.prac;

public class Manager extends Person {
    public Manager(String name, int age, String rank) {
        super(name, age, rank);
    }

    public void meetBusiness() {
        System.out.printf("%s %s가 업체미팅을 합니다.", super.getRank(), super.getName());
    }

    public void goBusinessTrip() {
        System.out.printf("%s %s가 외부출장을 합니다.", super.getRank(), super.getName());
    }
}
