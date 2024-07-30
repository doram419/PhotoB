package himedia.photobook.repositories.dao;

import himedia.photobook.repositories.vo.AlbumPhotoVo;

public interface AlbumPhotoDao {
	/**
	 * AlbumPhotoVo를 받아서 튜플을 생성해주는 메서드 
	 * */
	public int insert(AlbumPhotoVo albumPhotoVo);
	/**
	 * AlbumPhotoVo를 받아서 해당 albumId와 일치하는 튜플의 경로를 생성해주는 메서드 
	 * */
	int updatePath(AlbumPhotoVo albumPhotoVo);
	/**
	 * 해당 albumId와 일치하는 튜플의 경로를 가져오는 메서드
	 * */
	public String getAlbumPhotoPath(String albumId);
}
