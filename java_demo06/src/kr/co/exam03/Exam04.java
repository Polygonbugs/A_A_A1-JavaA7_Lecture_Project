package kr.co.exam03;

public class Exam04 {
    public static void main(String[] args) {
        FoodMenu food = new FoodMenu();

        food.addFood("a1", 1500);
        food.addFood("a2", 2500);
        food.addFood("a3", 5520);
        food.addFood("a4", 3000);

        food.printMenu();

        System.out.println("a2 가격 : " + food.findFood("a2"));

        food.updateFood("a3", 5500);

        food.printMenu();

        food.deleteFood("a2");

        food.printMenu();

        FoodMenu_ans food2 = new FoodMenu_ans();
        food2.add("만두", 4500);
        food2.add("김밥", 4000);
        food2.add("라면", 3500);
        System.out.println(food2.show());

    }
}
