package himedia.photobook.repositories.dao;

import himedia.photobook.repositories.vo.AlbumVo;

public interface AlbumDao {

public	AlbumVo findAlbumIdByOptions(String material, String albumSize, String color);

// album_id 조회하는데 씁니다.
}
