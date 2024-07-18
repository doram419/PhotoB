package himedia.photobook.services.users;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.photobook.controllers.DataConverter;
import himedia.photobook.repositories.dao.OrdersDaoImpl;
import himedia.photobook.repositories.dao.RefundDaoImpl;
import himedia.photobook.repositories.dao.ShipmentsDao;
import himedia.photobook.repositories.vo.OrdersVo;

@Service("userOrderService")
public class UsersOrderServiceImpl {
	private DataConverter dataConverter = new DataConverter();
	@Autowired
	private OrdersDaoImpl orderDao;
	@Autowired
	private ShipmentsDao shipmentsDaoImpl;
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
		
			orderStatus = shipmentsDaoImpl.selectStatusByOrderID(ordersVo.getOrderId());
			if(orderStatus == "R")
				orderStatus = refundDao.selectStatusByOrderID(ordersVo.getOrderId());
			
			orderStatus = dataConverter.statusToWord(orderStatus);
			orderInfos.put("status", orderStatus);
			
			orderInfoList.add(orderInfos);
		}

		return orderInfoList;
	}	
	

	
}
