package kr.co.demo02;

import java.sql.*;
import java.text.SimpleDateFormat;

public class Demo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        /*
         *  Java로 Oracle DB에 접속하여 데이터 조회하는 방법
         *  1. JDBC 라이브러리 필수
         *     - JDBC 버전은 JDK 11인 경우 OJDBC 10 이상을 사용.
         *       JDK 8인 경우 OJDBC 8을 사용하면 됩니다.
         *  2. JDBC 라이브러리를 이클립스 프로젝트의 설정에서 JAVA Build Path > Library > classPath
         *     Add External JARs ... 버튼 클릭하여 등록
         *  3. 다음의 순서에 맞추어 코드 작성
         *      A. Oracle Driver 등록
         *      B. Database Connection 생성
         *      C. Statement 객체 또는 PreparedStatement 생성
         *      D. Query 작성
         *      E. 작성한 Query 전송 후 ResultSet 반환
         *      F. 반환받은 ResultSet의 내용 추출 및 추가 작업
         *      G. Database 관련 연결 정보 Close
         */

        // Oracle Driver 등록
        Class.forName("oracle.jdbc.driver.OracleDriver");

        // Database Connection 생성
        // String url = 'jdbc:oracle:thin:@IP주소:Port/ServiceName';
        // Connection conn = DriverManager.getConnection("Oracle DB 접속정보", "계정", "암호");
        String url = "jdbc:oracle:thin:@//10.211.55.6:1521/XEPDB1";
        String username = "dev01";
        String password = "dev01";
        Connection conn = DriverManager.getConnection(url, username, password);

        // Statement 또는 PreparedStatement 객체 생성
        Statement stat = conn.createStatement();
        // PreparedStatement pstat = conn.prepareStatement("");

        // Query 작성(쿼리 문자열에서 세미콜론은 넣지 마세요.)
        int empId = 100;
        String jobId = "IT_PROG";
        String query = "SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, HIRE_DATE FROM EMPLOYEES";
        query += " WHERE EMPLOYEE_ID = " + empId;
        query += "    OR JOB_ID = '" + jobId + "'";


        // Query 전송 후 결과 저장
        // Record Set(Oracle Database) = ResultSet rs(Java JDBC)
        ResultSet rs = stat.executeQuery(query);


        // ResultSet에서 값 추출
        // rs.next()는 데이터베이스의 커서를 이동시키는 역할을 한다. 옮기고 있는지를 확인하여 boolean 값 반환
        SimpleDateFormat df = new SimpleDateFormat("yyyy년 MM월 dd일");

        System.out.println("| ID | FIRST_NAME           | LAST NAME            | HIRE DATE            |");
        System.out.println("+----+----------------------+----------------------+----------------------+");
        while(rs.next()) {
            int id = rs.getInt("EMPLOYEE_ID");
            String fName = rs.getString("FIRST_NAME");
            String lName = rs.getString("LAST_NAME");
            Date hireDate = rs.getDate("HIRE_DATE");

            System.out.printf("|%d | %21s| %21s| %18s| \n", id, fName, lName, df.format(hireDate));
        }


        // Database 관련 연결 정보 Close
        rs.close();
        stat.close();
        conn.close();
    }
}
