package kr.co.exam02;

public class Square {
    private int base;
    private int height;
    private int area;
    private int perimeter;

    public Square(int base) {
        this.base = base;
    }

    public Square(int base, int height) {
        this.base = base;
        this.height = height;

        this.area = base * height;
        this.perimeter = 2 * (base + height);
    }

    public int getBase() {
        return this.base;
    }

    public int getHeight() {
        return this.height;
    }

    public int getArea() {
        return this.area;
    }

    public int getPerimeter() {
        return this.perimeter;
    }
}
