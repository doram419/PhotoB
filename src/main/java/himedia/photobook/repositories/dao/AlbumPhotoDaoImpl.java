package himedia.photobook.repositories.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import himedia.photobook.repositories.vo.AlbumPhotoVo;

@Repository
public class AlbumPhotoDaoImpl implements AlbumPhotoDao{
	@Autowired
	private SqlSession session;
	
	@Override
	public int insert(AlbumPhotoVo albumPhotoVo) {
		return session.insert("albumPhoto.insert", albumPhotoVo);
	}

}
