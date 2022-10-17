package kr.co.exam02;

public class Triangle_ans {
    double width;
    double height;
    double round;
    double area;

    public Triangle_ans(double width) {
        this.width = width;
        this.height = width;
        this.round = width + (Math.sqrt((width / 2) * (width / 2) + (width * width))) * 2;
        this.area = width * width / 2;
    }

    public Triangle_ans(double width, double height) {
        this.width = width;
        this.height = height;
        this.round = width + height + (Math.sqrt((width * width) + (height * height) + width + height)) * 2;
        this.area = width * width / 2;
    }

    public double getWidth() {
        return this.width;
    }

    public double getHeight() {
        return this.height;
    }

    public double getRound() {
        return this.round;
    }

    public double getArea() {
        return this.area;
    }
}
