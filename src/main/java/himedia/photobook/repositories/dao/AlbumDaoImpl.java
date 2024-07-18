package himedia.photobook.repositories.dao;
import java.util.HashMap;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import himedia.photobook.exceptions.UsersAlbumException;
import himedia.photobook.repositories.vo.AlbumVo;

@Repository
public class AlbumDaoImpl implements AlbumDao {
	@Autowired
	private SqlSession sqlSession;
	
	@Override	
	 public AlbumVo findAlbumIdByOptions(String material, String color, String albumSize) {
	        Map<String, String> options = new HashMap<>();
	        options.put("material", material);
	        options.put("color", color);
	        options.put("albumSize", albumSize);
	        AlbumVo albumVo = sqlSession.selectOne("album.findAlbumIdByOptions", options);
	        return albumVo;
	 }

	@Override
	public AlbumVo selectOneById(String albumId){
		try {
			return sqlSession.selectOne("album.selectByID", albumId);
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new UsersAlbumException(
					"UserAlbumException::SelectOneById01 [에러 발생]");
		}
	}
	
	// 앨범 목록
	@Override
	public List<AlbumVo> searchAlbum(String keyword) {
		return sqlSession.selectList("album.albumList");
	}
	
	@Override
    public List<AlbumVo> findAll() {
		return sqlSession.selectList(".findAll");
	}
	
	// 앨범 수정
	@Override
	public void updateAlbum(AlbumVo vo) {
		sqlSession.update("album.updateAlbum", vo);
	}
	// 앨범 삭제
	@Override
	public void deleteAlbum(String albumId) {
		sqlSession.delete("album.deleteAlbum", albumId);
	}
	// 앨범 추가
	@Override
	public void insertAlbum(AlbumVo vo) {
		sqlSession.insert("album.insertAlbum", vo);
	}
	
}
