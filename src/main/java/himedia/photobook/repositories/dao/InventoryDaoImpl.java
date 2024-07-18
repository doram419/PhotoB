package himedia.photobook.repositories.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import himedia.photobook.repositories.vo.InventoryVo;
import himedia.photobook.repositories.vo.OrdersVo;

@Repository
public class InventoryDaoImpl implements InventoryDao {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public InventoryVo findAlbumPriceByAlbumId(String albumId)	{
		Map<String,String> ai = new HashMap<>();
		ai.put("albumId",albumId);
		InventoryVo inventoryVo = sqlSession.selectOne("inventory.findAlbumPriceByAlbumId",ai);// xml수정필요
		
		return inventoryVo;
	}
}
