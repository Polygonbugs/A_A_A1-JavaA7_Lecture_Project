package kr.co.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.db.connection.OracleConnection;
import kr.co.db.vo.DepartmentVO;
import kr.co.db.vo.EmployeeVO;

public class DepartmentDAO {
	
	private OracleConnection oc;
	
	public DepartmentDAO() throws ClassNotFoundException, SQLException {
		this.oc = new OracleConnection("//10.211.55.6:1521/XEPDB1", "dev01");
	}

	public ArrayList<DepartmentVO> selectAll() {
		String query = "SELECT * FROM DEPARTMENTS";
		
		ArrayList<DepartmentVO> deptArray = new ArrayList<DepartmentVO>();
		
		try {
			this.oc.getPrepared(query);
			ResultSet rs = this.oc.sendSelect();
			
			while(rs.next()) {
				DepartmentVO dept = new DepartmentVO();
				dept.setDeptId(rs.getInt("DEPARTMENT_ID"));
				dept.setDeptName(rs.getString("DEPARTMENT_NAME"));
				dept.setManagerId(rs.getInt("MANAGER_ID"));
				dept.setLocationId(rs.getInt("LOCATION_ID"));
				deptArray.add(dept);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return deptArray;
	}

}
