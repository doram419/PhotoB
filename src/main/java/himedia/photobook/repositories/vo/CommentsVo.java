package himedia.photobook.repositories.vo;

import java.util.Date;

public class CommentsVo {
	private Long commentId;
	private String userName;
	private String content;
	private Date comDate;
	
	
	public CommentsVo() {
		
	}
	
	public CommentsVo(Long commentId, String userName, String content, Date comDate) {
		this.commentId = commentId;
		this.userName = userName;
		this.content = content;
		this.comDate = comDate;
	}


	public Long getCommentId() {
		return commentId;
	}


	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public Date getComDate() {
		return comDate;
	}


	public void setComDate(Date comDate) {
		this.comDate = comDate;
	}


	@Override
	public String toString() {
		return "CommentsVo [commentId=" + commentId + ", userName=" + userName + ", content=" + content + ", comDate="
				+ comDate + "]";
	}
	
	
	
}
