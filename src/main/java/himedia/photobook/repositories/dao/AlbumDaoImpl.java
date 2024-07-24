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
	public AlbumVo selectOneById(String albumId) {
		try {
			return sqlSession.selectOne("album.selectByID", albumId);

		} catch (Exception e) {
			e.printStackTrace();
			throw new UsersAlbumException("UserAlbumException::SelectOneById01 [에러 발생]");
		}
	}

	// 앨범 목록
	@Override
	public List<AlbumVo> searchAlbum(String keyword) {
		return sqlSession.selectList("album.albumList", keyword);
	}

	@Override
	public List<AlbumVo> selectAll() {
		return sqlSession.selectList("album.selectAll");
	}

	 @Override
	 public String findOptionsByOrderId(String orderId)	{
		 return sqlSession.selectOne("album.findOptionsByOrderId", orderId);
	 }

	@Override
	public AlbumVo selectByAlbumId(String albumId) {
		try {
			return sqlSession.selectOne("album.selectByAlbumId", albumId);
		} catch (Exception e) {
			e.printStackTrace();
			throw new UsersAlbumException("[에러 발생]");
		}
	}

	@Override
	public int updateAlbum(AlbumVo albumVo) {
		try {
            int updatedCount = sqlSession.update("album.updateAlbum", albumVo);
            return updatedCount;
		} catch (Exception e) {
        	e.printStackTrace();
            throw new UsersAlbumException("업데이트 도중 예외 발생!");
        }
	}

	@Override
	public int delete(String albumId) {
		return sqlSession.delete("album.deleteAlbum", albumId);
	}
	
	@Override
	public int insertAlbum(AlbumVo vo) {
		return sqlSession.insert("album.insertAlbum", vo);
	}

}
