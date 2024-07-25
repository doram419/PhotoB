package himedia.photobook.repositories.vo;

public class PhotoVo {
	private String photoId;
	private String orderId;
	private String photoName;
	private Long photoSeqNo;
	
	public PhotoVo() {
		
	}

	public PhotoVo(String photoId, String orderId, String photoName, Long photoSeqNo) {
		super();
		this.photoId = photoId;
		this.orderId = orderId;
		this.photoName = photoName;
		this.photoSeqNo = photoSeqNo;
	}

	public String getPhotoId() {
		return photoId;
	}

	public void setPhotoId(String photoId) {
		this.photoId = photoId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getPhotoName() {
		return photoName;
	}

	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}

	@Override
	public String toString() {
		return "PhotoVo [photoId=" + photoId + ", orderId=" + orderId + ", photoName=" + photoName +
				", photoSeqNo=" + photoSeqNo + "]";
	}

	public Long getPhotoSeqNo() {
		return photoSeqNo;
	}

	public void setPhotoSeqNo(Long photoSeqNo) {
		this.photoSeqNo = photoSeqNo;
	}
}
