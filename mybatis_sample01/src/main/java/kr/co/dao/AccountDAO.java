package kr.co.dao;

import kr.co.main.OracleConnection;
import kr.co.vo.AccountVO;
import org.apache.ibatis.session.SqlSession;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO {
    private SqlSession sess = OracleConnection.getSqlSession();

    public List<AccountVO> selectReqAccount() {
        List<AccountVO> result = new ArrayList<AccountVO>();
        result = sess.selectList("test.reqAccount");

        return result;
    }
    public boolean duplicationCheck(String nickname, String email) {
        int result = sess.selectOne("test.dupCheckNickname", nickname);

        if(result == 1) {
            return false;
        }
        result = sess.selectOne("test.dupCheckEmail", email);

        if(result == 1) {
            return false;
        }
        return true;
    }
    public boolean insertReqAccount(AccountVO account) throws Throwable{
        // sess.insert 함수를 통해서 반환되는 것은 삽입된 행수이다.
        try {
            int result = sess.insert("test.addReqAccount", account);

            if(result == 1) {
                sess.commit();
                return true;
            }
            sess.rollback();

            return false;
        } catch(org.apache.ibatis.exceptions.PersistenceException e) {
            throw e.getCause();
        }

    }
}
