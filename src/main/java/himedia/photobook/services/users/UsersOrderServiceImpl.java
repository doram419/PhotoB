package himedia.photobook.services.users;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.photobook.repositories.dao.OrderDao;
import himedia.photobook.repositories.dao.PhotoDaoImpl;
import himedia.photobook.repositories.dao.RefundDaoImpl;
import himedia.photobook.repositories.dao.ShipmentsDaoImpl;
import himedia.photobook.repositories.vo.OrdersVo;
import himedia.photobook.tools.DataConverter;
import himedia.photobook.tools.FileModule;

@Service("userOrderService")
public class UsersOrderServiceImpl {
	@Autowired
	private OrderDao orderDaoImpl;
	@Autowired
	private ShipmentsDaoImpl shipDao;
	@Autowired
	private RefundDaoImpl refundDao;
	@Autowired
	private PhotoDaoImpl photoDaoImpl;
	@Autowired
	private RefundDaoImpl refundDaoImpl;

	private DataConverter dataConverter = new DataConverter();
	private FileModule fileModule = new FileModule();

	/**
	 * 주문 조회에 필요한 정보들을 담아서 보내주는 메서드
	 **/
	public List<Map<String, Object>> getOrderInfos(String userId) {
		List<Map<String, Object>> orderInfoList = new ArrayList<Map<String, Object>>();
		Map<String, Object> orderInfos = null;
		List<OrdersVo> orderList = orderDaoImpl.selectAllOrdersByUserId(userId);
		String orderStatus = null;
		String refundStatus = null;
		String status = null;

		for (OrdersVo ordersVo : orderList) {
			orderInfos = new HashMap<String, Object>();
			orderStatus = null;
			refundStatus = null;
			status = null;

			orderInfos.put("ordersVo", ordersVo);

			orderStatus = shipDao.selectStatusByOrderID(ordersVo.getOrderId());
			refundStatus = refundDao.selectStatusByOrderID(ordersVo.getOrderId());
			if (refundStatus != null) {
				status = dataConverter.statusToWord(refundStatus);
			} else if (orderStatus != null) {
				status = dataConverter.statusToWord(orderStatus);
			} else {
				status = dataConverter.statusToWord("G");
			}

			orderInfos.put("status", status);

			orderInfoList.add(orderInfos);
		}

		return orderInfoList;
	}

	/**
	 * 이미지 출력을 위해 앨범에 등록된 이미지 개수를 출력해주는 메서드
	 */
	public int getOrderedImagesCount(String orderId) {
		return photoDaoImpl.selectCountByOrderId(orderId);
	}

	/**
	 * 받은 orderId를 기준으로 환불을 만들어주는 테이블 이미 해당 orderId로 만들어진 refund가 만들어져 있으면 만들어지지
	 * 않는다. 기본 refund는 P이다. param : String - 주문 아이디 return : boolean - 성공/실패 여부
	 */
	public boolean createRefundByOrderId(String orderId) {
		boolean result = false;

		if (refundDaoImpl.selectStatusByOrderID(orderId) == null) {
			result = 1 == refundDaoImpl.insert(orderId);
		}
		if (shipDao.selectStatusByOrderID(orderId) != null) {
			shipDao.delete(orderId);
		}

		return result;
	}

	/**
	 * 이미지 출력을 앨범 기초 경로를 잡아주는 메서드
	 */
	public String getOrderedImagePath(String userId, String orderId) {
		String imgSrc = userId + "/" + orderId;
		if (fileModule.getOsName().contains("nux")) {
			imgSrc = "/nux/photobook-images/order/" + imgSrc;
		} else {
			imgSrc = "/win/photobook-images/order/" + imgSrc;
		}

		return imgSrc;
	}
}
