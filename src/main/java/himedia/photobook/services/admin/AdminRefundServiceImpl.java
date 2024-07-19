package himedia.photobook.services.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.photobook.controllers.DataConverter;
import himedia.photobook.repositories.dao.OrderDao;
import himedia.photobook.repositories.dao.RefundDao;
import himedia.photobook.repositories.dao.UsersDao;
import himedia.photobook.repositories.vo.OrdersVo;
import himedia.photobook.repositories.vo.RefundVo;
import himedia.photobook.repositories.vo.UsersVo;

@Service
public class AdminRefundServiceImpl {
	private DataConverter dataConverter = new DataConverter();
	
	@Autowired
	private RefundDao refundDaoImpl;
	@Autowired
	private OrderDao orderDaoImpl;
	@Autowired
	private UsersDao usersDaoImpl;
	
	/**
	 * 환불 관리에 필요한 정보들을 모두 리턴해주는 함수
	 * */
	public List<Map<String, Object>> getRefundInfos(){
		List<Map<String, Object>> refundInfoList = new ArrayList<Map<String, Object>>();
		Map<String, Object> refundInfos = null;
		OrdersVo ordersVo = null;
		UsersVo usersVo = null;
		String status = null;
		
		// 환불 요청을 해야지 환불 테이블이 생긴다.
		// 환불 테이블에 있는 환불 리스트를 전부 들고온다
		List<RefundVo> refundList = refundDaoImpl.selectAllRefunds();
		for (RefundVo refundVo : refundList) {
			refundInfos = new HashMap<String, Object>();
			ordersVo = orderDaoImpl.selectByOrderId(refundVo.getOrderId());
			usersVo = usersDaoImpl.selectUserByUserId(ordersVo.getUserId());
			status = dataConverter.statusToWord(refundVo.getRefundStatus());
			
			refundInfos.put("ordersVo", ordersVo);
			refundInfos.put("userName", usersVo.getUserName());
			refundInfos.put("refundId", refundVo.getRefundId());
			refundInfos.put("status", status);
			
			refundInfoList.add(refundInfos);
		}
		
		return refundInfoList;
	}
}
