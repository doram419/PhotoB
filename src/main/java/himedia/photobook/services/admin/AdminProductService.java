package himedia.photobook.services.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.photobook.repositories.dao.AlbumDao;
import himedia.photobook.repositories.dao.InventoryDao;
import himedia.photobook.repositories.vo.AlbumVo;
import himedia.photobook.repositories.vo.InventoryVo;

@Service
public class AdminProductService {

    @Autowired
    private AlbumDao albumDaoImpl;

    @Autowired
    private InventoryDao inventoryDaoImpl;
    
    // 앨범 및 가격 목록
    public List<AlbumVo> searchAlbum(String searchCategory, String keyword) {
      return albumDaoImpl.searchAlbum(keyword);
    }
    
    /**
   * 제품 관리에 필요한 정보
   * */
    public List<Map<String, Object>>getProductInfos() {
    	List<Map<String, Object>> productInfoList = new ArrayList<Map<String, Object>>();
    	List<AlbumVo> albumlist = albumDaoImpl.selectAll();
    	
    	for(AlbumVo albumVo : albumlist) {
    		Map<String, Object> productMap = new HashMap<String, Object>();
    		InventoryVo inventoryVo = inventoryDaoImpl.selectOneByAlbumId(albumVo.getAlbumId());
    		
    		productMap.put("albumVo", albumVo);
    		productMap.put("inventoryVo", inventoryVo);
    		
    		productInfoList.add(productMap);
    		
    	}
    	
    	return productInfoList;
    }
    
    /**
     * 제품 관리에 필요한 정보
     * */
      public List<Map<String, Object>>getProductInfos(String keyword) {
      	List<Map<String, Object>> productInfoList = new ArrayList<Map<String, Object>>();
      	List<AlbumVo> albumlist = albumDaoImpl.searchAlbum(keyword);
      	
      	for(AlbumVo albumVo : albumlist) {
      		Map<String, Object> productMap = new HashMap<String, Object>();
      		InventoryVo inventoryVo = inventoryDaoImpl.selectOneByAlbumId(albumVo.getAlbumId());
      		
      		productMap.put("albumVo", albumVo);
      		productMap.put("inventoryVo", inventoryVo);
      		
      		productInfoList.add(productMap);
      		
      	}
      	
      	return productInfoList;
     }
    
    public Map<String, Object> getAlbumInfoMap(String albumId) {
        AlbumVo albumVo = albumDaoImpl.selectByAlbumId(albumId);
        InventoryVo inventory = inventoryDaoImpl.selectOneByAlbumId(albumId);
    	
        Map<String, Object> productMap = new HashMap<String, Object>();
        
        if (inventory != null) {
        	productMap.put("album", albumVo);
        	productMap.put("inventory", inventory);
        }

        return productMap;
    }
    
    public boolean updateProduct(AlbumVo albumVo, Long albumPrice) {
 		int updatedCount = albumDaoImpl.updateAlbum(albumVo);
 		InventoryVo inventoryVo = new InventoryVo();
 		inventoryVo.setAlbumPrice(albumPrice);
 		inventoryVo.setAlbumId(albumVo.getAlbumId());
 		
 		inventoryDaoImpl.updateProduct(inventoryVo);
 		return updatedCount == 1;
 	}
    
 	public boolean deleteProduct(String albumId) {
    	return (1 == inventoryDaoImpl.delete(albumId)) && (1 == albumDaoImpl.delete(albumId));
	}
 	
 	public boolean insertProduct(AlbumVo albumVo, Long albumPrice) {
 		int albumInsertedCount = albumDaoImpl.insertAlbum(albumVo);
 		
 		InventoryVo inventoryVo = new InventoryVo();
 		inventoryVo.setAlbumId(albumVo.getAlbumId());
 		inventoryVo.setAlbumPrice(albumPrice);
 		inventoryVo.setaQuantity(0l);
 		int inventoryInsertedCount = inventoryDaoImpl.insertInventory(inventoryVo);
 		
 		return (1 == albumInsertedCount) && (1 == inventoryInsertedCount);
	}

    
//    public List<InventoryVo> listInventory() {
//        return inventoryDaoImpl.listInventory();
//    }
//    
// 	
// 	public boolean updateProduct(InventoryVo vo) {
// 		int updatedCount = inventoryDaoImpl.updateProduct(vo);
// 		return updatedCount == 1;
// 	}

// 	public void deleteProduct(Long albumPrice) {
// 		inventoryDaoImpl.deleteProduct(albumPrice);
// 	}
//
// 	public boolean insertProduct(InventoryVo vo) {
// 		return inventoryDaoImpl.insertProduct(vo) == 1;	
// 	}
}
