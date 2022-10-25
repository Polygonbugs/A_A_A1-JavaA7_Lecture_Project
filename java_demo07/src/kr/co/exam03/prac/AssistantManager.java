package kr.co.exam03.prac;

public class AssistantManager extends Person{
    public AssistantManager(String name, int age, String rank) {
        super(name, age, rank);
    }

    public void reviewDocument(Staff staff) {
        System.out.printf("%s %s가 %s %s가 작성한 문서를 검토합니다", super.getRank(), super.getName(), staff.getRank(), staff.getName());
    }
}
