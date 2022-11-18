package kr.co.demo05;

import kr.co.db.connection.OracleConnection;
import kr.co.db.vo.EmployeeVO;

import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Demo04 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        OracleConnection oc = new OracleConnection("//10.211.55.6:1521/XEPDB1", "dev01");

        EmployeeVO emp = new EmployeeVO();
        emp.setEmpId(207);
        emp.setFirstName("길동");
        emp.setLastName("홍");
        emp.setEmail("HGILDONG");
        emp.setPhoneNumber("515.123.1234");
        emp.setHireDate(new Date());
        emp.setJobId("IT_PROG");
        emp.setSalary(2800);
        emp.setCommission(0);
        emp.setManagerId(103);
        emp.setDeptId(60);

        String query = "INSERT INTO EMPLOYEES VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        // PreparedStatement 객체 생성
        PreparedStatement pstat = oc.getPrepared(query);
        pstat.setInt(1, emp.getEmpId());
        pstat.setString(2, emp.getFirstName());
        pstat.setString(3, emp.getLastName());
        pstat.setString(4, emp.getEmail());
        pstat.setString(5, emp.getPhoneNumber());
        pstat.setDate(6, emp.getHireDate());
        pstat.setString(7, emp.getJobId());
        pstat.setInt(8, emp.getSalary());
        pstat.setDouble(9, emp.getCommission());
        pstat.setInt(10, emp.getManagerId());
        pstat.setInt(11, emp.getDeptId());

        int rs = oc.sendInsert();

        if(rs >= 1) {
            System.out.println(rs + " 개 행이 반영되었습니다");
        } else {
            System.out.println("0개 행이 반영되었습니다. (쿼리에 문제가 있을 수 있습니다. 다시 확인하세요");
        }

        oc.close();
    }
}
