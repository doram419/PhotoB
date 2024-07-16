package himedia.photobook.repositories.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import himedia.photobook.repositories.vo.ShipmentsVo;

@Repository("shipmentsDao")
public class ShipmentsDaoImpl {
	@Autowired
	private SqlSession session;
	
	/**
	 * orderId로 배송정보 테이블에서 "주문 상태(Shipment_Status)" 정보를 받아오는 메서드
	 * param : String - 주문 아이디
	 * return type : String - 배송 상태
	 * */
	public String selectStatusByOrderID(String orderId) {
		return session.selectOne("shipments.selectStatusByOrderID", orderId);
	}
	
	/**
	 * orderId로 주문 상태 정보를 받아오는 메서드
	 * param : String - 주문 아이디
	 * return type : ShipmentsVo - 배송 정보
	 * */
	public ShipmentsVo selectShipmentInfoByOrderID(String orderId) {
		return session.selectOne("shipments.selectShipmentInfoByOrderID", orderId);
	}
}
