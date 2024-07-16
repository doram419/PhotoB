package himedia.photobook.services.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.photobook.repositories.dao.OrdersDaoImpl;
import himedia.photobook.repositories.dao.UsersDaoImpl;
import himedia.photobook.repositories.vo.OrdersVo;
import himedia.photobook.repositories.vo.UsersVo;

@Service("adminDeliveryService")
public class AdminDeliveryServiceImpl {
	@Autowired
	private OrdersDaoImpl orderDao;
	@Autowired
	private UsersDaoImpl userDao;
	
	/**
	 * 배송 관리에 필요한 정보들을 모두 리턴해주는 함수
	 * */
	public List<Map<String, Object>> getDeliveryInfos(){
		List<Map<String, Object>> deliveryInfoList = new ArrayList<Map<String, Object>>();
		Map<String, Object> deliveryInfos = null;
		UsersVo usersVo = null;
		
		List<OrdersVo> orderList = orderDao.selectAllOrders();
		
		for (OrdersVo ordersVo : orderList) {
			deliveryInfos = new HashMap<String, Object>();	
			usersVo = userDao.selectUserByUserId(ordersVo.getUserId());
			
			deliveryInfos.put("ordersVo", ordersVo);
			deliveryInfos.put("usersVo", usersVo);
			
			deliveryInfoList.add(deliveryInfos);
		}
		
		return deliveryInfoList;
	}
}
