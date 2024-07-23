package himedia.photobook.repositories.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import himedia.photobook.exceptions.UBoardDaoException;
import himedia.photobook.repositories.vo.BoardVo;
import himedia.photobook.repositories.vo.CommentsVo;

@Repository
public class CommentsDaoImpl implements CommentsDao{

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public int insert(CommentsVo commentsVo) {
		try {
			int insertedCount = sqlSession.insert("comments.insert",commentsVo);
			return insertedCount;
		}catch(Exception e) {
			e.printStackTrace();
			throw new UBoardDaoException("게시글 등록중 뭔가 잘못되었습니다.");
		}
	}

	@Override
	public CommentsVo getCommentsByBoardId(Long boardId) {
		CommentsVo commentsVo = sqlSession.selectOne("comments.getCommentsByBoardId",boardId);
		return commentsVo;
	}
	
	@Override
	public int updateStatus(Long boardId) {
		return sqlSession.update("board.updateStatus",boardId);
	}
	
	
	/*
	 * @Override public int countComment(Long boardId) { int commentsVo =
	 * sqlSession.selectOne("comments.countComment",boardId);
	 * System.out.println(commentsVo); return commentsVo; }
	 */
	

}
