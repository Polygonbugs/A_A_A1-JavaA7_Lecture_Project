package model.dto;

import java.sql.Date;

public class VisitDTO {

	private String userId;
	private String context;
	private Date createDate;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String nickname) {
		this.userId = nickname;
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
		return "VisitDTO{" +
				"userId='" + userId + '\'' +
				", context='" + context + '\'' +
				", createDate=" + createDate +
				'}';
	}
}