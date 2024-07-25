package himedia.photobook.repositories.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import himedia.photobook.repositories.vo.InventoryVo;

public interface InventoryDao {
// albumid로 앨범 가격 조회
	
public InventoryVo findAlbumPriceByAlbumId(String albumId);


	public List<InventoryVo> listInventory();






	public List<InventoryVo> listPage(RowBounds rowBounds);


	public int getTotalCount();







	

	public int updateProduct(InventoryVo vo);
	public int delete(String albumId);
	/**
	 * 파라미터로 들어오는 inventoryVo의 albumId와 일치하는 튜플을 찾아,
	 * 그 개수(quantity)를 바꿔주는 메서드
	 * Param : InventoryVo inventoryVo - 경감시킬 albumId와 개수가 든 inventoryVo
	 * return : 영향 받은 튜플 수
	 * */
	public int updateQuantity(InventoryVo inventoryVo);
	/**
	 * albumId로 Inventory를 가져오는 메서드
	 * Param : String albumId - albumId와 일치하는 Inventory 튜플을 가져옴
	 * return : InventoryVo - 일치하는 튜플
	 * */
	public InventoryVo selectOneByAlbumId(String albumId);
	public int insertInventory(InventoryVo inventoryVo);


}

