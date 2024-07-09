package himedia.photobook.repositories.vo;

// 작성자 : 유승원
public class PhotoVo {
	private String photoId;
	private String orderId;
	private String photoName;
	
	public PhotoVo() {
		
	}

	public PhotoVo(String photoId, String orderId, String photoName) {
		super();
		this.photoId = photoId;
		this.orderId = orderId;
		this.photoName = photoName;
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
		return "PhotoVo [photoId=" + photoId + ", orderId=" + orderId + ", photoName=" + photoName + "]";
	}
	

}
