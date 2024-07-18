package himedia.photobook.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.photobook.repositories.dao.UBoardDao;
import himedia.photobook.repositories.dao.UsersDao;
import himedia.photobook.repositories.vo.BoardVo;
import himedia.photobook.repositories.vo.UsersVo;


@Service 
public class UBoardServiceImpl implements UBoardService {
	@Autowired
	private UBoardDao uBoardDao;
	@Autowired
	private UsersDao userDao;
//	private UBoardDao UBoardDaoImpl;

	
	@Override
	public BoardVo getContent(String userId,Long boardId) {
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
			UsersVo usersVo = userDao.selectOneUserById(boardVo.getUserId());
			
			boardMap.put("boardVo", boardVo);
			boardMap.put("usersVo", usersVo);

			result.add(boardMap);
		}
		return result;
	}

//	@Override
//	public boolean delete(String userId, String string) {
//		int deleteCount = uBoardDao.delete(userId);
//		return false;
//	}

	@Override
	public boolean delete(String userId, Long boardId) {
		int deletedCount = uBoardDao.delete(userId, boardId);
		return deletedCount==1;
	}

	

}
