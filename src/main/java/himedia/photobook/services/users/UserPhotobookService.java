package himedia.photobook.services.users;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import himedia.photobook.repositories.dao.AlbumDao;
import himedia.photobook.repositories.dao.InventoryDao;
import himedia.photobook.repositories.dao.OrderDao;
import himedia.photobook.repositories.dao.PhotoDao;
import himedia.photobook.repositories.vo.AlbumVo;
import himedia.photobook.repositories.vo.InventoryVo;
import himedia.photobook.repositories.vo.OrdersVo;
import himedia.photobook.repositories.vo.PhotoVo;
import himedia.photobook.tools.FileModule;
import himedia.photobook.tools.VoConfiguration;

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

	private String DEFUALT_PATH = "C:/photobook/order/";
	private FileModule fileModule = new FileModule();
	private VoConfiguration voConfiguration = new VoConfiguration();

	public AlbumVo findAlbumIdByOptions(String material, String color, String albumSize) {
		AlbumVo albumVo = albumDaoImpl.findAlbumIdByOptions(material, color, albumSize);
		return albumVo;
	}

	public InventoryVo findAlbumPriceByAlbumId(String albumId) {
		InventoryVo inventoryVo = inventoryDaoImpl.findAlbumPriceByAlbumId(albumId);
		return inventoryVo;
	}

	public boolean orderInsert(String userId, String albumId, Long oQuantity, List<MultipartFile> files) {
		boolean result = 1 == orderDaoImpl.orderInsert(userId, albumId, oQuantity);
		OrdersVo orderVo = orderDaoImpl.selectRecentOrderByUserId(userId);
		PhotoVo photoVo = null;

		if (fileModule.getOsName().contains("nux")) {
			DEFUALT_PATH = "/photobook/album/";
		}

		if (orderVo != null) {
			String savePath = DEFUALT_PATH + userId + "/" + orderVo.getOrderId();
			Long number = 1l;

			for (MultipartFile file : files) {
				String originalFileName = file.getOriginalFilename();

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
				number = number + 1l;
			}
		}

		return result;
	}

	/**
	 * repositories의 VoConfiguration에를 참조하여 앨범의 속성을 불러와주는 메서드
	 */
	public Map<String, List<String>> getAlbumOptions() {
		Map<String, List<String>> albumOptions = new HashMap<String, List<String>>();

		albumOptions.put("colorList", voConfiguration.getAlbumColorList());
		albumOptions.put("materialList", voConfiguration.getAlbumMaterialList());
		albumOptions.put("sizeList", voConfiguration.getAlbumSizeList());

		return albumOptions;
	}
}