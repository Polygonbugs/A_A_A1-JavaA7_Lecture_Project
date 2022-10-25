package kr.co.exam03.prac;

public class Staff extends Person {
    public Staff(String name, int age, String rank) {
        super(name, age, rank);
    }

    public void addressIntern() {
        System.out.printf("%s %s가 인턴을 봐줍니다.", super.getRank(), super.getName());
    }
}
