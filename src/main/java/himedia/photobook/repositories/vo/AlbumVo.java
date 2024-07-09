package himedia.photobook.repositories.vo;

// 작성자 : 유승원
public class AlbumVo {
	private String albumId;
	private String material;  /* Linen, Leather, Hard, Soft */
	private String color;       /* Gray, Blue, Brown*/
	private String albumSize;  /* Small Middle Big*/
	
	public AlbumVo() {
		
	}

	public AlbumVo(String albumId, String material, String color, String albumSize) {
		super();
		this.albumId = albumId;
		this.material = material;
		this.color = color;
		this.albumSize = albumSize;
	}

	public String getAlbumId() {
		return albumId;
	}

	public void setAlbumId(String albumId) {
		this.albumId = albumId;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getAlbumSize() {
		return albumSize;
	}

	public void setAlbumSize(String albumSize) {
		this.albumSize = albumSize;
	}

	@Override
	public String toString() {
		return "AlbumVo [albumId=" + albumId + ", material=" + material + ", color=" + color + ", albumSize="
				+ albumSize + "]";
	}
	

}
