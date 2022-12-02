package kr.co.controller;

import kr.co.dao.AccountDAO;
import kr.co.view.AccountView;

public class AccountController {
    public void getAccountRequest() {
        AccountDAO dao = new AccountDAO();
        AccountView view = new AccountView();
    }
}
