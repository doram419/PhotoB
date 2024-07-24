package himedia.photobook.services.admin;

import java.util.List;
import java.util.Map;

import himedia.photobook.repositories.vo.InventoryVo;

public interface AdminInventoryService {
	public List<InventoryVo> getInvenInfos();
//	public List<InventoryVo> getContentByPrice(Long price);
	public InventoryVo findAlbumPriceByAlbumId(String albumId);
	public boolean updateQuantity(InventoryVo inventoryVo);
}
