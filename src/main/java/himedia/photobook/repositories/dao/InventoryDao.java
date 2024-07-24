package himedia.photobook.repositories.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import himedia.photobook.repositories.vo.InventoryVo;

public interface InventoryDao {
// albumid로 앨범 가격 조회
	
public InventoryVo findAlbumPriceByAlbumId(String albumId);


	public List<InventoryVo> listInventory();

	public int updateQuantity(InventoryVo vo);


	public int updateAlbum(InventoryVo vo);


	public List<InventoryVo> listPage(RowBounds rowBounds);


//	public List<InventoryVo> listPage(int offset, int limit);







	
}

