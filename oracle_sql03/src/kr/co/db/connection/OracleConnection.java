package kr.co.db.connection;

import java.sql.*;

/**
 * DB 연결용 클래스
 */
public class OracleConnection {

    private final static String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private final static String JDBC_URL = "jdbc:oracle:thin:@";

    private Connection conn;
    private PreparedStatement pstat;
    private ResultSet rs;

    /**
     * 계정명과 패스워드가 동일한 경우 사용할 수 있다
     * @param url
     * @param username  : 계정명이지만 패스워드에도 동일하게 사용한다.
     */
    public OracleConnection(String url, String username) throws SQLException, ClassNotFoundException {
        this(url, username, username);
    }

    public OracleConnection(String url, String username, String password) throws ClassNotFoundException, SQLException {
        Class.forName(ORACLE_DRIVER);

        this.conn = DriverManager.getConnection(JDBC_URL + url, username, password);

    }

    public PreparedStatement getPrepared(String query) throws SQLException {
        this.pstat = this.conn.prepareStatement(query);
        return this.pstat;
    }

    public ResultSet sendSelect() throws SQLException {
        this.rs = this.pstat.executeQuery();
        return rs;
    }

    public int sendInsert() throws SQLException {
        return this.pstat.executeUpdate();
    }

    public int sendUpdate() throws SQLException {
        return this.pstat.executeUpdate();
    }

    public int sendDelete() throws SQLException {
        return this.pstat.executeUpdate();
    }

    public void close() throws SQLException {
        if(this.rs != null) {
            this.rs.close();
        }

        if(this.pstat != null) {
            this.pstat.close();
        }

        if(this.conn != null) {
            this.conn.close();
        }
    }

}
