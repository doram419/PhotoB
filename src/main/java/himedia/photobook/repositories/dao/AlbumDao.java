package himedia.photobook.repositories.dao;

import java.util.List;

import himedia.photobook.repositories.vo.AlbumVo;

public interface AlbumDao {
	// 앨범 전체 조회
	public List<AlbumVo> getAllAlbum(AlbumVo albumVo);
	// 앨범 상세 조회
	public AlbumVo getOneAlbum(String color);
	// 앨범 추가
	public int insertAlbum(AlbumVo albumVo);
}
