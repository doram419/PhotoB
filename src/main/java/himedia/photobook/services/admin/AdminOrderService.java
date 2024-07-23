package himedia.photobook.services.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.photobook.repositories.dao.AlbumDao;
import himedia.photobook.repositories.dao.OrderDao;
import himedia.photobook.repositories.dao.ShipmentsDao;
import himedia.photobook.repositories.dao.UsersDao;
import himedia.photobook.repositories.vo.AlbumVo;
import himedia.photobook.repositories.vo.OrdersVo;
import himedia.photobook.repositories.vo.UsersVo;

@Service
public class AdminOrderService {

@Autowired
private OrderDao orderDaoImpl;
@Autowired
private UsersDao usersDaoImpl;
@Autowired
private ShipmentsDao shipmentsDaoImpl;
@Autowired
private AlbumDao albumDaoImpl;

public List<Map<String, Object>> getOrderAdmin() {
    List<Map<String, Object>> orderInfoList = new ArrayList<>();
    List<OrdersVo> orderList = orderDaoImpl.selectAllOrders();
    
    for (OrdersVo order : orderList) {
        Map<String, Object> orderMap = new HashMap<>();
        orderMap.put("ordersVo", order);
        
        UsersVo user = usersDaoImpl.selectOneUserById(order.getUserId());
        orderMap.put("usersVo", user);
        
        String status = shipmentsDaoImpl.selectStatusByOrderID(order.getOrderId());
        orderMap.put("status", status);
        
        orderInfoList.add(orderMap);
    }
    
    return orderInfoList;
}

public Map<String, Object> getOrderDetail(String orderId) {
    Map<String, Object> orderDetail = new HashMap<>();
    
    OrdersVo order = orderDaoImpl.selectByOrderId(orderId);
    orderDetail.put("order", order);
    
    UsersVo user = usersDaoImpl.selectOneUserById(order.getUserId());
    orderDetail.put("user", user);
    
    AlbumVo album = albumDaoImpl.selectByAlbumId(order.getAlbumId());
    orderDetail.put("album", album);
    
    return orderDetail;
}
	
	/**
	 * 받은 orderId를 기준으로 배송을 만들어주는 테이블
	 * 이미 해당 orderId로 만들어진 shipment가 만들어져 있으면 만들어지지 않는다.
	 * 기본 ShipmentStatus는 A이다.
	 * param : String - 주문 아이디 
	 * return : boolean - 성공/실패 여부
	 * */
	public boolean createShipmentByOrderId(String orderId) {
		boolean result = false;
		
		if (shipmentsDaoImpl.selectStatusByOrderID(orderId) == null) {
			result = 1 == shipmentsDaoImpl.insert(orderId);
		}
		
		return result;
	}
}
