package himedia.photobook.services.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.photobook.repositories.dao.AlbumDao;
import himedia.photobook.repositories.dao.InventoryDao;
import himedia.photobook.repositories.dao.OrderDao;
import himedia.photobook.repositories.dao.RefundDao;
import himedia.photobook.repositories.dao.RefundDao;
import himedia.photobook.repositories.dao.ShipmentsDao;
import himedia.photobook.repositories.dao.UsersDao;
import himedia.photobook.repositories.vo.AlbumVo;
import himedia.photobook.repositories.vo.InventoryVo;
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
@Autowired
private RefundDao refundDaoImpl;
@Autowired
private InventoryDao inventoryDaoImpl;

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
		System.out.println("createShipmentByOrderId : " + orderId);
		
		if (shipmentsDaoImpl.selectStatusByOrderID(orderId) == null) {
			OrdersVo order = orderDaoImpl.selectByOrderId(orderId);
			System.out.println("배송과 연관된 오더 정보 선택해오기 : " + order);
			InventoryVo inventoryVo = new InventoryVo();
			inventoryVo.setAlbumId(order.getAlbumId());
			inventoryVo.setaQuantity(order.getoQuantity());
			System.out.println("수량과 앨범 : " + inventoryVo);
			
//			boolean ableOrder = false;
//			ableOrder = 1 == inventoryDaoImpl.decreaseQuantity(inventoryVo);
//			System.out.println("수량 차감 결과 : " + ableOrder);
			
//			if(ableOrder)
				result = 1 == shipmentsDaoImpl.insert(orderId);
		}
		
		System.out.println("createShipmentByOrderId Result: " + result);
		return result;
	}
	
	/**
	 * 받은 orderId를 기준으로 환불을 만들어주는 테이블
	 * 이미 해당 orderId로 만들어진 refund가 만들어져 있으면 만들어지지 않는다.
	 * 기본 refund는 P이다.
	 * param : String - 주문 아이디 
	 * return : boolean - 성공/실패 여부
	 * */
	public boolean createRefundByOrderId(String orderId) {
		boolean result = false;
		
		if (refundDaoImpl.selectStatusByOrderID(orderId) == null) {
			result = 1 == refundDaoImpl.insert(orderId);
		}
		
		return result;
	}
}
