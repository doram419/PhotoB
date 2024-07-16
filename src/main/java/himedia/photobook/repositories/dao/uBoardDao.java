package himedia.photobook.repositories.dao;

import java.util.List;

import himedia.photobook.repositories.vo.uBoardVo;

public interface uBoardDao {
	public List<uBoardVo> selectAllList();
	public int insert(uBoardVo boardVo);
	public uBoardVo getContent(Long uboardId);
	public int update(uBoardVo boardVo);
	public int delete(Long uboardId, Long userId);
}
