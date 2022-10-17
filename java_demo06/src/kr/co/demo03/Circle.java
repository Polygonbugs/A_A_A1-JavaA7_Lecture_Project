package kr.co.demo03;

public class Circle {
    //private final double PI = 3.14; // 상수 필드

    public static final double PI = 3.14;   // 클래스 변수(정적 변수) : 공유자원
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return this.radius;
    }

    public double getArea() {
        return this.radius * this.radius * Circle.PI;
    }

}
