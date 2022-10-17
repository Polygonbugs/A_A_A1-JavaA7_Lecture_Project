package kr.co.demo;

public class SmartPhone {
    private String model;
    private String brand;
    private String number;

    public void setModel(String model) {
        this.model = model;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getModel() {
        return this.model;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getNumber() {
        String num = this.number.substring(0, 9);
        return num + "xxxx";
    }
}
