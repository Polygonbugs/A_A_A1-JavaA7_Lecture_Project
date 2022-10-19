package kr.co.demo04;

import java.util.Scanner;

public class Demo01 {
    public static void main(String[] args) {
        FoodMenu_Obj food = new FoodMenu_Obj();
        food.add("만두", 4500);
        food.add("김밥", 4000);
        food.add("라면", 3500);
        System.out.println(food.show());

        Scanner sc = new Scanner(System.in);

        //System.out.print("메뉴명을 입력하세요 : ");
        //String menuName = sc.nextLine();
        String menuName = "돈까스";

        if(food.find(menuName) != -1) {
            System.out.println(menuName + "메뉴의 가격은 " + food.find(menuName) + "원 입니다.");
        } else {
            System.out.println("해당하는 메뉴가 없습니다.");
        }

        //System.out.print("수정할 메뉴명을 입력하세요 : ");
        //String menuName2 = sc.nextLine();
        String menuName2 = "김밥";
        int price = 4500;

        //System.out.print("가격 입력 : ");
        //int price = sc.nextInt();

        boolean result = food.update(menuName2, price);

        if(result) {
            System.out.println("수정되었습니다.");
        } else {
            System.out.println("해당하는 메뉴가 없습니다.");
        }

        System.out.println(food.show());

        String menuName3;
        menuName3 = "김밥";
        result = food.remove(menuName3);
        if(result) {
            System.out.println("삭제되었습니다.");
        } else {
            System.out.println("해당하는 메뉴가 없습니다.");
        }
    }
}
