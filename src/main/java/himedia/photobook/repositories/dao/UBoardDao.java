package himedia.photobook.repositories.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import himedia.photobook.repositories.vo.BoardVo;
import himedia.photobook.repositories.vo.InventoryVo;

public interface UBoardDao {
	public List<BoardVo> selectAllList();
	public int insert(BoardVo boardVo);
	public BoardVo getContent(String userId,Long boardId);
	public List<BoardVo> getContentById(String userId);
	public int update(BoardVo boardVo);
	public int delete(String userId, Long boardId);
	
	// 페이징 리스트
	public List<BoardVo> listPage(RowBounds rowBounds);
	// list의 전체 페이지 조회
	public int getTotalCount();
}
