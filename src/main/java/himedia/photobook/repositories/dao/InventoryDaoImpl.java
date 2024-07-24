package himedia.photobook.repositories.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import himedia.photobook.exceptions.UsersAlbumException;
import himedia.photobook.repositories.vo.InventoryVo;

@Repository
public class InventoryDaoImpl implements InventoryDao {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<InventoryVo> listInventory() {
		
		return sqlSession.selectList("inventory.listInventory");
	}
	@Override
	public InventoryVo findAlbumPriceByAlbumId(String albumId) {
		Map<String, String> ai = new HashMap<>();
		ai.put("albumId", albumId);
		InventoryVo inventoryVo = sqlSession.selectOne("inventory.findAlbumPriceByAlbumId", ai);// xml수정필요

		return inventoryVo;
	}


	@Override
	public int updateAlbum(InventoryVo vo) {
		try {
			int updatedCount = sqlSession.update("album.updateAlbum", vo);
			return updatedCount;
		} catch (Exception e) {
			e.printStackTrace();
			throw new UsersAlbumException("업데이트 도중 예외 발생!");
		}
	}

	@Override
	public int updateQuantity(InventoryVo vo) {
		return sqlSession.update("inventory.updateQuantity",vo);
	}
	@Override
	public List<InventoryVo> listPage(RowBounds rowBounds) {
		 return sqlSession.selectList("inventory.listInventory", null, rowBounds);
	}
}
