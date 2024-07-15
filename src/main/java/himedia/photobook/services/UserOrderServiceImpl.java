package himedia.photobook.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.photobook.repositories.dao.OrdersDaoImpl;
import himedia.photobook.repositories.vo.OrdersVo;

@Service("userOrderService")
public class UserOrderServiceImpl {
	/**
	 * 배운 것과 다르게 interface 구현은 하지 않음
	 * 이후 기능상 겹치는 부분이 있으면 따로 인터페이스 구현 할 예정
	 * 그러나 이름은 수정이 있을 가능성을 고려하여 ~impl로 함 
	 * */
	@Autowired
	private OrdersDaoImpl orderDao;
	
	public List<OrdersVo> selectAll() {
		return orderDao.selectAll();
	}
	
}
