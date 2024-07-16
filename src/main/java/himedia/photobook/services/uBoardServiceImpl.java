package himedia.photobook.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.photobook.repositories.dao.uBoardDao;
import himedia.photobook.repositories.vo.uBoardVo;

@Service("uboardService")
public class uBoardServiceImpl implements uBoardService {
	@Autowired
	private uBoardDao uboardDao;

	@Override
	public List<uBoardVo> getList() {
		List<uBoardVo> list = uboardDao.selectAllList();
		return list;
	}

	@Override
	public uBoardVo getContent(Long uboardId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean write(uBoardVo boardVo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(uBoardVo boardVo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Long uboardId, Long userId) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
