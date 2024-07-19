package himedia.photobook.repositories.dao;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import himedia.photobook.repositories.vo.AlbumVo;
import himedia.photobook.exceptions.UsersAlbumException;

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
	        System.out.println(albumVo);
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
	 @Override
	    public AlbumVo selectByAlbumId(String albumId) {
	        try {
	            return sqlSession.selectOne("album.selectByAlbumId", albumId);
	        } catch (Exception e) {
	            e.printStackTrace();
	            throw new UsersAlbumException("[에러 발생]");
	        }
	    }
}
