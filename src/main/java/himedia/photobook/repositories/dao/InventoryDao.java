package himedia.photobook.repositories.dao;

import java.util.List;

import himedia.photobook.repositories.vo.InventoryVo;

public interface InventoryDao {
	// 재고 전체 조회
	public List<InventoryVo> getAllInventory(InventoryVo inventoryVo);
	// 재고 상세 조회
	public InventoryVo getOneInventory(String albumId);
	// 등록
	public int insertAlbum(InventoryVo inventoryVo);
	// 재고 차감 
	
}
