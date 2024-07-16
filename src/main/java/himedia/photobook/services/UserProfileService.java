package himedia.photobook.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.photobook.repositories.dao.ProfileDaoImpl;
import himedia.photobook.repositories.vo.UsersVo;

@Service("userProfileService")
public class UserProfileService {

	@Autowired
	private ProfileDaoImpl profileDao;
	
	 public boolean updateProfile(UsersVo userVo) {
		 
	        int updatedCount = profileDao.updateProfile(userVo);
	        return updatedCount == 1;
	    }
}
