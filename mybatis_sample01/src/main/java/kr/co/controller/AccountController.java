package kr.co.controller;

import kr.co.dao.AccountDAO;
import kr.co.view.AccountView;
import kr.co.vo.AccountVO;

import java.sql.SQLException;
import java.util.List;

public class AccountController {
    public void getAccountRequest() {
        AccountDAO dao = new AccountDAO();
        AccountView view = new AccountView();

        List<AccountVO> data = dao.selectReqAccount();
        view.show(data);
    }

    public void setAccountRequest(String nickname, String email) {
        AccountDAO dao = new AccountDAO();
        AccountView view = new AccountView();

        AccountVO account = new AccountVO();
        account.setNickname(nickname);
        account.setEmail(email);

        boolean result;
        if(dao.duplicationCheck(nickname, email) == false) {
            try {
                result = dao.insertReqAccount(account);
                view.show(result);
            } catch(Throwable e) {
                String reason = e.getMessage().split(":")[0];
                if(reason.equals("ORA-00001")) {
                    System.out.println("닉네임 또는 이메일 주소가 중복되었습니다. 다시 입력하세요.");
                }
            }

        } else {
            System.out.println("중복 데이터가 있습니다. 다른 닉네임과 이메일 주소를 입력하세요");
        }


    }
}
