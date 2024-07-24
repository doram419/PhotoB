package himedia.photobook.services.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.photobook.repositories.dao.InventoryDao;
import himedia.photobook.repositories.vo.InventoryVo;

@Service
public class AdminInventoryServiceImpl implements AdminInventoryService {
	@Autowired
	private InventoryDao inventoryDaoImpl;
	
	@Override
	public List<InventoryVo> getInvenInfos() {
		List<InventoryVo> invenList = inventoryDaoImpl.listInventory();
		return invenList;

	}

	@Override
	public InventoryVo findAlbumPriceByAlbumId(String albumId) {
		InventoryVo inventoryVo = inventoryDaoImpl.findAlbumPriceByAlbumId(albumId);
		System.out.println("service:"+inventoryVo);
		return inventoryVo;
	}

	@Override
	public boolean updateQuantity(InventoryVo inventoryVo) {
		InventoryVo invenVo = inventoryDaoImpl.findAlbumPriceByAlbumId(inventoryVo.getAlbumId());
		
//		Long originQ = invenVo.getaQuantity();
//		Long changeQ = inventoryVo.getaQuantity()+originQ;
//		inventoryVo.setaQuantity(changeQ);
		inventoryVo.setaQuantity(inventoryVo.getaQuantity() + invenVo.getaQuantity());
		
		int updatedCount = inventoryDaoImpl.updateQuantity(inventoryVo);
		return updatedCount == 1;
	}
	
	
}
