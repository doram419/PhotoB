package himedia.photobook.repositories.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import himedia.photobook.repositories.vo.OrdersVo;

@Repository("ordersDao")
public class OrderDaoImpl implements OrderDao {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int orderInsert(String userId, String albumId, Long oQuantity)	{
		System.out.println("sql전 userid"+userId);
		System.out.println("sql전 albumId"+albumId);
		System.out.println("sql전 oQuantity"+oQuantity);
		Map<String,Object> orderMap = new HashMap<>();
		orderMap.put("userId",userId);
		orderMap.put("albumId", albumId);
		orderMap.put("oQuantity", oQuantity);
		return sqlSession.insert("order.orderInsert",orderMap);
	}
}
