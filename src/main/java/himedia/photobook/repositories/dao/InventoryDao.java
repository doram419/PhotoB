package himedia.photobook.repositories.dao;

import java.util.List;

import himedia.photobook.repositories.vo.InventoryVo;

public interface InventoryDao {
// albumid로 앨범 가격 조회
	
public InventoryVo findAlbumPriceByAlbumId(String albumId);

	// 앨범 가격 목록
/**
 * 	앨범 목록 가져오기
 * */
	public List<InventoryVo> listInventory();
	public int updateProduct(InventoryVo vo);
	public void deleteProduct(Long albumPrice);
	public int insertProduct(InventoryVo vo);
}

