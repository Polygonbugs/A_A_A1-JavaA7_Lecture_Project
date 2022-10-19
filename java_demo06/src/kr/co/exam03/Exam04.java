package kr.co.exam03;

import java.util.Scanner;

public class Exam04 {
    public static void main(String[] args) {
        FoodMenu food = new FoodMenu();

        food.addFood("a1", 1500);
        food.addFood("a2", 2500);
        food.addFood("a3", 5520);
        food.addFood("a4", 3000);

        food.printMenu();

        System.out.println("a2 가격 : " + food.findFood("a2"));

        food.updateFood("a3", 0);

        food.printMenu();

        food.deleteFood("a3");

        food.printMenu();

        System.out.println("-----------------------------");

        FoodMenu_ans food2 = new FoodMenu_ans();
        food2.add("만두", 4500);
        food2.add("김밥", 4000);
        food2.add("라면", 3500);
        System.out.println(food2.show());

        Scanner sc = new Scanner(System.in);

        //System.out.print("메뉴명을 입력하세요 : ");
        //String menuName = sc.nextLine();
        String menuName = "돈까스";

        if(food2.find(menuName) != -1) {
            System.out.println(menuName + "메뉴의 가격은 " + food2.find(menuName) + "원 입니다.");
        } else {
            System.out.println("해당하는 메뉴가 없습니다.");
        }

        //System.out.print("수정할 메뉴명을 입력하세요 : ");
        //String menuName2 = sc.nextLine();
        String menuName2 = "김밥";
        int price = 4500;

        //System.out.print("가격 입력 : ");
        //int price = sc.nextInt();

        boolean result = food2.update(menuName2, price);

        if(result) {
            System.out.println("수정되었습니다.");
        } else {
            System.out.println("해당하는 메뉴가 없습니다.");
        }

        System.out.println(food2.show());

    }
}
