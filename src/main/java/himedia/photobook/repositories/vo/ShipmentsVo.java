package himedia.photobook.repositories.vo;

import java.util.Date;

public class ShipmentsVo {
	// 필드
	private Long shipmentId;
	private String orderId;
	private Date shipmentDate;
	/**
	 * 주문 상태는 기본적으로 배송 상태를 봐야한다. R가 나오면 환불에서 보기 
	 * A(Application): 준비 
	 * B(Before Shipping): 배송중 
	 * C(Complete):배송완료, 
	 * R(Refund): 환불
	 **/
	private String shipmentStatus;
	
	// 생성자
	public ShipmentsVo() {
	}
	
	public ShipmentsVo(Long shipmentId, String orderId, Date shipmentDate, String shipmentStatus) {
		super();
		this.shipmentId = shipmentId;
		this.orderId = orderId;
		this.shipmentDate = shipmentDate;
		this.shipmentStatus = shipmentStatus;
	}

	// Getters / Setters
	public Long getShipmentId() {
		return shipmentId;
	}

	public void setShipmentId(Long shipmentId) {
		this.shipmentId = shipmentId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Date getShipmentDate() {
		return shipmentDate;
	}

	public void setShipmentDate(Date shipmentDate) {
		this.shipmentDate = shipmentDate;
	}

	public String getShipmentStatus() {
		return shipmentStatus;
	}

	public void setShipmentStatus(String shipmentStatus) {
		this.shipmentStatus = shipmentStatus;
	}

	// toString
	@Override
	public String toString() {
		return "ShipmentsVo [shipmentId=" + shipmentId + ", orderId=" + orderId + ", shipmentDate=" + shipmentDate
				+ ", shipmentStatus=" + shipmentStatus + "]";
	}
}
