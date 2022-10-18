package kr.co.exam03;

public class Exam02 {
    public static void main(String[] args) {
        Speaker speaker1 = new Speaker(70, true, false);

        speaker1.turnMute();
        speaker1.turnPower();
        speaker1.upVolume();
        speaker1.upVolume();
        speaker1.upVolume();
        speaker1.downVolume();
        speaker1.downVolume();
        speaker1.showState();

    }
}
