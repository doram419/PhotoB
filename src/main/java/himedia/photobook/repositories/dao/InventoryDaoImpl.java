package himedia.photobook.repositories.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import himedia.photobook.repositories.vo.InventoryVo;

@Repository
public class InventoryDaoImpl implements InventoryDao {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public InventoryVo findAlbumPriceByAlbumId(String albumId)	{
		Map<String,String> ai = new HashMap<>();
		ai.put("albumId",albumId);
		System.out.println("sql들어가기전 ai"+ai);
		InventoryVo inventoryVo = sqlSession.selectOne("inventory.findAlbumPriceByAlbumId",ai);// xml수정필요
		
		return inventoryVo;
	}
	
	// 앨범 목록
		@Override
		public List<InventoryVo> listInventory() {
			return sqlSession.selectList("product.listInventory");
		}
		
		// 앨범 수정
		@Override
		public void updateInventory(InventoryVo vo) {
			sqlSession.update("product.updateInventory", vo);
		}
		// 앨범 삭제
		@Override
		public void deleteInventory(Long albumPrice) {
			sqlSession.delete("product.deleteInventory", albumPrice);
		}
		// 앨범 추가
		@Override
		public void insertInventory(InventoryVo vo) {
			sqlSession.insert("product.insertInventory", vo);
		}
}
