package kr.co.exam;

public class Exam01 {
    public static void main(String[] args) {
        /*
         *      펜(Pen) 객체를 클래스로 만들어 보시오.
         */
        Pen p1 = new Pen();
        p1.color = "black";
        p1.ballSize = .5;
        p1.type = "ink";

        /*
         *      신발(Shoes) 객체를 클래스로 만들어 보시오.
         */
        Shoes s1 = new Shoes();
        s1.brand = "Nike";
        s1.size = 270;
        s1.type = "운동화";
        s1.color = "white";

    }
}
