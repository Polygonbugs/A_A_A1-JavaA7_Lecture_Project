package kr.co.exam02;

public class Triangle {
    private int base;
    private int height;
    private double area;
    private double perimeter;

    public Triangle(int base) {
        this.base = base;
    }

    public Triangle(int base, int height) {
        this.base = base;
        this.height = height;

        this.area = this.base * this.height * 0.5;
        this.perimeter = 2 * Math.sqrt(0.25 * this.base * this.base + height * height) + this.base;
    }

    public int getBase() {
        return this.base;
    }

    public int getHeight() {
        return this.height;
    }

    public double getArea() {
        return this.area;
    }

    public double getPerimeter() {
        return this.perimeter;
    }
}
