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
public class AdminProductServiceImpl implements AdminProductService {
	
	@Autowired
	private AlbumDao AlbumDao;
	
	@Autowired
	private InventoryDao InventoryDao;
	
	// 앨범목록
	@Override
	public List<AlbumVo> searchAlbum(String searchCategory, String keyword) {
		return AlbumDao.searchAlbum(keyword);
	}
	// 앨범가격 목록
	@Override
	public List<InventoryVo> listInventory() {
		return InventoryDao.listInventory();
	}
	
	public Map<AlbumVo, InventoryVo> getAlbumInventoryMap() {
        List<AlbumVo> albums = AlbumDao.findAll();
        List<InventoryVo> inventoryList = InventoryDao.listInventory();

        Map<AlbumVo, InventoryVo> albumInventoryMap = new HashMap<>();

        for (AlbumVo album : albums) {
            for (InventoryVo inventory : inventoryList) {
                if (album.getAlbumId().equals(inventory.getAlbumId())) {
                    albumInventoryMap.put(album, inventory);
                    break;
                }
            }
        }
        
        return albumInventoryMap;
    }
	// 앨범수정
//	@Override
//	public void updateAlbum(AlbumVo vo) {
//		AlbumDao.updateAlbum(vo);
//		
//	}
//	// 앨범가격 수정
//	@Override
//	public void updateInventory(InventoryVo vo) {
//		InventoryDao.updateInventory(vo);
//		
//	}
//	// 앨범삭제
//	@Override
//	public void deleteAlbum(String albumId) {
//		AlbumDao.deleteAlbum(albumId);
//		
//	}
//	// 앨범가격 삭제
//	@Override
//	public void deleteInventory(Long albumPrice) {
//		InventoryDao.deleteInventory(albumPrice);
//		
//	}
//	// 앨범추가
//	@Override
//	public void insertAlbum(AlbumVo vo) {
//		AlbumDao.insertAlbum(vo);
//		
//	}
//	// 앨범가격 추가
//	@Override
//	public void insertInventory(InventoryVo vo) {
//		InventoryDao.insertInventory(vo);
//		
//	}
//	
}
