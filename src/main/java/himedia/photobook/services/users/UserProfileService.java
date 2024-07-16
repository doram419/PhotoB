package himedia.photobook.services.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.photobook.repositories.dao.ProfileDao;
import himedia.photobook.repositories.vo.UsersVo;

@Service
public class UserProfileService {

	@Autowired
	private ProfileDao profileDao;
	
	 public boolean updateProfile(UsersVo userVo) {
		 
	        int updatedCount = profileDao.updateProfile(userVo);
	        return updatedCount == 1;
	    }
}
