package himedia.photobook.services.admin;

import java.util.List;
import java.util.Map;

import himedia.photobook.repositories.vo.AlbumVo;
import himedia.photobook.repositories.vo.InventoryVo;

public interface AdminProductService {
	// 앨범 및 가격 목록
	public List<AlbumVo> searchAlbum(String searchCategory, String keyword);
	public List<InventoryVo> listInventory();
	public Map<AlbumVo, InventoryVo> getAlbumInventoryMap();
	// 앨범 및 가격 수정
//	public void updateAlbum(AlbumVo vo);
//	public void updateInventory(InventoryVo vo);
//	// 앨범 삭제
//	public void deleteAlbum(String albumId);
//	public void deleteInventory(Long albumPrice);
//	// 앨범 추가
//	public void insertAlbum(AlbumVo vo);
//	public void insertInventory(InventoryVo vo);
//	
	

}
