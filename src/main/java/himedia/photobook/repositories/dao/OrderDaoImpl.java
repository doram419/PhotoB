package himedia.photobook.repositories.dao;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import himedia.photobook.repositories.vo.OrdersVo;

@Repository("orderDaoImpl")
public class OrderDaoImpl implements OrderDao {
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int orderInsert(String userId, String albumId, Long oQuantity)	{
		Map<String,Object> orderMap = new HashMap<>();
		orderMap.put("userId",userId);
		orderMap.put("albumId", albumId);
		orderMap.put("oQuantity", oQuantity);
		
		return sqlSession.insert("order.orderInsert",orderMap);
	}
	
	@Override
	public List<OrdersVo> selectAllOrdersByUserId(String userId){
		return sqlSession.selectList("order.selectAllOrdersByUserId", userId);
	}

	@Override
	public List<OrdersVo> selectAllOrders(){
		return sqlSession.selectList("order.selectAllOrders");
	}
	
	@Override
	public OrdersVo selectByOrderId(String orderId) {
		return sqlSession.selectOne("order.selectByOrderId", orderId);
	}
	
//	@Override
//	public List<OrdersVo> searchOrders(Map<String, Object> params) {
//	    System.out.println("sql전 keyword:" + params.get("keyword"));
//	    return sqlSession.selectList("order.searchOrders", params);
//	}
	// 이름으로 userId찾는 메서드
	@Override
	public String getUserIdByUserName(String keyword) {
		return sqlSession.selectOne("users.getUserIdByUserName",keyword);
	}
	
	public String getAlbumIdByOrderId(String orderId)	{
		return sqlSession.selectOne("order.getAlbumIdByOrderId",orderId);
		}

	@Override
	public int updateByOrderId(String updateId, OrdersVo ordersVo) {
		Map<String, Object> updateMap = new HashMap<String, Object>();
		updateMap.put("updateId", updateId);
		updateMap.put("orderId", ordersVo.getOrderId());
		updateMap.put("albumId", ordersVo.getAlbumId());
		updateMap.put("orderDate", ordersVo.getOrderDate());
		updateMap.put("oQuantity", ordersVo.getoQuantity());
		updateMap.put("total", ordersVo.getTotal());
		
		return sqlSession.update("order.updateByOrderId", 
				updateMap);

	}
	public String count()	{
		return sqlSession.selectOne("order.countOrder");
	}
	public Map<String, Object> Salecount()	{
		return sqlSession.selectOne("order.countSale");
	}
}
