package himedia.photobook.services.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.photobook.repositories.dao.AlbumDao;
import himedia.photobook.repositories.dao.InventoryDao;
import himedia.photobook.repositories.dao.OrderDao;
import himedia.photobook.repositories.vo.AlbumVo;
import himedia.photobook.repositories.vo.InventoryVo;
import himedia.photobook.repositories.vo.OrdersVo;

@Service
public class UserPhotobookService {
	@Autowired
	private AlbumDao albumDaoImpl;
	@Autowired
	private InventoryDao inventoryDaoImpl;
	@Autowired
	private OrderDao orderDaoImpl;

	public AlbumVo findAlbumIdByOptions(String material, String color, String albumSize) {
		AlbumVo albumVo = albumDaoImpl.findAlbumIdByOptions(material, color, albumSize);
		return albumVo;
	}

	public InventoryVo findAlbumPriceByAlbumId(String albumId) {
		InventoryVo inventoryVo = inventoryDaoImpl.findAlbumPriceByAlbumId(albumId);
		return inventoryVo;
	}
	public int orderInsert(String userId, String albumId, Long oQuantity) {
	    return orderDaoImpl.orderInsert(userId,albumId,oQuantity);
  }
}