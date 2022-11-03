package kr.co.exam05.ans;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Run {
    private Scanner sc = new Scanner(System.in);
    private HashMap<Student, ArrayList<Subject>> datas = new HashMap<Student, ArrayList<Subject>>();

    public void printMenu() {
        String menu = "<<학생 성적 관리 프로그램>>\n"
                + "[1] 전체 학생 목록\n"
                + "[2] 성적 검색\n"
                + "[3] 성적 수정\n"
                + "[4] 프로그램 종료";

        System.out.println(menu);
    }

    public void load() {        // 파일을 읽어오면 Run class(이 클래스)의 HashMap 필드에 저장된다.
        File f = new File("/Users/houstonjustin/Documents/A.Project/A_A_A1-Lecture-Project/test/학생성적정보관리2.info");

        try(BufferedReader br = new BufferedReader(new FileReader(f))) {
            while(br.ready()) {
                this.parse(br.readLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void parse(String rowData) {
        // private HashMap<Student, ArrayList<Subject>> datas = new HashMap<Student, ArrayList<Subject>>();
        // rowData = "홍길동,1,2,25:영어=78.5,수학=84.7,국어=96.5"

        String sArr[] = rowData.split(":");             // Key와 Value 나누기
        String[] studentData = sArr[0].split(",");      // Student class의 member 나누기
        String[] subjectData = sArr[1].split(",");      // 각 Subject 항목 나누기

        Student student = new Student(studentData[0],           // Student 객체에 member 집어 넣기
                Integer.parseInt(studentData[1]),
                Integer.parseInt(studentData[2]),
                Integer.parseInt(studentData[3]));

        ArrayList<Subject> subjectList = new ArrayList<Subject>();      // Subject 객체들을 담을 리스트

        for(int i = 0; i < subjectData.length; i++) {
            String[] tmp = subjectData[i].split("=");                   // Subject class의 member 나누기
            Subject subject = new Subject(tmp[0], Double.parseDouble(tmp[1]));  // Subject 객체에 memeber 집어 넣기
            subjectList.add(subject);                                           // Subject 객체들을 담을 리스트에 저장하기
        }

        this.datas.put(student, subjectList);                   // HashMap 필드에 Student 객체와 Subject 객체들로 구성된 리스트 저장하기
    }

    public void save() {
        // private HashMap<Student, ArrayList<Subject>> datas = new HashMap<Student, ArrayList<Subject>>();
        // rowData = "홍길동,1,2,25:영어=78.5,수학=84.7,국어=96.5"
        StringBuilder sb = new StringBuilder();

        for(Map.Entry<Student, ArrayList<Subject>> e : datas.entrySet()) {      //
            Student student = e.getKey();
            sb.append(student.getName() + ",");
            sb.append(student.getClassYear() + ",");
            sb.append(student.getClassRoom() + ",");
            sb.append(student.getClassNumber() + ":");

            for(Subject s : e.getValue()) {
                sb.append(s.getName() + "=");
                sb.append(s.getScore() + ",");
            }
            sb.replace(sb.length() - 1, sb.length(),"\n");  // 쉼표를 개행문자로 변경
        }

        File f = new File("/Users/houstonjustin/Documents/A.Project/A_A_A1-Lecture-Project/test/학생성적정보관리2.info");

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(f))) {
            bw.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void start() {
        load();
        while(true) {
            this.printMenu();

            System.out.print("선택 : ");
            int menuNumber = sc.nextInt(); sc.nextLine();

            switch(menuNumber) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    save();
                    System.exit(0);

            }
        }
    }
}
