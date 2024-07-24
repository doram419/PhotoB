package himedia.photobook.repositories.dao;

import java.util.List;

import himedia.photobook.repositories.vo.RefundVo;

public interface RefundDao {
	/**
	 * 환불 테이블 안에서 OrderId가 일치하는 튜플에서 환불 상태를 가져오는 메서드 
	 * */
	public String selectStatusByOrderID(String orderId);
	
	/**
	 * 모든 환불 정보를 들고 와주는 메서드
	 * */
	public List<RefundVo> selectAllRefunds();
	/**
	 * orderId를 기준으로 refund 튜플을 만들어 주는 메서드
	 * */
	int insert(String orderId);
}
