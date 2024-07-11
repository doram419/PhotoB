//package himedia.photobook.services;
//
//import himedia.photobook.repositories.UsersRepository;
//import himedia.photobook.repositories.vo.UsersVo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserService {
//
//    @Autowired
//    private UsersRepository usersRepository;
//
//    public boolean register(UsersVo user) {
//        // 이메일 중복 체크
//        UsersVo existingUser = usersRepository.findByEmail(user.getEmail());
//        if (existingUser != null) {
//            return false;
//        }
//
//        // 비밀번호 암호화 (구현 필요)
//        String encryptedPassword = encryptPassword(user.getPassword());
//        user.setPassword(encryptedPassword);
//
//        usersRepository.save(user);
//        return true;
//    }
//
//    public UsersVo login(String email, String password) {
//        UsersVo user = usersRepository.findByEmail(email);
//        if (user == null) {
//            return null;
//        }
//
//        // 비밀번호 검증 (구현 필요)
//        if (!verifyPassword(password, user.getPassword())) {
//            return null;
//        }
//
//        return user;
//    }
//
//    private String encryptPassword(String password) {
//        // 비밀번호 암호화 로직 구현 (예: BCrypt)
//        // 여기서는 간단히 "encrypted_" 접두사를 붙이는 것으로 대체
//        return "encrypted_" + password;
//    }
//
//    private boolean verifyPassword(String plainPassword, String encryptedPassword) {
//        // 비밀번호 검증 로직 구현 (예: BCrypt)
//        // 여기서는 간단히 "encrypted_" 접두사를 제거하고 비교하는 것으로 대체
//        return encryptedPassword.equals("encrypted_" + plainPassword);
//    }
//}