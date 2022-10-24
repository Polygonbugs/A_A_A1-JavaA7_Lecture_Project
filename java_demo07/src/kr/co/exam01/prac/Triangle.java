package kr.co.exam01.prac;

public class Triangle extends Figure {
    public Triangle(int width, int length) {
        super(width, length);
    }

    public double calArea() {
        double area = 0.0;
        area = getWidth() * getLength() * 0.5;
        return area;
    }


}
