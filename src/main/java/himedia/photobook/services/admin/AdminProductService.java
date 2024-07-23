package himedia.photobook.services.admin;

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

    public List<InventoryVo> listInventory() {
        return inventoryDaoImpl.listInventory();
    }
    
    /**
     * 제품 관리에 필요한 정보
     * */

    public Map<String, Object> getProductMap(String keyword) {
        List<AlbumVo> albums;
        
        if (keyword != null && !keyword.isEmpty()) {
            albums = albumDaoImpl.searchAlbum(keyword);
        } else {
            albums = albumDaoImpl.selectAll(); // 모든 앨범 가져오기
        }
        
        List<InventoryVo> inventoryList = inventoryDaoImpl.listInventory();
        
        Map<String, InventoryVo> inventoryMap = new HashMap<>();
        for (InventoryVo inventory : inventoryList) {
            inventoryMap.put(inventory.getAlbumId(), inventory);
        }
        
        Map<String, Object> productMap = new HashMap<String, Object>();
        for (AlbumVo album : albums) {
            InventoryVo inventory = inventoryMap.get(album.getAlbumId());
            if (inventory != null) {
                Map<String, Object> productPair = new HashMap<>();
                productPair.put("album", album);
                productPair.put("inventory", inventory);
                
                productMap.put(album.getAlbumId(), productPair);
            }
        }

        return productMap;
    }
    
 	public boolean updateProduct(AlbumVo vo) {
 		int updatedCount = albumDaoImpl.updateProduct(vo);
 		return updatedCount == 1;
 	}
 	
 	public boolean updateProduct(InventoryVo vo) {
 		int updatedCount = inventoryDaoImpl.updateProduct(vo);
 		return updatedCount == 1;
 	}
 	
 	public void deleteProduct(String albumId) {
 		albumDaoImpl.deleteProduct(albumId);
 	}
 	
 	public void deleteProduct(Long albumPrice) {
 		inventoryDaoImpl.deleteProduct(albumPrice);
 	}

 	public boolean insertProduct(AlbumVo vo) {
 		return albumDaoImpl.insertProduct(vo) == 1;	
 	}
 	
 	public boolean insertProduct(InventoryVo vo) {
 		return inventoryDaoImpl.insertProduct(vo) == 1;	
 	}
}
