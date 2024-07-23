package himedia.photobook.repositories.dao;

import himedia.photobook.repositories.vo.CommentsVo;

public interface CommentsDao {
	
	public CommentsVo getCommentsByBoardId(Long boardId);
	public int insert(CommentsVo commentsVo);
	public int updateStatus(Long boardId);
//	public int countComment(Long boardId);
}
