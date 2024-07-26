package himedia.photobook.services.users;

import java.util.List;
import java.util.Map;

import himedia.photobook.repositories.vo.BoardVo;
import himedia.photobook.repositories.vo.InventoryVo;


public interface UBoardService {
	public List<Map<String, Object>> getBoardInfos();
	public Map<String, Object> getContent(String userId,Long boardId);
	public List<Map<String, Object>> getContentByName(String userName);
	public BoardVo getBoardVo(String userId,Long boardId);
	public boolean write(BoardVo boardVo);
	public boolean update(BoardVo boardVo);
	public boolean delete(String userId, Long boardId);
	public List<BoardVo> getPagedBoard(int page, int pageSize);
	public int getTotalCount();
	
}
