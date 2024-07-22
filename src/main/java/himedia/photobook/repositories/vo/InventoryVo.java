package himedia.photobook.repositories.vo;

// 작성자 : 유승원
public class InventoryVo {
	private String albumId;
	private Long albumPrice;
	private int aQuantity;
	
	public InventoryVo() {
		
	}

	public InventoryVo(String albumId,Long albumPrice, int aQuantity) {
		super();
		this.albumId = albumId;
		this.albumPrice = albumPrice;
		this.aQuantity = aQuantity;
	}

	public String getAlbumId() {
		return albumId;
	}

	public void setAlbumId(String albumId) {
		this.albumId = albumId;
	}

	public Long getAlbumPrice() {
		return albumPrice;
	}

	public void setAlbumPrice(Long albumPrice) {
		this.albumPrice = albumPrice;
	}

	public int getaQuantity() {
		return aQuantity;
	}

	public void setaQuantity(int aQuantity) {
		this.aQuantity = aQuantity;
	}

	@Override
	public String toString() {
		return "InventoryVo [albumId=" + albumId + ", albumPrice=" + albumPrice + ", aQuantity=" + aQuantity + "]";
	}
	
}
