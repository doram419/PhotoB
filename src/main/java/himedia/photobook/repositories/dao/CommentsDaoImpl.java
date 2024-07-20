package himedia.photobook.repositories.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import himedia.photobook.exceptions.UBoardDaoException;
import himedia.photobook.repositories.vo.BoardVo;
import himedia.photobook.repositories.vo.CommentsVo;

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

}
