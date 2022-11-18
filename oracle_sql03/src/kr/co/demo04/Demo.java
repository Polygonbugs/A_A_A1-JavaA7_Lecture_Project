package kr.co.demo04;

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


        // Query 작성(쿼리 문자열에서 세미콜론은 넣지 마세요.)
        // ? = holder
        int empId = 207;
        String jobId = "IT_PROG";
        // 동일한 이름의 클래스는 import 할 수 없다.
        Date hireDate = new Date(new java.util.Date().getTime());
        String query = "INSERT INTO EMPLOYEES VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        // PreparedStatement 객체 생성
        PreparedStatement pstat = conn.prepareStatement(query);
        pstat.setInt(1, empId);
        pstat.setString(2, "길동");
        pstat.setString(3, "홍");
        pstat.setString(4, "HGILDONG");
        pstat.setString(5, "515.123.1234");
        pstat.setDate(6, hireDate);
        pstat.setString(7, jobId);
        pstat.setInt(8, 2800);
        pstat.setDouble(9, 0);
        pstat.setInt(10, 103);
        pstat.setInt(11, 60);

        // Query 전송 후 결과 저장
        // Record Set(Oracle Database) = ResultSet rs(Java JDBC)
        // SELECT : executeQuery()
        // INSERT, UPDATE, DELETE : executeUpdate()
        // executeUpdate(); = 반영된 행 갯수 반환
        // INSERT ----> 1 ~ N
        // UPDATE ----> 0 ~ N (조건절 여부에 따라)
        // DELETE ----> 0 ~ N (조건절 여부에 따라)
        int rs = pstat.executeUpdate();

        if(rs >= 1) {
            System.out.println(rs + " 개 행이 반영되었습니다");
        } else {
            System.out.println("0개 행이 반영되었습니다. (쿼리에 문제가 있을 수 있습니다. 다시 확인하세요");
        }

        // Database 관련 연결 정보 Close
        pstat.close();
        conn.close();
    }
}
