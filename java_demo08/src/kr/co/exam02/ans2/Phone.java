package kr.co.exam02.ans2;

public class Phone {
    private String number;
    private boolean valid;

    private Phone(String phone) {
        this.check(phone);
    }

    public boolean isValid() {
        return this.valid;
    }

    public String getNumber() {
        return this.number;
    }

    /**
     * 설명 : 전화번호를 문자열로 반환하는 메서드
     * @param hidden
     *      true : 전화번호 마지막 4자리 숫자를 *로 숨김처리합니다.
     *      false : 숨김처리 하지 않은 전화번호를 반환합니다.
     * @return
     * String : 숨김처리가 된 혹은 숨김처리가 안된 전화번호 형식의 문자열
     */
    public String getNumber(boolean hidden) {
        if(this.valid) {
            if(hidden) {
                return this.number.substring(0, 9) + "****";
            }
        }
        return this.getNumber();
    }

    private void check(String phone) {

        if(!phone.startsWith("010")) {
            System.out.println("010 으로 시작해야 합니다.");
            return;
        }

        if(phone.length() != 13) {
            System.out.println("하이픈(-) 을 포함한 13 자리 번호를 입력하세요.");
            return;
        }

        if(phone.split("-").length != 3) {
            System.out.println("올바른 전화번호 형식이 아닙니다.");
            return;
        }

        String phoneArr[] = phone.split("-");

        for(int i = 1; i < phoneArr.length; i++) {
            for(int j = 0; j < phoneArr[i].length(); j++) {
                if(!(phoneArr[i].charAt(j) >= '0' && phoneArr[i].charAt(j) <= '9')) {
                    System.out.println("0 ~ 9 에 해당하는 숫자가 아닙니다.");
                    return;
                }
            }
        }

        for(int i = 1; i < phoneArr.length; i++) {
            if (phoneArr[i].length() != 4) {
                System.out.println("전화번호는 2번째 3번째 숫자가 4자리 여야 합니다.");
                return;
            }
        }

        this.number = phone;
        this.valid = true;
    }

    public static Phone valueOf(String phone) {
        return new Phone(phone);
    }
}
