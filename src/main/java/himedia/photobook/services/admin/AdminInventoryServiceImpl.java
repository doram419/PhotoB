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

}
