package himedia.photobook.repositories.dao;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import himedia.photobook.repositories.vo.AlbumVo;
import himedia.photobook.exceptions.UsersAlbumException;

@Repository("albumsDao") 
public class AlbumDaoImpl implements AlbumDao {
	@Autowired
	private SqlSession sqlSession;
	 @Override	//옵션으로 앨범아이디 검색
	 public AlbumVo findAlbumIdByOptions(String material, String color, String albumSize) {
	        Map<String, String> options = new HashMap<>();
	        options.put("material", material);
	        options.put("color", color);
	        options.put("albumSize", albumSize);
	        AlbumVo albumVo = sqlSession.selectOne("album.findAlbumIdByOptions", options);
	        return albumVo;
	 }

	/**
	 * 앨범 ID로 album 튜플을 가져오는 메서드
	 * exception 처리 필요함
	 * */
	public AlbumVo selectOneById(String albumId){
		try {
			return sqlSession.selectOne("album.selectByID", albumId);
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new UsersAlbumException(
					"UserAlbumException::SelectOneById01 [에러 발생]");
		}
	}
}
