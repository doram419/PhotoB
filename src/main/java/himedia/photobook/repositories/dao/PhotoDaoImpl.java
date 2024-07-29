package himedia.photobook.repositories.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import himedia.photobook.repositories.vo.PhotoVo;

@Repository("photoDaoImpl")
public class PhotoDaoImpl implements PhotoDao {
	@Autowired
	private SqlSession session;
	
	@Override
	public int insert(PhotoVo photoVo){
		return session.insert("photo.insert", photoVo);
	}
	
	@Override
	public int selectCountByOrderId(String orderId) {
		return session.selectOne("photo.selectCountByOrderId", orderId);
	}
}
