package himedia.photobook.services.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import himedia.photobook.controllers.FileModule;
import himedia.photobook.repositories.dao.AlbumDao;
import himedia.photobook.repositories.dao.InventoryDao;
import himedia.photobook.repositories.dao.OrderDao;
import himedia.photobook.repositories.dao.PhotoDao;
import himedia.photobook.repositories.vo.AlbumVo;
import himedia.photobook.repositories.vo.InventoryVo;
import himedia.photobook.repositories.vo.OrdersVo;
import himedia.photobook.repositories.vo.PhotoVo;

@Service
public class UserPhotobookService {
	@Autowired
	private AlbumDao albumDaoImpl;
	@Autowired
	private InventoryDao inventoryDaoImpl;
	@Autowired
	private OrderDao orderDaoImpl;
	@Autowired
	private PhotoDao photoDaoImpl;
	
	private static String DEFUALT_PATH = "C:/photobook/order/";
	private FileModule fileModule = new FileModule();

	public AlbumVo findAlbumIdByOptions(String material, String color, String albumSize) {
		AlbumVo albumVo = albumDaoImpl.findAlbumIdByOptions(material, color, albumSize);
		return albumVo;
	}

	public InventoryVo findAlbumPriceByAlbumId(String albumId) {
		InventoryVo inventoryVo = inventoryDaoImpl.findAlbumPriceByAlbumId(albumId);
		return inventoryVo;
	}
	
	public boolean orderInsert(String userId, String albumId, Long oQuantity, 
			MultipartFile file) {
		boolean result = 1 == orderDaoImpl.orderInsert(userId,albumId,oQuantity);
		OrdersVo orderVo = orderDaoImpl.selectRecentOrderByUserId(userId);
		PhotoVo photoVo = null;
		
		if(orderVo != null) {
			String savePath = DEFUALT_PATH + userId + "/" + orderVo.getOrderId();
			String originalFileName = file.getOriginalFilename();
			
			Long number = 1l;
			String extName = originalFileName.substring(originalFileName.lastIndexOf(".")); 
			String photoPath = null;
			try {
				photoPath = fileModule.saveFile(file, savePath, number.toString(), extName);
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: 에러 연결하기
			}
			photoVo = new PhotoVo(null, orderVo.getOrderId(), photoPath, number.longValue());
			
			result = result && (1 == photoDaoImpl.insert(photoVo));
			
		}
		
	    return result;
	}
	
	
}