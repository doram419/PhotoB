package himedia.photobook.services.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.photobook.repositories.dao.CommentsDao;
import himedia.photobook.repositories.vo.CommentsVo;

@Service
public class AdminCommentServiceImpl implements AdminCommentService{
	@Autowired
	private CommentsDao commentsDaoImpl;
	
	@Override
	public boolean write(CommentsVo commentsVo) {
		int insertedCount = commentsDaoImpl.insert(commentsVo);
		return insertedCount==1;
	}
	
}
