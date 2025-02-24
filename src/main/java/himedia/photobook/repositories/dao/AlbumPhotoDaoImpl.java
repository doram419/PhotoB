package himedia.photobook.repositories.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import himedia.photobook.repositories.vo.AlbumPhotoVo;

@Repository
public class AlbumPhotoDaoImpl implements AlbumPhotoDao {
	@Autowired
	private SqlSession session;

	@Override
	public int insert(AlbumPhotoVo albumPhotoVo) {
		return session.insert("albumPhoto.insert", albumPhotoVo);
	}

	@Override
	public int updatePath(AlbumPhotoVo albumPhotoVo) {
		return session.insert("albumPhoto.updatePath", albumPhotoVo);
	}

	@Override
	public String getAlbumPhotoPath(String albumId) {
		return session.selectOne("albumPhoto.getAlbumPhotoPath", albumId);

	}
}
