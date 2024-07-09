package himedia.photobook.repositories.vo;

// 최초 작성자 : 김지환
public class RefundVo {
	// 필드
	private Long refundId;
	private String orderId;
	/**
	 * R: 준비, F: 완료
	 * */
	private String refundStatus;

	// 생성자
	public RefundVo() {
	}
	
	public RefundVo(Long refundId, String orderId, String refundStatus) {
		super();
		this.refundId = refundId;
		this.orderId = orderId;
		this.refundStatus = refundStatus;
	}
	
	// Getters / Setters
	public Long getRefundId() {
		return refundId;
	}
	
	public void setRefundId(Long refundId) {
		this.refundId = refundId;
	}
	
	public String getOrderId() {
		return orderId;
	}
	
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
	public String getRefundStatus() {
		return refundStatus;
	}
	
	public void setRefundStatus(String refundStatus) {
		this.refundStatus = refundStatus;
	}

	// toString
	@Override
	public String toString() {
		return "RefundVo [refundId=" + refundId + ", orderId=" + orderId + ", refundStatus=" + refundStatus + "]";
	}	
}
