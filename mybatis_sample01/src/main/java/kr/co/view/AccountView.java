package kr.co.view;

import kr.co.vo.AccountVO;

import java.util.List;

public class AccountView {
    public void show(List<AccountVO> data) {
        for(AccountVO a: data) {
            System.out.println(a);
        }
    }
}
