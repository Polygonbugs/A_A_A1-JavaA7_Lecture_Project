package kr.co.run;

import kr.co.manager.EmployeeManager;

import java.sql.SQLException;

public class Run {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        EmployeeManager em = new EmployeeManager();
        em.start();
    }
}
