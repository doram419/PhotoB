package himedia.photobook.repositories.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import himedia.photobook.exceptions.UsersAlbumException;
import himedia.photobook.repositories.vo.AlbumVo;
import himedia.photobook.repositories.vo.InventoryVo;

@Repository
public class InventoryDaoImpl implements InventoryDao {
	@Autowired
	private SqlSession sqlSession;

	@Override
	public InventoryVo findAlbumPriceByAlbumId(String albumId) {
		Map<String, String> ai = new HashMap<>();
		ai.put("albumId", albumId);
		InventoryVo inventoryVo = sqlSession.selectOne("inventory.findAlbumPriceByAlbumId", ai);// xml수정필요

		return inventoryVo;
	}

	@Override
	public List<InventoryVo> listInventory() {
		return sqlSession.selectList("inventory.listInventory");
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
	public int update(InventoryVo inventoryVo) {
		return sqlSession.update("inventory.update", inventoryVo);
	}
	
	@Override
	public InventoryVo selectOneByAlbumId(String albumId) {
		return sqlSession.selectOne("inventory.selectOneByAlbumId", albumId);
	}
}
