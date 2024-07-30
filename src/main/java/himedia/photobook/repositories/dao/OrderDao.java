package himedia.photobook.repositories.dao;

import java.util.List;
import java.util.Map;

import himedia.photobook.repositories.vo.OrdersVo;

public interface OrderDao {
	public int orderInsert(String userId, String albumId, Long oQuantity);	// 주문생성
	
	public List<OrdersVo> selectAllOrdersByUserId(String userId);

	/**
	 * 조건 상관없이, 주문 테이블(orders)의 튜플들을 다 들고 올 수 있는 메서드
	 * */
	public List<OrdersVo> selectAllOrders();	
	/**
	 * 주문 번호와 일치하는 주문 정보를 찾아오는 메서드
	 * */
	public OrdersVo selectByOrderId(String orderId);
	
	// 관리자 주문검색
//	List<OrdersVo> searchOrders(Map<String, Object> params);

	public String getUserIdByUserName(String keyword);
	
	
//주문번호로 앨범아이디 가져오는 메서드
	public String getAlbumIdByOrderId(String orderId);
	/**
	 * 주문번호와 주문일자를 업데이트 하는 메서드
	 * param : 
	 * 	updateId - where절에 쓸 업데이트 할 주문 튜플의 id
	 *  ordersVo - 업데이트할 정보 
	 * return type : 업데이트 영향 받은 튜플 수
	 * */
	int updateByOrderId(String updateId, OrdersVo ordersVo);
	/**
	 * userId가 일치하는 주문들 중에서 제일 최근에 추가된 하나를 리턴해주는 메서드
	 */
	public OrdersVo selectRecentOrderByUserId(String userId);
	//미처리 주문 갯수 들고오는
	public String count();
	//판매액 조회
	public Map<String, Object> Salecount();
	public List<Map<String, Object>> getTopAlbum();
	public int delete(String orderId);
}
	

