package himedia.photobook.repositories.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import himedia.photobook.exceptions.uBoardDaoException;
import himedia.photobook.repositories.vo.uBoardVo;

@Repository("uBoardDao")
public class uBoardDaoImpl implements uBoardDao{
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<uBoardVo> selectAllList() {
		List<uBoardVo> list = sqlSession.selectList("uboard.selectAll");
		return list;
	}

	@Override
	public int insert(uBoardVo boardVo) {
		try {
			int insertedCount = sqlSession.insert("uboard.insert",boardVo);
			return insertedCount;
		}catch(Exception e) {
			e.printStackTrace();
			throw new uBoardDaoException("게시글 등록중 뭔가 잘못되었습니다.");
		}
	}

	@Override
	public uBoardVo getContent(Long uboardId) {

		return null;
	}

	@Override
	public int update(uBoardVo boardVo) {

		return 0;
	}

	@Override
	public int delete(Long uboardId, Long userId) {

		return 0;
	}
	
	
	
	
}
