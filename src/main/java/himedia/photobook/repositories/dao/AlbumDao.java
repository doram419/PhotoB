package himedia.photobook.repositories.dao;

import java.util.List;

import himedia.photobook.repositories.vo.AlbumVo;

public interface AlbumDao {
	/**
	 * 옵션으로 앨범아이디 검색
	 */
	public AlbumVo findAlbumIdByOptions(String material, String color, String albumSize);

	/**
	 * 앨범 ID로 album 튜플을 가져오는 메서드 exception 처리 필요함
	 */
	public AlbumVo selectOneById(String albumId);

	public List<AlbumVo> searchAlbum(String keyword);

	public List<AlbumVo> selectAll();

	// 주문번호로 상품 옵션을 들고오는 메서드
	public String findOptionsByOrderId(String orderId);

	public AlbumVo selectByAlbumId(String albumId);

	public int updateAlbum(AlbumVo vo);

	public void deleteAlbum(String albumId);

	public int insertAlbum(AlbumVo vo);

}
