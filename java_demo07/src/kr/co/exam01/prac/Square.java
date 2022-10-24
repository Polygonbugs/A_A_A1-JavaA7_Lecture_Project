package kr.co.exam01.prac;

public class Square extends Figure{
    public Square(int width, int length) {
        super(width, length);
    }

    public double calArea() {
        double area = 0.0;
        area = getWidth() * getLength();
        return area;
    }
}
