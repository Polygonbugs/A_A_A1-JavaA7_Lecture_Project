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

    public void acceptAccountRequest(int[] temp) {
        AccountDAO dao = new AccountDAO();
        AccountView view = new AccountView();

        for(int id: temp) {
            boolean result = dao.updateReqAccount(id);
            view.show(result);
        }
    }

    public AccountVO login(String nickname, String password) {
        AccountDAO dao = new AccountDAO();
        AccountView view = new AccountView();

        AccountVO data = new AccountVO();
        data.setNickname(nickname);
        data.setPassword(password);

        AccountVO loginData = dao.selectAccount(data);

        if(loginData != null) {
            view.message("로그인 처리가 완료되었습니다. - 로그인 성공!!");
        } else {
            view.message("로그인 정보가 잘못되었습니다. - 로그인 실패!!");
        }

        return loginData;
    }

    public void logout(AccountVO user) {
        AccountDAO dao = new AccountDAO();
        AccountView view = new AccountView();

        boolean result = dao.insertLogoutAccessLog(user);

        if(result) {
            view.message("로그아웃 처리가 완료되었습니다. - 로그아웃 성공!!");
        } else {
            view.message("로그아웃 처리 중 문제가 발생하였습니다. - 로그아웃 실패!!");
        }

        view.message("로그아웃 되었습니다.");
    }

    public AccountVO changePassword(AccountVO account, String newPassword) {
        AccountDAO dao = new AccountDAO();

        account.setPassword(newPassword);

        boolean result = dao.updateAccountPassword(account);

        AccountView view = new AccountView();
        if(result) {
            view.message("패스워드 변경이 완료되었습니다. - 자동으로 로그아웃 됩니다.");
            return null;
        } else {
            view.message("패스워드 변경에 실패하였습니다. - 정보를 다시 확인하세요");
            return account;
        }
    }
}
