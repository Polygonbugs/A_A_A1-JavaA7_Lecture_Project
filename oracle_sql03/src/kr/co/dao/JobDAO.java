package kr.co.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.co.db.connection.OracleConnection;
import kr.co.db.vo.JobVO;

public class JobDAO {
	
	private OracleConnection oc;
	
	public JobDAO() throws ClassNotFoundException, SQLException {
		this.oc = new OracleConnection("//10.211.55.6:1521/XEPDB1", "dev01");
	}

	public ArrayList<JobVO> selectAll() {
		String query = "SELECT * FROM JOBS";
		
		ArrayList<JobVO> jobArray = new ArrayList<JobVO>();
		
		try {
			this.oc.getPrepared(query);
			ResultSet rs = this.oc.sendSelect();
			
			while(rs.next()) {
				JobVO job = new JobVO();
				job.setJobId(rs.getString("JOB_ID"));
				job.setJobTitle(rs.getString("JOB_TITLE"));
				job.setMinSalary(rs.getInt("MIN_SALARY"));
				job.setMaxSalary(rs.getInt("MAX_SALARY"));
				jobArray.add(job);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return jobArray;
	}

}
