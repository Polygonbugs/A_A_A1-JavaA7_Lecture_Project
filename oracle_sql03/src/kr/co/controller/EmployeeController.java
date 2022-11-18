package kr.co.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.dao.EmployeeDAO;
import kr.co.db.vo.EmployeeVO;
import kr.co.view.EmployeeView;

public class EmployeeController {
	
	private EmployeeView ev = new EmployeeView();
	private EmployeeDAO empDao;
	
	public EmployeeController() throws ClassNotFoundException, SQLException {
		this.empDao = new EmployeeDAO();
	}

	public void getAll() {
		ArrayList<EmployeeVO> datas = empDao.selectAll();
		ev.print(datas);
	}

    public void getId(int id) {
		EmployeeVO data = empDao.selectId(id);
		ev.print(data);
    }

	public void getName(String name) {
		ArrayList<EmployeeVO> datas = empDao.selectName(name);
		ev.print(datas);
	}

	public void getJobName(String jobName) {
		ArrayList<EmployeeVO> datas = empDao.selectJobName(jobName);
		ev.print(datas);
	}

	public void getDeptName(String deptName) {
		ArrayList<EmployeeVO> datas = empDao.selectdeptName(deptName);
		ev.print(datas);
	}
}
