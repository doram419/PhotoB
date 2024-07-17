package himedia.photobook.repositories.dao;

import java.util.List;

import himedia.photobook.repositories.vo.BoardVo;

public interface UBoardDao {
	public List<BoardVo> selectAllList();
	public int insert(BoardVo boardVo);
	public BoardVo getContent(Long uboardId);
	public int update(BoardVo boardVo);
	public int delete(Long uboardId, Long userId);
}
