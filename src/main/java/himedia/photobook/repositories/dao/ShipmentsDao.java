package himedia.photobook.repositories.dao;

import java.util.List;

import himedia.photobook.repositories.vo.ShipmentsVo;

public interface ShipmentsDao {

	/**
	 * orderId로 배송정보 테이블에서 "주문 상태(Shipment_Status)" 정보를 받아오는 메서드 param : String - 주문
	 * 아이디 return type : String - 배송 상태
	 */
	public String selectStatusByOrderID(String orderId);

	/**
	 * orderId로 주문 상태 정보를 받아오는 메서드 param : String - 주문 아이디 return type : ShipmentsVo
	 * - 배송 정보
	 */
	public ShipmentsVo selectShipmentInfoByOrderID(String orderId);

	/**
	 * 모든 배송 상태 정보를 받아오는 메서드 return type : List<ShipmentsVo>
	 */
	public List<ShipmentsVo> selectAll();

	/**
	 * 파라미터를 받아 Shipments의 배송일자와 상태를 업데이트 해주는 메서드 param : ShipmentsVo - 업데이트에 필요한 정보
	 * return : int - 업데이트 영향 받는 튜플 수
	 */
	public int updateDateAndStatusByShipmentId(ShipmentsVo updateVo);

	/**
	 * 일부 keyword와 orderId가 일치하는 모든 배송 정보를 가져오는 메서드 param : String - 주문 아이디 return
	 * type : List<ShipmentsVo> 배송 정보들의 List
	 */
	public List<ShipmentsVo> searchAllByOrderId(String keyword);

	/**
	 * 받은 orderId를 기준으로 배송을 만들어주는 테이블 기본 ShipmentStatus는 A이다 param : String - 주문 아이디
	 */
	public int insert(String orderId);

	public String count();

	public int delete(String orderId);
}
