package kr.co.dao;

import kr.co.main.OracleConnection;
import kr.co.vo.AccountVO;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

/*
 *  selectOne(1 or 2)
 *  selectList(1 or 2)
 *  insert(1 or 2)
 *  update(1 or 2)
 *  delete(1 or 2)
 *  --> 1. "namespaces.id" 형식의 매핑 정보를 필요로 한다.
 *  --> 2. "namsepaces.id, Object" 형식의 매핑 정보를 필요로 한다.
 *  --> Object는 전달할 데이터(int, double, String, AccountVO 형등의 데이터)
 */
public class AccountDAO {
    private SqlSession sess = OracleConnection.getSqlSession();

    public List<AccountVO> selectReqAccount() {
        List<AccountVO> result = new ArrayList<AccountVO>();
        // selectList : 0개 이상 Record(s)
        result = sess.selectList("test.reqAccount");

        return result;
    }
    public boolean duplicationCheck(String nickname, String email) {
        // selectOne : 1개 Record
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
        // sess.insert 함수를 통해서 반환되는 값은 삽입된 행수이다.
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

    public boolean updateReqAccount(int id) {
        int result = sess.update("test.updateReqAccount", id);

        if(result == 1) {
            AccountVO data = sess.selectOne("test.reqAccountId", id);
            data.setPassword("samplepassword");
            result = sess.insert("test.insertAccount", data);

            if(result == 1) {
                sess.commit();
                return true;
            }
        }
        sess.rollback();
        return false;
    }

    public AccountVO selectAccount(AccountVO data) {
        System.out.println("selectAccount");

        AccountVO result = sess.selectOne("test.selectAccount", data);

        if(result != null) {
            int cnt = sess.update("test.updateLoginDate", result);
            if(cnt == 1) {
                cnt = sess.insert("test.insertLoginAccessLog", result);
                if(cnt == 1) {
                    sess.commit();
                } else {
                    sess.rollback();
                }
            } else {
                sess.rollback();
            }
        }
        System.out.println(result);
        return result;
    }

    public boolean insertLogoutAccessLog(AccountVO user) {
        int result = sess.insert("test.insertLogoutAccessLog", user);

        if(result == 1) {
            sess.commit();
            return true;
        }
        sess.rollback();
        return false;
    }
}
