package himedia.photobook.repositories.dao;

import java.util.List;

import himedia.photobook.repositories.vo.OrdersVo;

public interface OrderDao {
	public int orderInsert(String userId, String albumId, Long oQuantity);	// 주문생성
	public List<OrdersVo> selectAllOrdersByUserId(String userId);

}
