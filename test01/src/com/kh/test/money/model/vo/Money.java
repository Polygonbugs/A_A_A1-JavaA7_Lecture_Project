package com.kh.test.money.model.vo;

public class Money {
    public static String UNIT = "원";
    private int money;

    public Money(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public static String getUnit() {
        return UNIT;
    }

    public static void setUnit(String UNIT) {
        Money.UNIT = UNIT;
    }

    public void print() {
        System.out.println(money + UNIT + "이 있습니다");
    }
}
