package himedia.photobook.repositories.dao;

import himedia.photobook.repositories.vo.InventoryVo;

public interface InventoryDao {
	// albumId로 앨범 가격 조회
	public InventoryVo findAlbumPriceByAlbumId(String albumId);
}
