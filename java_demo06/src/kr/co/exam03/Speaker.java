package kr.co.exam03;

public class Speaker {
    // 멤버변수 : 음량, 음소거상태유무, 전원상태
    // 멤버메서드 : 음량키움, 음량줄임, 음소거 on/off, 전원 on/off, 현재상태정보

    /*
     *      - 스피커는 기본 생성자 및 매개변수가 있는 생성자를 사용할 수 있어야 한다.
     *        (매개변수는 다양한 조합의 매개변수로 사용할 수 잇어야 한다)
     *      - 음량을 키우면 현재 음량값에서 +5씩 증가시킨다.
     *      - 음량을 줄이면 현재 음량값에서 -5씩 감소시킨다.
     *      - 음량은 0 ~ 100까지 변화한다.
     *      - 음소거 on/off는 현재 상태가 on이면 off로 off면 on으로 전환시킨다.
     *      - 전원 on/off는 현재 상태가 on이면 off로 off면 on으로 전환시킨다.
     *      - 현재상태정보는 현재 스피커의 상태가 음소거인지 전원이 켜져 있는지 음량은
     *        얼마인지를 알 수 있도록 정보를 제공하는 기능이다.
     *        (전원이 off인 경우 "전원 OFF"라고만 제공한다. 전원이 on이고 음소거가 on이면 "음소거" 라고만
     *         제공한다. 전원이 on이고 음소거가 off면 "음량 50"으로 제공한다.)
     */

    private int soundVolume;
    private boolean isMute;
    private boolean isPower;

    public Speaker() {}

    public Speaker(int soundVolume, boolean isMute, boolean isPower) {
        if(soundVolume >= 0 && soundVolume <= 100) {
            this.soundVolume = soundVolume;
        } else {
            System.out.println("음량값이 이상합니다. 0 ~ 100 사이를 입력해주세요");
            System.out.println("50으로 설정합니다");
            this.soundVolume = 50;
        }

        this.isMute = isMute;
        this.isPower = isPower;
    }

    public void upVolume() {
        if(this.soundVolume + 5 >= 100) {
            return;
        }
        this.soundVolume += 5;
    }

    public void downVolume() {
        if(this.soundVolume - 5 <= 0) {
            return;
        }
        this.soundVolume -= 5;
    }

    public void turnMute() {
        if(!this.isMute) {
            this.isMute = true;
        } else {
            this.isMute = false;
        }
    }

    public void turnPower() {
        if(!this.isPower) {
            this.isPower = true;
        } else {
            this.isPower = false;
        }
    }

    public void showState() {
        if(!isPower) {
            System.out.println("전원 OFF");
        } else if(isPower && isMute) {
            System.out.println("음소거 On");
        } else if (isPower && !isMute){
            System.out.printf("음량 : %d\n", soundVolume);
        }
    }
}
