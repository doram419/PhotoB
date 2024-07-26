package himedia.photobook.repositories.vo;

public class PhotoVo {
	private String photoId;
	private String orderId;
	private String photoPath;
	private Long photoSeqNo;
	
	public PhotoVo() {
		
	}

	public PhotoVo(String photoId, String orderId, String photoPath, Long photoSeqNo) {
		super();
		this.photoId = photoId;
		this.orderId = orderId;
		this.photoPath = photoPath;
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

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}


	public Long getPhotoSeqNo() {
		return photoSeqNo;
	}

	public void setPhotoSeqNo(Long photoSeqNo) {
		this.photoSeqNo = photoSeqNo;
	}
	
	@Override
	public String toString() {
		return "PhotoVo [photoId=" + photoId + ", orderId=" + orderId + ", photoPath=" + photoPath +
				", photoSeqNo=" + photoSeqNo + "]";
	}
}
