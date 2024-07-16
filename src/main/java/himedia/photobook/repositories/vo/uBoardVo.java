package himedia.photobook.repositories.vo;

import java.util.Date;

public class uBoardVo {
	private Long uboardId;
	private Long title;
	private Long content;
	private Date regDate;
	private String userId;
	private String userName;
	
	
	public uBoardVo() {

	}

	
	public uBoardVo(Long title, Long content, String userId) {
		this.title = title;
		this.content = content;
		this.userId = userId;
	}



	public uBoardVo(Long uboardId, Long title, Long content, Date regDate, String userId, String userName) {
		super();
		this.uboardId = uboardId;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
		this.userId = userId;
		this.userName = userName;
	}


	public Long getUboardId() {
		return uboardId;
	}


	public void setUboardId(Long uboardId) {
		this.uboardId = uboardId;
	}


	public Long getTitle() {
		return title;
	}


	public void setTitle(Long title) {
		this.title = title;
	}


	public Long getContent() {
		return content;
	}


	public void setContent(Long content) {
		this.content = content;
	}


	public Date getRegDate() {
		return regDate;
	}


	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	@Override
	public String toString() {
		return "BoardVo [uboardId=" + uboardId + ", title=" + title + ", content=" + content + ", regDate=" + regDate
				+ ", userId=" + userId + ", userName=" + userName + "]";
	}
	
	
	
	
	
}
