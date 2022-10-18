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

        Speaker_ans speaker2 = new Speaker_ans();
        Speaker_ans speaker3 = new Speaker_ans(50);
        Speaker_ans speaker4 = new Speaker_ans(50, true);
        Speaker_ans speaker5 = new Speaker_ans(50, true, true);

        speaker2.togglePower();
        speaker2.volumeUp();
        speaker2.volumeUp();
        speaker2.volumeUp();
        speaker2.volumeDown();
        speaker2.volumeDown();
        System.out.println(speaker2.getState());

    }
}
