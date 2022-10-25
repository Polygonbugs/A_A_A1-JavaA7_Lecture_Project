package kr.co.demo03;

import java.util.Objects;

public class Customer extends Person {
    private double discount = 0.03;

    public double getDiscount() {
        return discount;
    }

    public Customer() {}

    public Customer(String name) {
        this.setName(name);
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "discount=" + discount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Customer customer = (Customer) o;
        return Double.compare(customer.discount, discount) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(discount);
    }
}
