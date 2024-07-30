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
	
	private DataConverter dataConverter = new DataConverter();
	
	/**
	 * 주문 조회에 필요한 정보들을 담아서 보내주는 메서드
	 **/
	public List<Map<String, Object>> getOrderInfos(String userId){
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
			if(refundStatus != null)
			{
				status = dataConverter.statusToWord(refundStatus);
			}
			else if(orderStatus != null){
				status = dataConverter.statusToWord(orderStatus);
			}
			else {
				status = dataConverter.statusToWord("G");
			}

			orderInfos.put("status", status);
			
			orderInfoList.add(orderInfos);
		}

		return orderInfoList;
	}	
	
	/**
	 * 이미지 출력을 위해 앨범에 등록된 이미지 개수를 출력해주는 메서드
	 * */
	public int getOrderedImagesCount(String orderId) {
		return photoDaoImpl.selectCountByOrderId(orderId);
	}
}
