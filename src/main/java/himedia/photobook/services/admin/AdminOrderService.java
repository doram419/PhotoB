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

//관리자 주문 조회
public List<Map<String, Object>> getOrderAdmin() {
    List<Map<String, Object>> orderInfoList = new ArrayList<>();
    List<OrdersVo> orderList = orderDaoImpl.selectAllOrders();
    
    for (OrdersVo order : orderList) {
        Map<String, Object> orderMap = new HashMap<>();
        orderMap.put("ordersVo", order);
        
        UsersVo user = usersDaoImpl.selectOneUserById(order.getUserId());
        orderMap.put("usersVo", user);
        
        String status = shipmentsDaoImpl.selectStatusByOrderID(order.getOrderId());
        
        if (status == null || status.isEmpty()) {
            status = "A";}
        orderMap.put("status", status);
        
        orderInfoList.add(orderMap);
    }
    
    return orderInfoList;
}

// 관리자 주문 상세조회
public Map<String, Object> getOrderDetail(String orderId) {
    Map<String, Object> orderDetail = new HashMap<>();
	String albumId = orderDaoImpl.getAlbumIdByOrderId(orderId);
	AlbumVo album = albumDaoImpl.selectByAlbumId(albumId);
	orderDetail.put("album", album);
	
    OrdersVo order = orderDaoImpl.selectByOrderId(orderId);
    orderDetail.put("order", order);
    
    UsersVo user = usersDaoImpl.selectOneUserById(order.getUserId());
    orderDetail.put("user", user);
    
    
    
    
    return orderDetail;
}


public String getSearchUserId(String keyword) {
    String userId = orderDaoImpl.getUserIdByUserName(keyword);
    return userId;
}


public String getUserIdByUserName(String keyword) {
    String userId = orderDaoImpl.getUserIdByUserName(keyword);
    System.out.println("받아온 userId: "+userId);
    return userId;
}
//user id로 주문리스트 가져옴
public List<OrdersVo> getOrdersByUserId(String userId) {
    return orderDaoImpl.selectAllOrdersByUserId(userId);
}

// user id 로 배송상태 조회
public String getShipmentStatusByOrderId(String orderId)	{
	String shipmentStatus = shipmentsDaoImpl.selectStatusByOrderID(orderId);
	return shipmentStatus;
}
public String getOptionsByOrderId(String orderId)	{
	String options = albumDaoImpl.findOptionsByOrderId(orderId);
	return options;
}

public AlbumVo selectByAlbumId(String albumId)	{
	AlbumVo options = albumDaoImpl.selectByAlbumId(albumId);
	System.out.println("admin orderService의 옵션"+options);
	return options;
}
public String getAlbumIdByOrderId(String orderId)	{
	String albumId = orderDaoImpl.getAlbumIdByOrderId(orderId);
	return albumId;
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
			OrdersVo order = orderDaoImpl.selectByOrderId(orderId);
			InventoryVo inventoryVo = inventoryDaoImpl.selectOneByAlbumId(order.getAlbumId());
			
			if(inventoryVo.getaQuantity() >= order.getoQuantity())
			{
				inventoryVo.setaQuantity(inventoryVo.getaQuantity() - order.getoQuantity());
				result = 1 == shipmentsDaoImpl.insert(orderId);
				inventoryDaoImpl.updateQuantity(inventoryVo);
			}
		}
		
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
