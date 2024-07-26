package himedia.photobook.repositories.dao;

import himedia.photobook.repositories.vo.AlbumPhotoVo;

public interface AlbumPhotoDao {
	/**
	 * AlbumPhotoVo를 받아서 튜플을 생성해주는 메서드 
	 * */
	public int insert(AlbumPhotoVo albumPhotoVo);
}
