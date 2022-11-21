package kr.co.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.db.connection.OracleConnection;
import kr.co.db.vo.EmployeeVO;

public class EmployeeDAO {
	
	private OracleConnection oc;
	
	public EmployeeDAO() throws ClassNotFoundException, SQLException {
		this.oc = new OracleConnection("//10.211.55.6:1521/XEPDB1", "dev01");
	}

	public ArrayList<EmployeeVO> selectAll() {
		String query = "SELECT * FROM EMPLOYEES";
		
		ArrayList<EmployeeVO> empArray = new ArrayList<EmployeeVO>();
		
		try {
			this.oc.getPrepared(query);
			ResultSet rs = this.oc.sendSelect();
			
			while(rs.next()) {
				EmployeeVO emp = new EmployeeVO();
				emp.setEmpId(rs.getInt("EMPLOYEE_ID"));
				emp.setFirstName(rs.getString("FIRST_NAME"));
				emp.setLastName(rs.getString("LAST_NAME"));
				emp.setEmail(rs.getString("EMAIL"));
				emp.setPhoneNumber(rs.getString("PHONE_NUMBER"));
				emp.setHireDate(rs.getDate("HIRE_DATE"));
				emp.setJobId(rs.getString("JOB_ID"));
				emp.setCommission(rs.getDouble("COMMISSION_PCT"));
				emp.setManagerId(rs.getInt("MANAGER_ID"));
				emp.setDeptId(rs.getInt("DEPARTMENT_ID"));
				empArray.add(emp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empArray;
	}

	public EmployeeVO selectId(int id) {
		String query = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = ?";
		try {
			PreparedStatement pstat = this.oc.getPrepared(query);
			pstat.setInt(1, id);
			
			ResultSet rs = oc.sendSelect();
			
			if(rs.next()) {
				EmployeeVO emp = new EmployeeVO();
				emp.setEmpId(rs.getInt("EMPLOYEE_ID"));
				emp.setFirstName(rs.getString("FIRST_NAME"));
				emp.setLastName(rs.getString("LAST_NAME"));
				emp.setEmail(rs.getString("EMAIL"));
				emp.setPhoneNumber(rs.getString("PHONE_NUMBER"));
				emp.setHireDate(rs.getDate("HIRE_DATE"));
				emp.setJobId(rs.getString("JOB_ID"));
				emp.setCommission(rs.getDouble("COMMISSION_PCT"));
				emp.setManagerId(rs.getInt("MANAGER_ID"));
				emp.setDeptId(rs.getInt("DEPARTMENT_ID"));
				return emp;
			} else {
				return null;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<EmployeeVO> selectName(String name) {
		String query = "SELECT * FROM EMPLOYEES"
				+ " WHERE LOWER(CONCAT(FIRST_NAME, LAST_NAME)) LIKE ?";

		try {
			PreparedStatement pstat = this.oc.getPrepared(query);
			pstat.setString(1, "%" + name.replace(" ", "").toLowerCase() + "%");

			ResultSet rs = oc.sendSelect();

			ArrayList<EmployeeVO> empArray = new ArrayList<EmployeeVO>();

			while(rs.next()) {
				EmployeeVO emp = new EmployeeVO();
				emp.setEmpId(rs.getInt("EMPLOYEE_ID"));
				emp.setFirstName(rs.getString("FIRST_NAME"));
				emp.setLastName(rs.getString("LAST_NAME"));
				emp.setEmail(rs.getString("EMAIL"));
				emp.setPhoneNumber(rs.getString("PHONE_NUMBER"));
				emp.setHireDate(rs.getDate("HIRE_DATE"));
				emp.setJobId(rs.getString("JOB_ID"));
				emp.setCommission(rs.getDouble("COMMISSION_PCT"));
				emp.setManagerId(rs.getInt("MANAGER_ID"));
				emp.setDeptId(rs.getInt("DEPARTMENT_ID"));
				empArray.add(emp);
			}

			return empArray;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	public ArrayList<EmployeeVO> selectJobName(String jobName) {
		String query = "SELECT * FROM EMPLOYEES";
		
		return null;
	}

	public ArrayList<EmployeeVO> selectdeptName(String deptName) {
		String query = "SELECT * FROM EMPLOYEES";
		
		return null;
	}

}
