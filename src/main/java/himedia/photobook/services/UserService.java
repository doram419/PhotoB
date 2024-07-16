package himedia.photobook.services;
import himedia.photobook.repositories.dao.UsersDao;
import himedia.photobook.repositories.vo.UsersVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UsersDao userDao;

   public boolean register(UsersVo user) {
        UsersVo existingUser = userDao.selectUserByEmail(user.getEmail());
        if (existingUser != null) {
            return false;	
        }

        // 비밀번호 암호화 (구현 필요)
        String encryptedPassword = encryptPassword(user.getPassword());
        user.setPassword(encryptedPassword);
        
        // 회원가입 처리
       	  int result = userDao.insert(user);
       	  return result > 0;
    }

   	// 로그인
   public UsersVo login(String email, String password) {
	   String encryptedPassword = encryptPassword(password);
	    UsersVo user = userDao.selectUserByEmailAndPassword(email, encryptedPassword);
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
   
}


