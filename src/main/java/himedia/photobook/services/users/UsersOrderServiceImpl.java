package himedia.photobook.services.users;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.photobook.repositories.dao.OrderDao;
import himedia.photobook.repositories.dao.RefundDaoImpl;
import himedia.photobook.repositories.dao.ShipmentsDaoImpl;
import himedia.photobook.repositories.vo.OrdersVo;

@Service("userOrderService")
public class UsersOrderServiceImpl {
	@Autowired
	private OrderDao orderDaoImpl;
	@Autowired
	private ShipmentsDaoImpl shipDao;
	@Autowired
	private RefundDaoImpl refundDao;
	
	/**
	 * 주문 조회에 필요한 정보들을 담아서 보내주는 메서드
	 **/
	public List<Map<String, Object>> getOrderInfos(String userId){
		List<Map<String, Object>> orderInfoList = new ArrayList<Map<String, Object>>();
		Map<String, Object> orderInfos = null;
		List<OrdersVo> orderList = orderDaoImpl.selectAllOrdersByUserId(userId);
		String orderStatus = null;
		
		for (OrdersVo ordersVo : orderList) {
			orderInfos = new HashMap<String, Object>();	
			orderStatus = null;

			orderInfos.put("ordersVo", ordersVo);
			
			orderStatus = shipDao.selectStatusByOrderID(ordersVo.getOrderId());
			if(orderStatus != null)
			{
				if(orderStatus.equals("R"))
					orderStatus = refundDao.selectStatusByOrderID(ordersVo.getOrderId());
				
				orderStatus = statusToWord(orderStatus);
			}
			else {
				orderStatus = "접수 완료";
			}

			orderInfos.put("status", orderStatus);
			
			orderInfoList.add(orderInfos);
		}

		return orderInfoList;
	}	
	
	/**
	 * Shipments 혹은 Refund의 Status를 받아서 사람이 인지하기 편한 문장으로 되돌려주는 코드
	 *  A(Application): 배송 준비 
	 *  B(Before Shipping): 배송 중 
	 *  C(Complete): 배송 완료
	 *  R(Refund): 환불
	 *  P(Preparing Refund): 환불 준비
	 *  F(Finished Refund): 환불 완료
	 * */
	private String statusToWord(String statusCode) {
		String word = null;
		System.out.println(statusCode);
		
		if(statusCode.equals("A"))
			word = "배송 준비";
		else if(statusCode.equals("B"))
			word = "배송 중";
		else if(statusCode.equals("C"))
			word = "배송 완료";
		else if(statusCode.equals("P"))
			word = "환불 대기";
		else if(statusCode.equals("F"))
			word = "환불 완료";
		else
			word = "비정상적인 값입니다";	

		return word;
	}
}
