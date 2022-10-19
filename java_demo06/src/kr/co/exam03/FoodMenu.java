package kr.co.exam03;

import java.util.Arrays;
import java.util.Scanner;

public class FoodMenu {
    /*
     *      FoodMenu 클래스
     *      - 멤버 변수 : 음식명(배열), 음식가격(배열)
     *      - 멤버 메서드 : 메뉴출력, 음식찾기, 음식추가, 음식수정, 음식삭제
     *
     *      - 음식메뉴 클래스는 기본 생성자만을 가지고 사용한다.
     *      - 멤버변수의 음식명과 음식가격의 배열은 동일한 인덱스 번호로 묶어서 사용한다.
     *        (음식명 배열에서 0위치의 음식은 음식가격 배열에서 0위치의 가격이 된다.)
     *      - 메뉴출력은 모든 음식명과 가격이 출력될 수 있도록 문자열을 만들어주는 메서드이다.
     *      - 음식찾기는 음식명을 입력하면 음식명(배열)에서 동일한 음식을 찾고 이와 대응하는 가격을
     *         알려 주기 위한 용도의 메서드이다.
     *      - 음식추가는 음식명과 가격을 입력하면 기존 배열에 음식 정보를 추가해 주기위한 메서드이다.
     *      - 음식수정은 음식명과 가격을 입력하면 기존 배열에 저장된 음식 정보를 찾아 가격을 수정해 주기 위한
     *        매서드이다.
     *      - 음식삭제는 음식명을 입력하면 기존 배열에 저장된 음식 정보를 찾아 음식명과 가격을 삭제해 주기 위한 메서드이다.
     */

    // 가변길이 배열 사용해야 함.

    // 멤버변수
    private String[] name = new String[0];
    private int[] price = new int[0];

    // 생성자

    // 멤버함수(메서드)

    public void addFood(String name, int price) {
        this.name = Arrays.copyOf(this.name, this.name.length + 1);
        this.name[this.name.length - 1] = name;

        this.price = Arrays.copyOf(this.price, this.price.length + 1);
        this.price[this.price.length - 1] = price;
    }


    public int findFood(String name) {
        int cnt = 0;
        for(int i = 0; i < this.name.length; i++) {
            if(this.name[i].equals(name)) {
                cnt = i;
            }
        }
        return this.price[cnt];
    }

    public void printMenu() {
        System.out.println("음식명 리스트 :   " + Arrays.toString(name));
        System.out.println("음식가격 리스트 : " + Arrays.toString(price));
    }

    public void updateFood(String name, int new_price) {
        int cnt = 0;
        for(int i = 0; i < this.name.length; i++) {
            if(this.name[i].equals(name)) {
                cnt = i;
            }
        }

        this.price[cnt] = new_price;
    }

    public void deleteFood(String name) {
        int cnt = 0;
        for(int i = 0; i < this.name.length; i++) {
            if(this.name[i].equals(name)) {
                cnt = i;
            }
        }
        String[] name_tmp;
        int[] price_tmp;
        int name_cnt = 0;
        int price_cnt = 0;

        name_tmp = Arrays.copyOf(this.name, this.name.length);

        for(int i = 0; i < name_tmp.length; i++) {
            if(name_tmp[i].equals(name)) {
                name_cnt = i;
            }
        }

        for(int i = name_cnt; i < name_tmp.length; i++) {
            if(i + 1 < name_tmp.length) {
                name_tmp[i] = name_tmp[i + 1];
            }
        }

        name_tmp = Arrays.copyOf(name_tmp, name_tmp.length - 1);

        this.name = name_tmp;

        //

        price_tmp = Arrays.copyOf(this.price, this.price.length);

        for(int i = name_cnt; i < price_tmp.length; i++) {
            if(i + 1 < price_tmp.length) {
                price_tmp[i] = price_tmp[i + 1];
            }
        }


        price_tmp = Arrays.copyOf(price_tmp, price_tmp.length - 1);

        this.price = price_tmp;


    }
}
