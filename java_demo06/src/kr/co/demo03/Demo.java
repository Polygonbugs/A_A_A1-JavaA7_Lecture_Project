package kr.co.demo03;

public class Demo {
    public static void main(String[] args) {
        Circle c1 = new Circle(10);
        Circle c2 = new Circle(15);

        System.out.println(Circle.PI2);

        System.out.printf("%f\n", c1.getArea());
        System.out.printf("%f\n", c2.getArea());

    }
}
