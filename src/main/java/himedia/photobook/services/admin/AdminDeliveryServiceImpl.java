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
	 */
	public List<Map<String, Object>> getDeliveryInfos() {
		List<Map<String, Object>> deliveryInfoList = new ArrayList<Map<String, Object>>();
		Map<String, Object> deliveryInfos = null;
		OrdersVo ordersVo = null;
		UsersVo usersVo = null;
		String status = null;

		List<ShipmentsVo> shipmentsList = shipmentsDaoImpl.selectAll();

		for (ShipmentsVo shipmentsVo : shipmentsList) {
			deliveryInfos = new HashMap<String, Object>();
			status = shipmentsStatusToString(shipmentsVo);

			ordersVo = orderDaoImpl.selectByOrderId(shipmentsVo.getOrderId());
			usersVo = usersDaoImpl.selectOneUserById(ordersVo.getUserId());

			deliveryInfos.put("shipmentsVo", shipmentsVo);
			deliveryInfos.put("shipmentDate", dataConverter.kstToYYYY(shipmentsVo.getShipmentDate()));
			deliveryInfos.put("status", status);
			deliveryInfos.put("ordersVo", ordersVo);
			deliveryInfos.put("usersVo", usersVo);

			deliveryInfoList.add(deliveryInfos);
		}
		return deliveryInfoList;
	}

	/**
	 * 배송에 필요한 모든 상세 정보를 넘겨주는 함수
	 */
	public Map<String, Object> getDeliveryDetailInfo(String orderId) {
		Map<String, Object> deliveryDetailInfo = new HashMap<String, Object>();
		OrdersVo ordersVo = orderDaoImpl.selectByOrderId(orderId);
		UsersVo usersVo = usersDaoImpl.selectOneUserById(ordersVo.getUserId());
		ShipmentsVo shipmentsVo = shipmentsDaoImpl.selectShipmentInfoByOrderID(orderId);
		AlbumVo albumVo = albumDaoImpl.selectByAlbumId(ordersVo.getAlbumId());
		List<AlbumVo> albumList = albumDaoImpl.selectAll();

		deliveryDetailInfo.put("ordersVo", ordersVo);
		deliveryDetailInfo.put("usersVo", usersVo);
		deliveryDetailInfo.put("shipmentDate", dataConverter.kstToYYYY(shipmentsVo.getShipmentDate()));
		deliveryDetailInfo.put("orderDate", dataConverter.kstToYYYY(ordersVo.getOrderDate()));
		deliveryDetailInfo.put("shipmentsVo", shipmentsVo);
		deliveryDetailInfo.put("albumVo", albumVo);
		deliveryDetailInfo.put("albumList", albumList);

		return deliveryDetailInfo;
	}

	/**
	 * 배송에 쓰이는 모든 정보를 변경을 해주는 함수
	 */
	public boolean updateDeliveryInfo(Map<String, Object> updateDeliveryInfo) {
		boolean result = false;
		ShipmentsVo shipmentsVo = null;
		OrdersVo ordersVo = null;
		String targetOrderId = (String) updateDeliveryInfo.get("targetOrderId");

		if (updateDeliveryInfo.get("shipmentsVo") instanceof ShipmentsVo)
			shipmentsVo = (ShipmentsVo) updateDeliveryInfo.get("shipmentsVo");
		result = 1 == shipmentsDaoImpl.updateDateAndStatusByShipmentId(shipmentsVo);

		if (updateDeliveryInfo.get("ordersVo") instanceof OrdersVo)
			ordersVo = (OrdersVo) updateDeliveryInfo.get("ordersVo");

		result = result && (1 == orderDaoImpl.updateByOrderId(targetOrderId, ordersVo));

		return result;
	}

	/**
	 * 오더 아이디를 기준으로 검색해서 배송 리스트를 가져와 주는 함수
	 */
	public List<Map<String, Object>> searchInfosByOrderId(String keyword) {
		List<Map<String, Object>> searchInfos = new ArrayList<Map<String, Object>>();
		Map<String, Object> infoMap = null;
		UsersVo usersVo = null;
		String status = null;
		OrdersVo ordersVo = null;

		List<ShipmentsVo> shipmentsList = shipmentsDaoImpl.searchAllByOrderId(keyword);
		for (ShipmentsVo shipmentsVo : shipmentsList) {
			infoMap = new HashMap<String, Object>();
			status = shipmentsVo.getShipmentStatus();
			ordersVo = orderDaoImpl.selectByOrderId(shipmentsVo.getOrderId());
			usersVo = usersDaoImpl.selectOneUserById(ordersVo.getUserId());
			status = shipmentsStatusToString(shipmentsVo);

			infoMap.put("usersVo", usersVo);
			infoMap.put("shipmentsVo", shipmentsVo);
			infoMap.put("shipmentDate", dataConverter.kstToYYYY(shipmentsVo.getShipmentDate()));
			infoMap.put("status", status);

			searchInfos.add(infoMap);
		}
		return searchInfos;
	}

	/**
	 * 주문자명을 기준으로 검색해서 배송 리스트를 가져와 주는 함수
	 */
	public List<Map<String, Object>> searchInfosByUserName(String keyword) {
		List<Map<String, Object>> searchInfos = new ArrayList<Map<String, Object>>();
		Map<String, Object> infoMap = null;
		ShipmentsVo shipmentsVo = null;
		String status = null;

		List<OrdersVo> ordersList = null;
		List<UsersVo> usersList = usersDaoImpl.searchUsers(keyword);

		for (UsersVo usersVo : usersList) {
			ordersList = orderDaoImpl.selectAllOrdersByUserId(usersVo.getUserId());

			for (OrdersVo ordersVo : ordersList) {
				infoMap = new HashMap<String, Object>();
				shipmentsVo = shipmentsDaoImpl.selectShipmentInfoByOrderID(ordersVo.getOrderId());

				if (shipmentsVo != null) {
					status = shipmentsStatusToString(shipmentsVo);

					infoMap.put("usersVo", usersVo);
					infoMap.put("shipmentsVo", shipmentsVo);
					infoMap.put("shipmentDate", dataConverter.kstToYYYY(shipmentsVo.getShipmentDate()));
					infoMap.put("status", status);
					searchInfos.add(infoMap);
				}
			}
		}

		return searchInfos;
	}

	/**
	 * shipment_status와 refund_status를 조건을 따져 사람이 인지할 수 있는 문장으로 바꿔서 return 해주는 메서드
	 * param : ShipmentsVo - 배송 정보 return : String - 배송 문자열(배송 완료, 환불 준비 등)
	 */
	private String shipmentsStatusToString(ShipmentsVo shipmentsVo) {
		String result = null;

		result = shipmentsVo.getShipmentStatus();
		if (result.equals("R")) {
			String refundStatus = refundDaoImpl.selectStatusByOrderID(shipmentsVo.getOrderId());
			if (refundStatus != null)
				result = refundStatus;
		}
		result = dataConverter.statusToWord(result);

		return result;
	}
}
