package himedia.photobook.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.photobook.repositories.dao.AlbumDao;
import himedia.photobook.repositories.dao.InventoryDao;
import himedia.photobook.repositories.dao.OrderDao;
import himedia.photobook.repositories.vo.AlbumVo;
import himedia.photobook.repositories.vo.InventoryVo;
import himedia.photobook.repositories.vo.OrdersVo;

@Service("userPhotobookService")
public class UserPhotobookService {
	@Autowired
	private AlbumDao albumsDao;
	@Autowired
	private InventoryDao inventorysDao;
	@Autowired
	private OrderDao ordersDao;

	public AlbumVo findAlbumIdByOptions(String material, String color, String albumSize) {
		AlbumVo albumVo = albumsDao.findAlbumIdByOptions(material, color, albumSize);
		return albumVo;
	}

	public InventoryVo findAlbumPriceByAlbumId(String albumId) {
		InventoryVo inventoryVo = inventorysDao.findAlbumPriceByAlbumId(albumId);
		return inventoryVo;
	}
	public int orderInsert(String userId, String albumId, Long oQuantity) {
	    return ordersDao.orderInsert(userId,albumId,oQuantity);
	}
}
