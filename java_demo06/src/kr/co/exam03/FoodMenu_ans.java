package kr.co.exam03;

import java.util.Arrays;

public class FoodMenu_ans {
    private String name[] = new String[0];
    private int price[] = new int[0];

    public String show() {
        // 모든 메뉴를 출력하기 위한 메서드
        String res = "";
        for(int i = 0; i < name.length; i++) {
            res += String.format("%s,\t%d원\n", name[i], price[i]);
        }

        return res;
    }

    public int find(String name) {
        // 메뉴를 찾아서 가격을 반환하기 위한 메서드

        return 0;
    }

    public void add(String name, int price) {
        // 메뉴를 추가하기 위한 메서드
        this.name = Arrays.copyOf(this.name, this.name.length + 1);
        this.name[this.name.length - 1] = name;

        this.price = Arrays.copyOf(this.price, this.price.length + 1);
        this.price[this.price.length - 1] = price;
    }

    public void update(String name, int price) {
        // 메뉴를 찾아 가격을 수정하기 위한 메서드
    }

    public void remove(String name) {
        // 메뉴를 찾아 삭제하기 위한 메서드
    }


}
