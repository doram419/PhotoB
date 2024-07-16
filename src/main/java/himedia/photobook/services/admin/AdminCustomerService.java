package himedia.photobook.services.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import himedia.photobook.repositories.dao.UsersDao;
import himedia.photobook.repositories.vo.UsersVo;

public class AdminCustomerService {
	@Autowired
	private static UsersDao userDao;
	
	// 관리자 고객검색
		public static List<UsersVo> searchUsers(String searchCategory, String keyword) {
			String searchKeyword = "%" + keyword + "%";
			return userDao.searchUsers(searchKeyword);
			
	}
	
}
