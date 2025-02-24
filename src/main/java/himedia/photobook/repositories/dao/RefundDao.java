package himedia.photobook.repositories.dao;

import java.util.List;

import himedia.photobook.repositories.vo.RefundVo;

public interface RefundDao {
	/**
	 * 환불 테이블 안에서 OrderId가 일치하는 튜플에서 환불 상태를 가져오는 메서드
	 */
	public String selectStatusByOrderID(String orderId);

	/**
	 * 모든 환불 정보를 들고 와주는 메서드
	 */
	public List<RefundVo> selectAllRefunds();

	/**
	 * orderId를 기준으로 refund 튜플을 만들어 주는 메서드
	 */
	public int insert(String orderId);

	/**
	 * 환불 상태를 변경해주는 메서드 param : RefundVo refundVo - orderId : 변경할 튜플의 orderId -
	 * refundStatus : 변경할 상태값 return : int - 영향 받은 튜플의 수
	 */
	public int updateStatus(RefundVo refundVo);

	/**
	 * 환불 상태를 삭제해주는 메서드 param : String orderId : 삭제할 튜플의 orderId return : int - 영향
	 * 받은 튜플의 수
	 */
	public int delete(String orderId);

	/**
	 * orderId를 기준으로 환불 정보 하나를 들고 와주는 메서드 param : String orderId : 가져올 튜플의 orderId
	 * return : RefundVo - 조회된 튜플
	 */
	public RefundVo selectOneByOrderId(String orderId);

	public String count();
}
