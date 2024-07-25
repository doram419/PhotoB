package himedia.photobook.services.users;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.photobook.repositories.dao.UBoardDaoImpl;
import himedia.photobook.repositories.dao.UsersDao;
import himedia.photobook.repositories.vo.BoardVo;
import himedia.photobook.repositories.vo.InventoryVo;
import himedia.photobook.repositories.vo.UsersVo;


@Service 
public class UBoardServiceImpl implements UBoardService {
	@Autowired
	private UBoardDaoImpl uBoardDaoImpl;
	@Autowired
	private UsersDao usersDaoImpl;
	
	
	@Override
	public Map<String, Object> getContent(String userId,Long boardId) {
		BoardVo boardVo = uBoardDaoImpl.getContent(userId, boardId);
		Map<String, Object> contentMap = new HashMap<String, Object>();
		UsersVo usersVo = usersDaoImpl.selectOneUserById(boardVo.getUserId());
		System.out.println(usersVo);
		contentMap.put("boardVo", boardVo);
		contentMap.put("usersVo", usersVo);
		return contentMap;
	}

	@Override
	public BoardVo getBoardVo(String userId,Long boardId) {
		return uBoardDaoImpl.getContent(userId, boardId);
	}
	@Override
	public boolean write(BoardVo boardVo) {
		int insertedCount = uBoardDaoImpl.insert(boardVo);
		
		return insertedCount==1;
	}

	@Override
	public boolean update(BoardVo boardVo) {
		int updatedCount = uBoardDaoImpl.update(boardVo);
		return updatedCount == 1;
	}


	@Override
	public List<Map<String, Object>> getBoardInfos() {
		List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
		List<BoardVo> list = uBoardDaoImpl.selectAllList();
		
		for(BoardVo boardVo : list) {
			Map<String, Object> boardMap = new HashMap<String, Object>();
			UsersVo usersVo = usersDaoImpl.selectOneUserById(boardVo.getUserId());
			
			boardMap.put("boardVo", boardVo);
			boardMap.put("usersVo", usersVo);

			result.add(boardMap);
		}
		return result;
	}
	@Override
	public boolean delete(String userId, Long boardId) {
		int deletedCount = uBoardDaoImpl.delete(userId, boardId);
		return deletedCount==1;
	}


	@Override
	public List<Map<String, Object>> getContentByName(String userName) {
		List<Map<String, Object>> contentList = new ArrayList<Map<String,Object>>();
		Map<String, Object> map = null;
		
		List<UsersVo> userList = usersDaoImpl.selectUserByName(userName);
		
		for (UsersVo usersVo : userList) {
			List<BoardVo> boardList = uBoardDaoImpl.getContentById(usersVo.getUserId());
		
			
			for (BoardVo boardVo : boardList) {
				map = new HashMap<String, Object>();
				map.put("boardVo", boardVo);
				map.put("usersVo", usersVo);	
				contentList.add(map);
			}
		}
		System.out.println(contentList);
		return contentList;
	
	}

	// 페이징
	public List<BoardVo> getPagedBoard(int page, int pageSize) {
        int offset = (page - 1) * pageSize;
        RowBounds rowBounds = new RowBounds(offset, pageSize);
        return uBoardDaoImpl.listPage(rowBounds);
    }
	
	@Override
	public int getTotalCount() {
		return uBoardDaoImpl.getTotalCount();
	}

}
