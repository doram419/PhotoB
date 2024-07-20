package himedia.photobook.services.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.photobook.repositories.dao.UsersDao;
import himedia.photobook.repositories.vo.UsersVo;

@Service
public class AdminCustomerService {
	@Autowired
	private UsersDao usersDaoImpl;
	
	// 관리자 고객검색
	public List<UsersVo> searchUsers(String searchCategory, String keyword) {
			return usersDaoImpl.searchUsers(keyword);
	}
	
	// 관리자 고객삭제
	public UsersVo getUserById(String userId) {
		return usersDaoImpl.getUserById(userId);
	}
	
	public void deleteUsers(String userId) {
		usersDaoImpl.deleteUsers(userId);
	}
	
	// 관리자 고객수정
	public boolean updateUsers(UsersVo userVo) {
        int updatedCount = usersDaoImpl.updateUsers(userVo);
        return updatedCount == 1;
    }
}
