package himedia.photobook.services.users;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.photobook.repositories.dao.UBoardDao;
import himedia.photobook.repositories.dao.UsersDao;
import himedia.photobook.repositories.vo.BoardVo;
import himedia.photobook.repositories.vo.ShipmentsVo;
import himedia.photobook.repositories.vo.UsersVo;


@Service 
public class UBoardServiceImpl implements UBoardService {
	@Autowired
	private UBoardDao uBoardDao;
	@Autowired
	private UsersDao usersDaoImpl;
	
	@Override
	public Map<String, Object> getContent(String userId,Long boardId) {
		BoardVo boardVo = uBoardDao.getContent(userId, boardId);
		Map<String, Object> contentMap = new HashMap<String, Object>();
		UsersVo usersVo = usersDaoImpl.selectOneUserById(boardVo.getUserId());
		System.out.println(usersVo);
		contentMap.put("boardVo", boardVo);
		contentMap.put("usersVo", usersVo);
		return contentMap;
	}

	@Override
	public BoardVo getBoardVo(String userId,Long boardId) {
		return uBoardDao.getContent(userId, boardId);
	}
	@Override
	public boolean write(BoardVo boardVo) {
		int insertedCount = uBoardDao.insert(boardVo);
		
		return insertedCount==1;
	}

	@Override
	public boolean update(BoardVo boardVo) {
		int updatedCount = uBoardDao.update(boardVo);
		return updatedCount == 1;
	}


	@Override
	public List<Map<String, Object>> getBoardInfos() {
		List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
		List<BoardVo> list = uBoardDao.selectAllList();
		
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
		int deletedCount = uBoardDao.delete(userId, boardId);
		return deletedCount==1;
	}


	@Override
	public List<Map<String, Object>> getContentByName(String userName) {
		List<Map<String, Object>> contentList = new ArrayList<Map<String,Object>>();
		Map<String, Object> map = null;
		
		List<UsersVo> userList = usersDaoImpl.selectUserByName(userName);
		
		for (UsersVo usersVo : userList) {
			List<BoardVo> boardList = uBoardDao.getContentById(usersVo.getUserId());
		
			
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

	

}
