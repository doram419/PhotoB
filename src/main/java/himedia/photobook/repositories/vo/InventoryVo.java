package himedia.photobook.repositories.vo;

public class InventoryVo {
	private String albumId;
	private Long albumPrice;
	private Long aQuantity;
	
	public InventoryVo() {
		
	}




	public InventoryVo(String albumId, Long albumPrice, Long aQuantity) {
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

	public Long getaQuantity() {
		return aQuantity;
	}

	public void setaQuantity(Long aQuantity) {
		this.aQuantity = aQuantity;
	}

	@Override
	public String toString() {
		return "InventoryVo [albumId=" + albumId + ", albumPrice=" + albumPrice + ", aQuantity=" + aQuantity + "]";
	}
	
}
