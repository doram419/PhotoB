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

public AlbumVo findAlbumIdByOptions(String material, String albumSize, String color) {
	System.out.println("service받는지 확인"+material+albumSize+color);
	AlbumVo albumVo =albumsDao.findAlbumIdByOptions(material, albumSize, color);
	
	System.out.println("service vo: "+albumVo);
	return albumVo;
}
}
