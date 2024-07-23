package himedia.photobook.services.admin;

import java.util.List;
import java.util.Map;

import himedia.photobook.repositories.vo.InventoryVo;

public interface AdminInventoryService {
	public List<InventoryVo> getInvenInfos();
}
