package himedia.photobook.repositories.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import himedia.photobook.repositories.vo.OrdersVo;

/**
 * 배운 것과 다르게 interface 구현은 하지 않음
 * 이후 기능상 겹치는 부분이 있으면 따로 인터페이스 구현 할 예정
 * 그러나 이름은 수정이 있을 가능성을 고려하여 ~impl로 함 
 * */
@Repository("ordersDao")
public class OrdersDaoImpl {
	@Autowired
	private SqlSession session;
	
	/**
	 * 조건 상관없이, 주문 테이블(orders)의 튜플들을 다 들고 올 수 있는 메서드
	 * */
	public List<OrdersVo> selectAllOrders(){
		return session.selectList("orders.selectAllOrders");
	}
	
	/**
	 * 유저 아이디와 일치하는 주문 테이블(orders)의 튜플들을 들고 올 수 있는 메서드
	 * */
	public List<OrdersVo> selectAllOrdersByUserId(String userId){
		return session.selectList("orders.selectAllOrdersByUserId", userId);
	}
}
