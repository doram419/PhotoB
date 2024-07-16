package himedia.photobook.repositories.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import himedia.photobook.repositories.vo.RefundVo;

@Repository("refundDao")
public class RefundDaoImpl {
	@Autowired
	private SqlSession session;
	
	/**
	 * 환불 테이블 안에서 OrderId가 일치하는 튜플에서 환불 상태를 가져오는 메서드 
	 * */
	public String selectStatusByOrderID(String orderId) {
		return session.selectOne("refund.selectStatusByOrderID", orderId);
	}
	
	/**
	 * 모든 환불 정보를 들고 와주는 메서드
	 * */
	public List<RefundVo> selectAllRefunds(){
		return session.selectList("refund.selectAllRefunds");
	}
}
