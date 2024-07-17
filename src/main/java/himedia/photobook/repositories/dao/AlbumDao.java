package himedia.photobook.repositories.dao;

import himedia.photobook.repositories.vo.AlbumVo;

public interface AlbumDao {

public	AlbumVo findAlbumIdByOptions(String material, String color,String albumSize);

// album_id 조회하는데 씁니다.
}
