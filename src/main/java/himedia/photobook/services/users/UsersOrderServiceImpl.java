package himedia.photobook.services.users;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.photobook.controllers.DataConverter;
import himedia.photobook.repositories.dao.AlbumDaoImpl;
import himedia.photobook.repositories.dao.OrdersDaoImpl;
import himedia.photobook.repositories.dao.RefundDaoImpl;
import himedia.photobook.repositories.dao.ShipmentsDaoImpl;
import himedia.photobook.repositories.vo.AlbumVo;
import himedia.photobook.repositories.vo.OrdersVo;
import himedia.photobook.repositories.vo.RefundVo;
import himedia.photobook.repositories.vo.ShipmentsVo;

@Service("userOrderService")
public class UsersOrderServiceImpl {
	private DataConverter dataConverter = new DataConverter();
	/**
	 * 배운 것과 다르게 interface 구현은 하지 않음
	 * 이후 기능상 겹치는 부분이 있으면 따로 인터페이스 구현 할 예정
	 * 그러나 이름은 수정이 있을 가능성을 고려하여 ~impl로 함 
	 * */
	@Autowired
	private OrdersDaoImpl orderDao;
	@Autowired
	private AlbumDaoImpl albumDao;
	@Autowired
	private ShipmentsDaoImpl shipDao;
	@Autowired
	private RefundDaoImpl refundDao;
	
	/**
	 * 주문 조회에 필요한 정보들을 담아서 보내주는 메서드
	 **/
	public List<Map<String, Object>> getOrderInfos(String userId){
		List<Map<String, Object>> orderInfoList = new ArrayList<Map<String, Object>>();
		Map<String, Object> orderInfos = null;
		List<OrdersVo> orderList = orderDao.selectAllOrdersByUserId(userId);
		String orderStatus = null;
		
		for (OrdersVo ordersVo : orderList) {
			orderInfos = new HashMap<String, Object>();	
			orderStatus = null;

			orderInfos.put("ordersVo", ordersVo);
		
			orderStatus = shipDao.selectStatusByOrderID(ordersVo.getOrderId());
			if(orderStatus == "R")
				orderStatus = refundDao.selectStatusByOrderID(ordersVo.getOrderId());
			
			orderStatus = dataConverter.statusToWord(orderStatus);
			orderInfos.put("status", orderStatus);
			
			orderInfoList.add(orderInfos);
		}

		return orderInfoList;
	}	
	

	
}
