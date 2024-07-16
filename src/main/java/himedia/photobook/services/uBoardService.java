package himedia.photobook.services;

import java.util.List;

import himedia.photobook.repositories.vo.uBoardVo;


public interface uBoardService {
	public List<uBoardVo> getList();
	public uBoardVo getContent(Long uboardId);
	public boolean write(uBoardVo boardVo);
	public boolean update(uBoardVo boardVo);
	public boolean delete(Long uboardId, Long userId);
}
