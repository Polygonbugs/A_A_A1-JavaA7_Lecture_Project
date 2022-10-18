package kr.co.test;

import java.util.Random;

public class Lotto {
    /*
     *  멤버 변수 : 회차, 로또번호, 보너스
     *  멤버 메서드 : 번호생성, 번호확인
     *
     *  회차는 한 번 정해지면 변경할 수 없어야 한다.
     *  로또 번호는 1 ~ 46 사이의 번호 6개 + 보너스 번호가 생성되어야 한다.
     *  로또 번호는 번호생성을 통해서만 생성되어야 한다.
     *  모든 번호는 중복이 있어선 안된다.
     *  번호확인을 할 때에는 보너스 번호까지 확인할 수 있도록 해야 한다.
     */

    private final int round;
    private int[] lottoNumber = new int[6];
    private int bonusNumber;

    public Lotto(int round) {
        this.round = round;
    }

    public void createNumber() {
        Random rand = new Random();

        for(int i = 0; i < lottoNumber.length; i++) {
            lottoNumber[i] = rand.nextInt(45) + 1;
        }

        for(int i = 0; i + 1< lottoNumber.length; i++) {
            if(lottoNumber[i] == lottoNumber[i + 1]) {
                lottoNumber[i] = rand.nextInt(45) + 1;
            }
        }

        bonusNumber = rand.nextInt(45) + 1;

    }

    public String checkNumber() {
        String res = "";
        for(int i = 0; i < lottoNumber.length; i++) {
            res += String.format("%d\t", lottoNumber[i]);
        }

        res += "bonusNumber : " + bonusNumber;

        return res;
    }

}
