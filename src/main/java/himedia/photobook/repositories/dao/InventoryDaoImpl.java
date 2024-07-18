package himedia.photobook.repositories.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import himedia.photobook.repositories.vo.InventoryVo;
import himedia.photobook.repositories.vo.OrdersVo;

@Repository("inventorysDao")
public class InventoryDaoImpl implements InventoryDao {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public InventoryVo findAlbumPriceByAlbumId(String albumId)	{
		Map<String,String> ai = new HashMap<>();
		System.out.println("put하기 전 albumId"+albumId);
		ai.put("albumId",albumId);
		System.out.println("sql들어가기전 ai"+ai);
		InventoryVo inventoryVo = sqlSession.selectOne("inventory.findAlbumPriceByAlbumId",ai);// xml수정필요
		
		return inventoryVo;
	}
}
