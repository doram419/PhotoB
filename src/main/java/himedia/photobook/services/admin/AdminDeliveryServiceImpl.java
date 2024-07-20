package himedia.photobook.services.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.photobook.controllers.DataConverter;
import himedia.photobook.repositories.dao.AlbumDao;
import himedia.photobook.repositories.dao.OrderDao;
import himedia.photobook.repositories.dao.RefundDao;
import himedia.photobook.repositories.dao.ShipmentsDao;
import himedia.photobook.repositories.dao.UsersDao;
import himedia.photobook.repositories.vo.AlbumVo;
import himedia.photobook.repositories.vo.OrdersVo;
import himedia.photobook.repositories.vo.ShipmentsVo;
import himedia.photobook.repositories.vo.UsersVo;

@Service
public class AdminDeliveryServiceImpl {
	private DataConverter dataConverter = new DataConverter();
	
	@Autowired
	private OrderDao orderDaoImpl;
	@Autowired
	private UsersDao usersDaoImpl;
	@Autowired
	private ShipmentsDao shipmentsDaoImpl;
	@Autowired
	private RefundDao refundDaoImpl;
	@Autowired
	private AlbumDao albumDaoImpl;
	
	/**
	 * 배송 관리에 필요한 정보들을 모두 리턴해주는 함수
	 * */
	public List<Map<String, Object>> getDeliveryInfos(){
		List<Map<String, Object>> deliveryInfoList = new ArrayList<Map<String, Object>>();
		Map<String, Object> deliveryInfos = null;
		OrdersVo ordersVo = null;
		UsersVo usersVo = null;
		String status = null;

		List<ShipmentsVo> shipmentsList = shipmentsDaoImpl.selectAll();
		
		for (ShipmentsVo shipmentsVo: shipmentsList) {
			deliveryInfos = new HashMap<String, Object>();	
			status = shipmentsVo.getShipmentStatus();
			if(status.equals("R"))	
				status = refundDaoImpl.selectStatusByOrderID(shipmentsVo.getOrderId());
			status = dataConverter.statusToWord(status);
			
			ordersVo = orderDaoImpl.selectByOrderId(shipmentsVo.getOrderId());
			usersVo = usersDaoImpl.selectOneUserById(ordersVo.getUserId());
		
			deliveryInfos.put("shipmentsVo", shipmentsVo);
			deliveryInfos.put("shipmentDate", 
					dataConverter.kstToYYYY(shipmentsVo.getShipmentDate()));
			deliveryInfos.put("status", status);
			deliveryInfos.put("ordersVo", ordersVo);
			deliveryInfos.put("usersVo", usersVo);
	
			deliveryInfoList.add(deliveryInfos);
		}
		return deliveryInfoList;
	}
	
	/**
	 * 배송에 필요한 모든 상세 정보를 넘겨주는 함수
	 * */
	public Map<String, Object> getDeliveryDetailInfo(String orderId){
		Map<String, Object> deliveryDetailInfo = new HashMap<String, Object>();
		OrdersVo ordersVo = orderDaoImpl.selectByOrderId(orderId);
		UsersVo usersVo = usersDaoImpl.selectOneUserById(ordersVo.getUserId());
		ShipmentsVo shipmentsVo = shipmentsDaoImpl.selectShipmentInfoByOrderID(orderId);
		AlbumVo albumVo = albumDaoImpl.selectOneById(ordersVo.getAlbumId());
		
		deliveryDetailInfo.put("ordersVo", ordersVo);
		deliveryDetailInfo.put("usersVo", usersVo);
		deliveryDetailInfo.put("shipmentDate", 
				dataConverter.kstToYYYY(shipmentsVo.getShipmentDate()));
		deliveryDetailInfo.put("orderDate", 
				dataConverter.kstToYYYY(ordersVo.getOrderDate()));
		deliveryDetailInfo.put("albumVo", albumVo);
		deliveryDetailInfo.put("shipmentsVo", shipmentsVo);

		return deliveryDetailInfo;
	}
}
