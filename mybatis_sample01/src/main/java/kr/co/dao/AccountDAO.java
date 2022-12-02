package kr.co.dao;

import kr.co.main.OracleConnection;
import kr.co.vo.AccountVO;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

public class AccountDAO {
    private SqlSession sess = OracleConnection.getSqlSession();

    public List<AccountVO> selectReqAccount() {
        List<AccountVO> result = new ArrayList<AccountVO>();
        result = sess.selectList("test.reqAccount");

        return result;
    }
}
