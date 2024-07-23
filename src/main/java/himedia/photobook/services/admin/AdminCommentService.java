package himedia.photobook.services.admin;

import himedia.photobook.repositories.vo.CommentsVo;


public interface AdminCommentService {
	// boardId로 commentsvo 가져오기
	public CommentsVo getCommentsByBoardId(Long boardId);
	// 댓글 작성
	public boolean write(CommentsVo commentsVo);
	// 댓글 하나만 달리게끔 ㅎ
	public boolean hasComment(Long boardId);
}
