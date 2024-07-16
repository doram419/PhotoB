package himedia.photobook.repositories.dao;


import java.util.Date;
import java.util.List;

import himedia.photobook.repositories.vo.OrdersVo;


public interface OrdersDao {
	// 주문 전체 조회
	public List<OrdersVo> getAllOrders(OrdersVo ordersVo);
	// 주문 상세 조회
	public OrdersVo getOneOrders(String orderId);
	// 주문 등록
	public int insertOrders(OrdersVo ordersVo);
	// 기간 조회
	public OrdersVo getDate(Date date);
}
