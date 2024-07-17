package himedia.photobook.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.photobook.repositories.dao.AlbumDao;
import himedia.photobook.repositories.vo.AlbumVo;

@Service("userPhotobookService")
public class UserPhotobookService {
	@Autowired
	private AlbumDao albumsDao;
//private OrderDao orderDao;

	public AlbumVo findAlbumIdByOptions(String material, String color, String albumSize) {
		AlbumVo albumVo = albumsDao.findAlbumIdByOptions(material, color, albumSize);
		return albumVo;
	}
}
