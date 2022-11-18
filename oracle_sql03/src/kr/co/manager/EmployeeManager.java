package kr.co.manager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import kr.co.controller.DepartmentController;
import kr.co.controller.EmployeeController;
import kr.co.controller.JobController;

public class EmployeeManager {

	private Scanner sc = new Scanner(System.in);
	private EmployeeController ec;
	private DepartmentController dc;
	private JobController jc;
	
	public EmployeeManager() throws ClassNotFoundException, SQLException {
		this.ec = new EmployeeController();
		this.dc = new DepartmentController();
		this.jc = new JobController();
	}
	
	public void start() {
		while(true) {
			this.printMenu();
			System.out.print("메뉴 번호 입력 : ");
			int menuNumber = 0;
			if(sc.hasNextInt()) {
				menuNumber = sc.nextInt();	sc.nextLine();
				this.selectMenu(menuNumber);
			}
		}
	}

	private void printMenu() {
		System.out.println("[1] 모든 사원 정보 출력");
		System.out.println("[2] 모든 부서 정보 출력");
		System.out.println("[3] 모든 직무 정보 출력");
		System.out.println("[4] 사원 등록 수정 삭제");
		System.out.println("[5] 부서 등록 수정 삭제");
		System.out.println("[6] 직무 등록 수정 삭제");
		System.out.println("[7] 프로그램 종료");
	}

	private void selectMenu(int menuNumber) {
		switch(menuNumber) {
			case 1:
				// 사원 조회
				this.empSearchMenu();
				break;
			case 2:
				// 부서 조회
				this.deptSearchMenu();
				break;
			case 3:
				// 직무 조회
				this.jobSearchMenu();
				break;
			case 4:
				// 사원 등록, 수정, 삭제
				break;
			case 5:
				// 부서 등록, 수정, 삭제
				break;
			case 6:
				// 직무 등록, 수정, 삭제
				break;
			case 7:
				// 종료
				System.exit(0);
		}
	}

	private void empSearchMenu() {
		System.out.println("[1] 전체 조회");
		System.out.println("[2] ID로 조회");
		System.out.println("[3] 이름으로 조회");
		System.out.println("[4] 직무로 조회");
		System.out.println("[5] 부서로 조회");

		int menuNumber = 0;

		while(true) {
			System.out.print("번호 선택 : ");
			if (sc.hasNextInt()) {
				menuNumber = sc.nextInt(); sc.nextLine();
				break;
			}
		}

		switch (menuNumber) {
			case 1:
				ec.getAll(); break;
			case 2:
				System.out.print("사번 입력 : ");
				int id = sc.nextInt(); sc.nextLine();
				ec.getId(id); break;
			case 3:
				System.out.print("이름 입력 : ");
				String name = sc.nextLine();
				ec.getName(name); break;
			case 4:
				System.out.print("직무명 입력 : ");
				String jobName = sc.nextLine();
				ec.getJobName(jobName); break;
			case 5:
				System.out.print("부서명 입력 : ");
				String deptName = sc.nextLine();
				ec.getDeptName(deptName); break;
		}
	}

	private void deptSearchMenu() {

	}

	private void jobSearchMenu() {

	}

}
