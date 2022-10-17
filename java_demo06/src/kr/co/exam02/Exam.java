package kr.co.exam02;

public class Exam {
    public static void main(String[ ] args) {
        /*
         *  삼각형, 사각형 클래스를 만들고 각 도형의 넓이와
         *  둘레를 구할 수 있도록 만드세요
         *
         *  1. 두 클래스의 생성자는 밑변 정보만 받아서 생성하는 생성자와
         *      밑변과 높이 정보를 받아서 생성하는 생성자로 만드세요
         *
         *  2. 생성자로 만들어진 삼각형, 사각형 인스턴스는 넓이와 둘레가
         *     바로 초기화되어 각 멤버필드에 저장될 수 있도록 하세요.
         *
         *  3. getter 메서드만을 만들어서 밑변, 높이, 넓이, 둘레 정보만
         *     사용할 수 있도록 하세요.
         */

        Triangle tri = new Triangle(3, 4);
        Square sqr = new Square(3, 4);

        System.out.printf("삼각형 밑변 길이 : %d\n", tri.getBase());
        System.out.printf("삼각형 높이 : %d\n", tri.getHeight());
        System.out.printf("삼각형 넓이 : %.1f\n", tri.getArea());
        System.out.printf("삼각형 둘레 : %.1f\n\n", tri.getPerimeter());

        System.out.printf("사각형 밑변 길이 : %d\n", sqr.getBase());
        System.out.printf("사각형 높이 : %d\n", sqr.getHeight());
        System.out.printf("사각형 넓이 : %d\n", sqr.getArea());
        System.out.printf("사각형 둘레 : %d", sqr.getPerimeter());


    }
}
