package himedia.photobook.repositories.vo;

import java.util.Date;

// 작성자 : 유승원
public class OrdersVo {
	private String orderId;
	private Long userId;
	private String albumId;
	private Date orderDate;
	private String total;
	private Long oQuantity;
	
	public OrdersVo() {
		
	}

	public OrdersVo(String orderId, Long userId, String albumId, Date orderDate, String total, Long oQuantity) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.albumId = albumId;
		this.orderDate = orderDate;
		this.total = total;
		this.oQuantity = oQuantity;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getAlbumId() {
		return albumId;
	}

	public void setAlbumId(String albumId) {
		this.albumId = albumId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public Long getoQuantity() {
		return oQuantity;
	}

	public void setoQuantity(Long oQuantity) {
		this.oQuantity = oQuantity;
	}

	@Override
	public String toString() {
		return "OrdersVo [orderId=" + orderId + ", userId=" + userId + ", albumId=" + albumId + ", orderDate="
				+ orderDate + ", total=" + total + ", oQuantity=" + oQuantity + "]";
	}
	
	
}
