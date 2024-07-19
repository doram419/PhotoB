package himedia.photobook.repositories.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import himedia.photobook.exceptions.UBoardDaoException;
import himedia.photobook.repositories.vo.BoardVo;

@Repository("uBoardDao")
public class UBoardDaoImpl implements UBoardDao{
	@Autowired
	private SqlSession sqlSession;
	
	
	@Override
	public List<BoardVo> selectAllList() {
		return sqlSession.selectList("board.selectAll");
	}
	
	@Override
	public int insert(BoardVo uboardVo) {
		try {
			int insertedCount = sqlSession.insert("board.insert",uboardVo);
			return insertedCount;
		}catch(Exception e) {
			e.printStackTrace();
			throw new UBoardDaoException("게시글 등록중 뭔가 잘못되었습니다.");
		}
	}

	@Override
	public BoardVo getContent(String userId,Long boardId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userId", userId);
		map.put("boardId",boardId);
		return sqlSession.selectOne("board.getContent",map);
		
	}

	@Override
	public int update(BoardVo boardVo) {
		try {
			int updatedCount = sqlSession.update("board.update",boardVo);
			return updatedCount;
		}catch(Exception e) {
			e.printStackTrace();
			throw new UBoardDaoException("게시글 업데이트 실패~~");
		}
	}

	@Override
	public int delete(String userId, Long boardId) {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("userId", userId);
			map.put("boardId", boardId);
			return sqlSession.delete("board.delete",map);
		}catch(Exception e) {
			e.printStackTrace();
			throw new UBoardDaoException("게시글 삭제 실패~~~");
		}
	}

	

	

}
