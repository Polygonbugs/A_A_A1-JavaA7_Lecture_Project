package model.dto;

import java.sql.Date;

public class VisitDTO {

	private String nickname;
	private String context;
	private Date createDate;
	
	public String getNickName() {
		return nickname;
	}
	
	public void setNickName(String nickname) {
		this.nickname = nickname;
	}
	
	public String getContext() {
		return context;
	}
	
	public void setContext(String context) {
		this.context = context;
	}
	
	public Date getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	@Override
	public String toString() {
		return "VisitDTO [nickname=" + nickname + ", context=" + context + ", createDate=" + createDate + "]";
	}
	
}
