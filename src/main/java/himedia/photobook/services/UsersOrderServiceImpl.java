package himedia.photobook.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.photobook.repositories.dao.AlbumDaoImpl;
import himedia.photobook.repositories.dao.OrdersDaoImpl;
import himedia.photobook.repositories.vo.AlbumVo;
import himedia.photobook.repositories.vo.OrdersVo;

@Service("userOrderService")
public class UsersOrderServiceImpl {
	/**
	 * 배운 것과 다르게 interface 구현은 하지 않음
	 * 이후 기능상 겹치는 부분이 있으면 따로 인터페이스 구현 할 예정
	 * 그러나 이름은 수정이 있을 가능성을 고려하여 ~impl로 함 
	 * */
	@Autowired
	private OrdersDaoImpl orderDao;
	@Autowired
	private AlbumDaoImpl albumDao;
	
	/**
	 * 주문 조회에 필요한 정보들을 담아서 보내주는 메서드
	 **/
	public List<Map<String, Object>> getOrderInfos(){
		List<Map<String, Object>> orderInfoList = new ArrayList<Map<String, Object>>();
		List<OrdersVo> orderList = orderDao.selectAll();
		Map<String, Object> orderInfos = null;
		AlbumVo albumVo = null;
		
		for (OrdersVo ordersVo : orderList) {
			orderInfos = new HashMap<String, Object>();	
			albumVo = null;
			
			orderInfos.put("ordersVo", ordersVo);
			
			albumVo = albumDao.selectOneById(ordersVo.getAlbumId());
			if(albumVo != null) {
				orderInfos.put("albumVo", albumVo);
			}
			
			orderInfoList.add(orderInfos);
		}

		return orderInfoList;
	}	
}
