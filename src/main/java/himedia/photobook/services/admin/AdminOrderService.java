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


//관리자 주문 검색
//public List<Map<String, Object>> searchOrders(String keyword) {
//    List<Map<String, Object>> orderInfoList = new ArrayList<>();
//    Map<String, Object> params = new HashMap<>();
//    params.put("keyword", keyword);
//    List<OrdersVo> orderList = orderDaoImpl.searchOrders(params);
//    System.out.println("service의orderList" + orderList);
//    for (OrdersVo order : orderList) {
//        Map<String, Object> orderMap = new HashMap<>();
//        orderMap.put("ordersVo", order);
//        UsersVo user = usersDaoImpl.selectOneUserById(order.getUserId());
//        orderMap.put("usersVo", user);
//        String status = shipmentsDaoImpl.selectStatusByOrderID(order.getOrderId());
//        orderMap.put("status", status);
//        orderInfoList.add(orderMap);
//        System.out.println("list에 들어간 orderMap" + orderInfoList);
//    }
//    return orderInfoList;
//}
public String getUserIdByUserName(String keyword) {
    String userId = orderDaoImpl.getUserIdByUserName(keyword);
    System.out.println("받아온 userId: "+userId);
    return userId;
}
}
