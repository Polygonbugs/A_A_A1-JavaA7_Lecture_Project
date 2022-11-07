import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String str = "Apple, Kiwi, Strawberry, Banana";
        String[] strArr;
        strArr = str.split(",");
        for(int i = 0; i < strArr.length; i++) {

            System.out.println(strArr[i]);
        }
        //System.out.println(strArr[5]);

        double s = Double.parseDouble("13.45");
        System.out.printf("%.1f", s);

        Scanner sc = new Scanner(System.in);

        System.out.print("num1 값 입력 : ");
        int num1 = sc.nextInt();
        System.out.print("num2 값 입력 : ");
        int num2 = sc.nextInt();

        try {
            System.out.println("두 수의 나눗셈 결과 : " + num1 / num2);
        } catch(ArithmeticException e) {
            // Infinity : "/" 연산 우측에 있는 피연산자의 값이 0 또는 0.0 이면 무한대의 값을 가지게 되므로 예외처리 한다.
            System.err.println("부적절한 나눗셈을 시도하였습니다.");
        }


    }
}