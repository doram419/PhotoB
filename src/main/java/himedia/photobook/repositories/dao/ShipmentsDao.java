package himedia.photobook.repositories.dao;

import java.util.List;

import himedia.photobook.repositories.vo.ShipmentsVo;

public interface ShipmentsDao {
	
	/**
	 * orderId로 배송정보 테이블에서 "주문 상태(Shipment_Status)" 정보를 받아오는 메서드
	 * param : String - 주문 아이디
	 * return type : String - 배송 상태
	 * */
	public String selectStatusByOrderID(String orderId);
	
	/**
	 * orderId로 주문 상태 정보를 받아오는 메서드
	 * param : String - 주문 아이디
	 * return type : ShipmentsVo - 배송 정보
	 * */
	public ShipmentsVo selectShipmentInfoByOrderID(String orderId);
	
	/**
	 * 모든 배송 상태 정보를 받아오는 메서드
	 * param : String - 주문 아이디
	 * return type : List<ShipmentsVo> 
	 * */
	public List<ShipmentsVo> selectAll();
}
