package himedia.photobook.services;

import java.util.List;
import java.util.Map;

import himedia.photobook.repositories.vo.BoardVo;


public interface UBoardService {
	public List<Map<String, Object>> getBoardInfos();
	public BoardVo getContent(Long UboardId);
	public boolean write(BoardVo boardVo);
	public boolean update(BoardVo boardVo);
	public boolean delete(Long UboardId, Long userId);
	
}
