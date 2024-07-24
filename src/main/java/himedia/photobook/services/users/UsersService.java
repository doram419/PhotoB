package himedia.photobook.services.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.photobook.repositories.dao.UsersDao;
import himedia.photobook.repositories.vo.UsersVo;


/**
 * 유저 서비스입니다
 * */
@Service
public class UsersService {
    @Autowired
    private UsersDao usersDaoImpl;
    
   public boolean register(UsersVo user) {
        UsersVo existingUser = usersDaoImpl.selectUserByEmail(user.getEmail());
        if (existingUser != null) {
            return false;	
        }

        // 비밀번호 암호화 (구현 필요)
        String encryptedPassword = encryptPassword(user.getPassword());
        user.setPassword(encryptedPassword);
        
        // 회원가입 처리
       	  int result = usersDaoImpl.insert(user);
       	  return result > 0;
    }

   	// 로그인
   public UsersVo login(String email, String password) {
	   String encryptedPassword = encryptPassword(password);
	    UsersVo user = usersDaoImpl.selectUserByEmailAndPassword(email, encryptedPassword);
	    if (user != null) {
	      
	        
	        if (user.getPassword().equals(encryptedPassword)) {
	            return user;
	        }
	    }
	    return null;
	}
    private String encryptPassword(String password) {
        // 비밀번호 암호화 로직 구현 (예: BCrypt)
        // 여기서는 간단히 "encrypted_" 접두사를 붙이는 것으로 대체
        return "encrypted_" + password;
    }

    
    // 프로필 업데이트
	 public boolean updateUser(UsersVo userVo) {
		 
	        int updatedCount = usersDaoImpl.updateUser(userVo);
	        return updatedCount == 1;
	    }
	 // id로 이름찾기
	 public List<String> getUserNameByUserId(String userId) {
	        return usersDaoImpl.getUserNameByUserId(userId);
	    }
}
