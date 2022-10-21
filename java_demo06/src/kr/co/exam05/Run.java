package kr.co.exam05;

import java.util.Scanner;

public class Run {

    private Scanner sc = new Scanner(System.in);
    private Student student;

    public Run() {
        this.student = new Student("홍길동");
        this.student.addSubject("국어", 67.9);
        this.student.addSubject("영어", 77.7);
        this.student.addSubject("수학", 84.5);
    }

    private String initMenu() {
        String menu = "";

        menu += "1. 성적표 출력\n";
        menu += "2. 과목 성적 출력\n";
        menu += "3. 과목 성적 추가\n";
        menu += "4. 과목 성적 수정\n";
        menu += "5. 과목 성적 삭제\n";
        menu += "6. 프로그램 종료\n";

        return menu;
    }

    private void select(int number) {
        switch(number) {
            case 1:
                this.printAll(); break;
            case 2:
                this.print(); break;
            case 3:
                this.add(); break;
            case 4:
                this.update(); break;
            case 5:
                this.remove(); break;
            case 6:
                System.out.println("프로그램을 종료 합니다.");
                System.exit(0);
        }
    }

    private void printAll() {
        String s = this.student.getGradeTable(this.student);
        System.out.println(s);
    }

    private void print() {

    }

    private void add() {
        while(true) {
            System.out.print("추가할 과목명 : ");
            String subjectName = sc.nextLine();

            System.out.print("성적 입력(0 ~ 100) : ");
            int score = sc.nextInt();

            if(!subjectName.equals("exit")) {
                student.addSubject(subjectName, score);
            } else {
                System.out.println("추가 작업을 마칩니다");
                break;
            }
        }
    }

    private void update() {}

    private void remove() {
        while(true) {
            System.out.print("삭제 할 과목명 : ");
            String subjectName = sc.nextLine();

            if(!subjectName.equals("exit")) {
                this.student.removeSubject(subjectName);
            } else {
                System.out.println("삭제 작업을 마칩니다.");
                break;
            }
        }

    }

    public void start() {
        while(true) {
            System.out.println(this.initMenu());
            System.out.print("메뉴 번호 입력 : ");
            int number = sc.nextInt();	sc.nextLine();
            this.select(number);

            System.out.print("초기 메뉴로 돌아가려면 Enter 입력!");
            sc.nextLine();
        }
    }

}