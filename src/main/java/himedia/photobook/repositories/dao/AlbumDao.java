package himedia.photobook.repositories.dao;

import himedia.photobook.repositories.vo.AlbumVo;

public interface AlbumDao {
	/**
	 * 옵션으로 앨범아이디 검색
	 * */
	public	AlbumVo findAlbumIdByOptions(String material, String color,String albumSize);
	/**
	 * 앨범 ID로 album 튜플을 가져오는 메서드
	 * exception 처리 필요함
	 * */
	public AlbumVo selectOneById(String albumId);

	
	 public AlbumVo selectByAlbumId(String albumId);
}



