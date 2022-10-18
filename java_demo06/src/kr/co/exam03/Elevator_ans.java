package kr.co.exam03;

public class Elevator_ans {
    private int floor = 1;
    private int min;
    private int max;
    private int target;
    private String state;

    public Elevator_ans(int max) {
        this.max = max;
    }

    public Elevator_ans(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public void move(int target) {
        this.state = this.floor < target ? "올라" : "내려";
        this.target = target;

        if(this.floor == target) {
            System.out.println("이미 " + this.floor + "층 입니다.");
        } else {
            if(min <= target && max >= target && target != 0) {
                System.out.println(this.floor + " 층에서 " + target + " 층으로 " + this.state + "갑니다.");
                this.floor = target;
            } else {
                System.out.println(this.floor + "층에서 1층으로 " + this.state + "갑니다.");
                this.floor = 1;
                this.target = 1;
            }
        }
    }
}
