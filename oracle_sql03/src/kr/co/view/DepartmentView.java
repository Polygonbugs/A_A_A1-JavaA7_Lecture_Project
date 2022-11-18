package kr.co.view;

import java.util.ArrayList;

import kr.co.db.vo.DepartmentVO;

public class DepartmentView {

	public void print(ArrayList<DepartmentVO> datas) {
		for(DepartmentVO dept: datas) {
			System.out.println(dept);
		}
	}

}
