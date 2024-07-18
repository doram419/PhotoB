package himedia.photobook.services.admin;

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
import himedia.photobook.repositories.dao.ShipmentsDao;
import himedia.photobook.repositories.dao.UsersDaoImpl;
import himedia.photobook.repositories.vo.AlbumVo;
import himedia.photobook.repositories.vo.OrdersVo;
import himedia.photobook.repositories.vo.ShipmentsVo;
import himedia.photobook.repositories.vo.UsersVo;

@Service("adminDeliveryService")
public class AdminDeliveryServiceImpl {
	private DataConverter dataConverter = new DataConverter();
	
	@Autowired
	private OrdersDaoImpl orderDao;
	@Autowired
	private UsersDaoImpl userDao;
	@Autowired
	private ShipmentsDao shipmentsDaoImpl;
	@Autowired
	private RefundDaoImpl refundDao;
	@Autowired
	private AlbumDaoImpl albumDao;
	
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
				status = refundDao.selectStatusByOrderID(shipmentsVo.getOrderId());
			status = dataConverter.statusToWord(status);
			
			ordersVo = orderDao.selectByOrderId(shipmentsVo.getOrderId());
			usersVo = userDao.selectUserByUserId(ordersVo.getUserId());
		
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
		OrdersVo ordersVo = orderDao.selectByOrderId(orderId);
		UsersVo usersVo = userDao.selectUserByUserId(ordersVo.getUserId());
		ShipmentsVo shipmentsVo = shipmentsDaoImpl.selectShipmentInfoByOrderID(orderId);
		AlbumVo albumVo = albumDao.selectAlbumIdById(ordersVo.getAlbumId());
		
		deliveryDetailInfo.put("ordersVo", ordersVo);
		deliveryDetailInfo.put("usersVo", usersVo);
		deliveryDetailInfo.put("shipmentDate", 
				dataConverter.kstToYYYY(shipmentsVo.getShipmentDate()));
		deliveryDetailInfo.put("albumVo", albumVo);
		deliveryDetailInfo.put("shipmentsVo", shipmentsVo);

		return deliveryDetailInfo;
	}
}
