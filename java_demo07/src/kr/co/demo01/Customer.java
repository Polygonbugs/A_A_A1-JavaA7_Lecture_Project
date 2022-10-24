package kr.co.demo01;

public class Customer extends Person {
    private int id;
    private int point;

    public Customer(String name) {
        super(name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
