package himedia.photobook.repositories.dao;

import java.util.List;

import himedia.photobook.repositories.vo.InventoryVo;

public interface InventoryDao {
// albumid로 앨범 가격 조회
	
public InventoryVo findAlbumPriceByAlbumId(String albumId);

	// 앨범 가격 목록
	public List<InventoryVo> listInventory();
	// 앨범 가격 수정
	public void updateInventory(InventoryVo vo);
	// 앨범 가격 삭제
	public void deleteInventory(Long albumPrice);
	// 앨범 가격 추가
	public void insertInventory(InventoryVo vo);
}

