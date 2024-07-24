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

}
