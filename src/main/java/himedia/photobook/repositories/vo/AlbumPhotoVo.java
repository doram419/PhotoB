package himedia.photobook.repositories.vo;

public class AlbumPhotoVo {
	private String albumPhotoId;
	private String albumId;
	private String photoPath;
	private String albumPhotoType; // L : Inner Left, R : Inner Right, M : Main Imgs
	
	public AlbumPhotoVo()
	{
		
	}
			
	public AlbumPhotoVo(String albumPhotoId, String albumId, String photoPath, String albumPhotoType) {
		super();
		this.albumPhotoId = albumPhotoId;
		this.albumId = albumId;
		this.photoPath = photoPath;
		this.albumPhotoType = albumPhotoType;
	}

	public String getAlbumPhotoId() {
		return albumPhotoId;
	}

	public void setAlbumPhotoId(String albumPhotoId) {
		this.albumPhotoId = albumPhotoId;
	}

	public String getAlbumId() {
		return albumId;
	}

	public void setAlbumId(String albumId) {
		this.albumId = albumId;
	}

	public String getPhotoPath() {
		return photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public String getAlbumPhotoType() {
		return albumPhotoType;
	}

	public void setAlbumPhotoType(String albumPhotoType) {
		this.albumPhotoType = albumPhotoType;
	}

	@Override
	public String toString() {
		return "AlbumPhotoVo [albumPhotoId=" + albumPhotoId + ", albumId=" + albumId + ", photoPath=" + photoPath
				+ ", albumPhotoType=" + albumPhotoType + "]";
	}
}
