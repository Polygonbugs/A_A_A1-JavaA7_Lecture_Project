package kr.co.exam03;

public class Elevator {
    /*
     *      Elevator 클래스
     *      멤버변수 : 현재층, 최소층, 최대층, 이동층
     *      멤버메서드 : 이동
     *
     *      - 엘리베이터는 최대층 또는 최소층 + 최대층을 설정하여 이 엘리베이터가
     *        몇층부터 몇층까지 운용할 수 있는지에 대한 정보로 초기화한다.
     *      - 5층으로 이동하게 되면, 현재층과 비교하여 "현재층에서 5층으로 올라갑니다." 또는
     *        "현재층에서 5층으로 내려갑니다." 가 출력되야 한다.
     *      - 최소층, 최대층 범위를 벗어난 이동이 발생하는 경우 무조건 1층으로 이동한다.
     */

    private int currentFloor;
    private int minFloor;
    private int maxFloor;
    private int targetFloor;

    public Elevator(int currentFloor, int maxFloor) {
        this(currentFloor, maxFloor, 1);
    }
    public Elevator(int currentFloor, int maxFloor, int minFloor) {
        this.setCurrentFloor(currentFloor);
        this.setMaxFloor(maxFloor);
        this.setMinFloor(minFloor);
    }

    private void setCurrentFloor(int currentFloor){
        if(currentFloor < 0) {
            this.minFloor = 1;
        }
        this.currentFloor = currentFloor;
    }

    private void setMinFloor(int minFloor){
        if(minFloor < 0) {
            this.minFloor = 2;
        }
        this.minFloor = minFloor;
    }

    private void setMaxFloor(int maxFloor){
        if(maxFloor < 0) {
            this.maxFloor = 5;
        }
        this.maxFloor = maxFloor;
    }

    public void moveFloor(int targetFloor) {
        this.targetFloor = targetFloor;

        if(this.targetFloor >= this.minFloor && this.targetFloor <= this.maxFloor) {
            if(this.currentFloor > this.targetFloor) {
                System.out.printf("현재층에서 %d층으로 내려갑니다\n", this.targetFloor);
                this.currentFloor = this.targetFloor;
            } else if (this.currentFloor == this.targetFloor) {
                System.out.println("현재층과 동일한 층입니다. 다시 입력해주세요");
            } else {
                System.out.printf("현재층에서 %d층으로 올라갑니다\n", this.targetFloor);
                this.currentFloor = this.targetFloor;
            }
        } else {
            System.out.println("최소층, 최대층 범위를 벗어난 이동이 발생했습니다");
            System.out.println("1층으로 이동합니다");
            this.currentFloor = 1;
        }
    }


}
