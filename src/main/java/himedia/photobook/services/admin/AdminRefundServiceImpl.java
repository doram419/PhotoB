package himedia.photobook.services.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.photobook.repositories.dao.OrderDao;
import himedia.photobook.repositories.dao.RefundDao;
import himedia.photobook.repositories.dao.ShipmentsDao;
import himedia.photobook.repositories.dao.UsersDao;
import himedia.photobook.repositories.vo.OrdersVo;
import himedia.photobook.repositories.vo.RefundVo;
import himedia.photobook.repositories.vo.ShipmentsVo;
import himedia.photobook.repositories.vo.UsersVo;
import himedia.photobook.tools.DataConverter;

@Service
public class AdminRefundServiceImpl {
	private DataConverter dataConverter = new DataConverter();

	@Autowired
	private RefundDao refundDaoImpl;
	@Autowired
	private OrderDao orderDaoImpl;
	@Autowired
	private UsersDao usersDaoImpl;
	@Autowired
	private ShipmentsDao shipmentsDaoImpl;

	/**
	 * 환불 관리에 필요한 정보들을 모두 리턴해주는 함수
	 */
	public List<Map<String, Object>> getRefundInfos() {
		List<Map<String, Object>> refundInfoList = new ArrayList<Map<String, Object>>();
		Map<String, Object> refundInfos = null;
		OrdersVo ordersVo = null;
		UsersVo usersVo = null;
		String status = null;

		// 환불 테이블에 있는 환불 리스트를 전부 들고온다
		List<RefundVo> refundList = refundDaoImpl.selectAllRefunds();
		for (RefundVo refundVo : refundList) {
			refundInfos = new HashMap<String, Object>();
			ordersVo = orderDaoImpl.selectByOrderId(refundVo.getOrderId());
			usersVo = usersDaoImpl.selectOneUserById(ordersVo.getUserId());
			status = dataConverter.statusToWord(refundVo.getRefundStatus());

			refundInfos.put("ordersVo", ordersVo);
			refundInfos.put("userName", usersVo.getUserName());
			refundInfos.put("refundVo", refundVo);
			refundInfos.put("status", status);

			refundInfoList.add(refundInfos);
		}

		return refundInfoList;
	}

	/**
	 * 환불 상태를 환불 완료로 변경해주는 메서드 param : String orderId - 변경할 튜플의 orderId return :
	 * boolean - 성공 실패 여부
	 */
	public boolean updateStatusToFinish(String orderId) {
		RefundVo refundVo = new RefundVo();
		refundVo.setOrderId(orderId);
		refundVo.setRefundStatus("F");

		return 1 == refundDaoImpl.updateStatus(refundVo);
	}

	/**
	 * 환불 정보를 삭제해주는 메서드 param : String orderId - 삭제할 튜플의 orderId return : boolean -
	 * 성공 실패 여부
	 */
	public boolean delete(String orderId) {
		return 1 == refundDaoImpl.delete(orderId);
	}

	/**
	 * 주문자명을 기준으로 검색해서 배송 리스트를 가져와 주는 함수
	 */
	public List<Map<String, Object>> searchInfosByUserName(String keyword) {
		List<Map<String, Object>> searchInfos = new ArrayList<Map<String, Object>>();
		Map<String, Object> infoMap = null;
		RefundVo refundVo = null;
		String status = null;

		List<OrdersVo> ordersList = null;
		List<UsersVo> usersList = usersDaoImpl.searchUsers(keyword);

		for (UsersVo usersVo : usersList) {
			ordersList = orderDaoImpl.selectAllOrdersByUserId(usersVo.getUserId());

			for (OrdersVo ordersVo : ordersList) {
				infoMap = new HashMap<String, Object>();
				refundVo = refundDaoImpl.selectOneByOrderId(ordersVo.getOrderId());

				if (refundVo != null) {
					status = dataConverter.statusToWord(refundVo.getRefundStatus());

					infoMap.put("usersVo", usersVo);
					infoMap.put("userName", usersVo.getUserName());
					infoMap.put("refundVo", refundVo);
					infoMap.put("ordersVo", ordersVo);
					infoMap.put("status", status);
					searchInfos.add(infoMap);
				}
			}
		}

		return searchInfos;
	}

	/**
	 * 오더 아이디를 기준으로 검색해서 배송 리스트를 가져와 주는 함수
	 */
	public List<Map<String, Object>> searchInfosByOrderId(String keyword) {
		List<Map<String, Object>> searchInfos = new ArrayList<Map<String, Object>>();
		Map<String, Object> infoMap = null;
		RefundVo refundVo = null;
		OrdersVo ordersVo = null;
		String status = null;
		UsersVo usersVo = null;

		List<ShipmentsVo> shipmentsList = shipmentsDaoImpl.searchAllByOrderId(keyword);
		for (ShipmentsVo shipmentsVo : shipmentsList) {
			infoMap = new HashMap<String, Object>();
			refundVo = refundDaoImpl.selectOneByOrderId(shipmentsVo.getOrderId());

			if (refundVo != null) {
				ordersVo = orderDaoImpl.selectByOrderId(refundVo.getOrderId());
				status = refundVo.getRefundStatus();
				usersVo = usersDaoImpl.selectOneUserById(ordersVo.getUserId());

				infoMap.put("usersVo", usersVo);
				infoMap.put("userName", usersVo.getUserName());
				infoMap.put("status", status);
				infoMap.put("ordersVo", ordersVo);
				infoMap.put("refundVo", refundVo);
				searchInfos.add(infoMap);
			}
		}
		return searchInfos;
	}

	public String count() {
		String count = refundDaoImpl.count();
		return count;
	}
}
