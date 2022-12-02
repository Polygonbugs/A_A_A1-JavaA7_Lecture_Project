package kr.co.vo;

import java.sql.Date;
import java.util.Objects;

public class AccountVO {
    private int id;             // ID NUMBER PRIMARY KEY
    private String nickname;    // NICKNAME VARCHAR2(50) UNIQUE
    private String email;       // EMAIL VARCHAR2(75) UNIQUE
    private char isAllowed;     // ISALLOWED CHAR(1) DEFAULT('P') CHECK(ISALLOWED IN ('N', 'Y', 'P'))
    private Date reqDate;       // REQDATE DATE DEFAULT(SYSDATE)

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getIsAllowed() {
        return isAllowed;
    }

    public void setIsAllowed(char isAllowed) {
        this.isAllowed = isAllowed;
    }

    public Date getReqDate() {
        return reqDate;
    }

    public void setReqDate(Date reqDate) {
        this.reqDate = reqDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountVO accountVO = (AccountVO) o;
        return id == accountVO.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "AccountVO{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", isAllowed=" + isAllowed +
                ", reqDate=" + reqDate +
                '}';
    }
}
