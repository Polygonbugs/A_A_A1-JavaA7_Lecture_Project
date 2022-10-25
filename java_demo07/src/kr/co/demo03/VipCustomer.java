package kr.co.demo03;

import java.util.Objects;

public class VipCustomer extends Person {
    private double discount = 0.08;
    private int point = 10000;

    public VipCustomer() {

    }

    public VipCustomer(String name) {
        this.setName(name);
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "VipCustomer{" +
                "discount=" + discount +
                ", point=" + point +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        VipCustomer that = (VipCustomer) o;
        return Double.compare(that.discount, discount) == 0 && point == that.point;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), discount, point);
    }
}
