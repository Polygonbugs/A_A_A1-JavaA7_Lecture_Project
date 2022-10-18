package kr.co.exam03;

public class Exam03 {
    public static void main(String[] args) {
        Elevator e1 = new Elevator(4, 20, 1);
        Elevator e2 = new Elevator(4, 20);

        e1.moveFloor(5);
        e2.moveFloor(0);

        System.out.println("-------------");

        Elevator_ans e3 = new Elevator_ans(10);
        Elevator_ans e4 = new Elevator_ans(-5, 10);

        e3.move(5);
        e3.move(2);

        e4.move(5);
        e4.move(-2);
        e4.move(0);
    }
}
