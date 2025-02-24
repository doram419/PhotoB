package himedia.photobook.repositories.vo;

import java.util.Date;

public class BoardVo {
	private Long boardId;
	private String title;
	private String content;
	private Date regDate;
	private String userId;
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BoardVo() {

	}

	public BoardVo(String title, String content, String userId) {
		this.title = title;
		this.content = content;
	}

	public BoardVo(Long boardId, String title, String content, Date regDate, String userId, String userName) {
		super();
		this.boardId = boardId;
		this.title = title;
		this.content = content;
		this.regDate = regDate;
	}

	public Long getBoardId() {
		return boardId;
	}

	public void setBoardId(Long boardId) {
		this.boardId = boardId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
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

	@Override
	public String toString() {
		return "BoardVo [boardId=" + boardId + ", title=" + title + ", content=" + content + ", regDate=" + regDate
				+ "]";
	}

}
