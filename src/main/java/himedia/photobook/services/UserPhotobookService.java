package himedia.photobook.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.photobook.repositories.dao.AlbumDao;
import himedia.photobook.repositories.vo.AlbumVo;

@Service
public class UserPhotobookService {
@Autowired
private AlbumDao albumDao;
//private OrderDao orderDao;

public AlbumVo findAlbumIdByOptions(String material, String albumSize, String color) {
	return albumDao.findAlbumIdByOptions(material, albumSize, color);
}
}
