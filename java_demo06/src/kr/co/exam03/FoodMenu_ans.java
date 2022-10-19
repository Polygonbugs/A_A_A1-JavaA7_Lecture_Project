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

    /**
     * name 매개변수에 전달된 문자열에 해당하는 메뉴를 찾아
     * 그 가격을 반환하는 메서드로 메뉴를 찾아서 가격을 반환하기 위한 메서드
     * 만약 해당하는 메뉴가 없으면 -1을 반환.
     * @param
     *  name : 메뉴명
     * @return : 메뉴에 대한 가격을 반환
     */

    public int find(String name) {
        int idx = this.findIndex(name);
        int price = -1;
        if(idx != -1) {
            price = this.price[idx];
        }
        return price;
    }

    /**
     *
     * @param name
     * @return
     */
    private int findIndex(String name) {
        // 메뉴를 찾아서 찾은 메뉴의 위치(Index)를 반환하기 위한 메서드
        int idx = -1;       // 못찾으면 오류낼려고 이렇게 둔 것이다.
        for(int i = 0; i < this.name.length; i++) {
            if(this.name[i].equals(name)) {
                idx = i;
                break;
            }
        }
        return idx;
    }

    /**
     *
     * @param name
     * @param price
     */
    public void add(String name, int price) {
        // 메뉴를 추가하기 위한 메서드
        this.name = Arrays.copyOf(this.name, this.name.length + 1);
        this.name[this.name.length - 1] = name;

        this.price = Arrays.copyOf(this.price, this.price.length + 1);
        this.price[this.price.length - 1] = price;
    }

    /**
     * name에 해당하는 메뉴를 찾아서 price 가격으로 수정을 하는 메서드.
     * name에 해당하는 메뉴를 찾아서 수정한 경우 true 반환
     * name에 해당하는 메뉴가 없는 경우 false를 반환
     * @param name 가격을 수정할 메뉴명
     * @param price 수정할 가격
     * @return
     *  true : 메뉴를 찾아서 가격 수정함<br>
     *  false : 메뉴가 없어서 수정 못함
     */
    public boolean update(String name, int price) {
        // 메뉴를 찾아 가격을 수정하기 위한 메서드

        int idx = this.findIndex(name);
        if(idx != -1) {
            this.price[idx] = price;
            return true;
        }

        return false;
    }

    public void remove(String name) {
        // 메뉴를 찾아 삭제하기 위한 메서드
    }


}
