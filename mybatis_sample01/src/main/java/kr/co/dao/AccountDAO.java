package kr.co.dao;

import kr.co.main.OracleConnection;
import org.apache.ibatis.session.SqlSession;

public class AccountDAO {
    private SqlSession sess = OracleConnection.getSqlSession();

}
