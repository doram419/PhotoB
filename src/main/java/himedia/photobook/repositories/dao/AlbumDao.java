package himedia.photobook.repositories.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import himedia.photobook.repositories.vo.AlbumVo;
@Mapper
public interface AlbumDao {
	
public	AlbumVo findAlbumIdByOptions(String material, String albumSize, String color);
// album_id 조회하는데 씁니다.
}
