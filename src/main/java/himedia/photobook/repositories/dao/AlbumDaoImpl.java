package himedia.photobook.repositories.dao;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Repository;

import himedia.photobook.repositories.vo.AlbumVo;

@Repository("albumsDao") 
public class AlbumDaoImpl implements AlbumDao {
	@Autowired
	private SqlSession sqlSession;
	
	 @Override	//옵션으로 앨범아이디 검색
	 public AlbumVo findAlbumIdByOptions(String material, String albumSize, String color) {
	        Map<String, String> options = new HashMap<>();
	        options.put("material", material);
	        options.put("albumSize", albumSize);
	        options.put("color", color);
	        
	        AlbumVo albumVo = sqlSession.selectOne("album.findAlbumIdByOptions", options);
	        System.out.println("sql쿼리문 거친 albumVo:"+albumVo);
	        return albumVo;
	 }

}
