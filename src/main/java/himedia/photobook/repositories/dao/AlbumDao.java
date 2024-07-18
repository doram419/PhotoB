package himedia.photobook.repositories.dao;

import java.util.List;


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
	
	// 앨범 목록
	public List<AlbumVo> searchAlbum(String keyword);
	// 앨범 수정
	public void updateAlbum(AlbumVo vo);
	// 앨범 삭제
	public void deleteAlbum(String albumId);
	// 앨범 추가
	public void insertAlbum(AlbumVo vo);
	
	
	
}
