package himedia.photobook.repositories.dao;
import java.util.HashMap;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import himedia.photobook.exceptions.UsersDaoException;
import himedia.photobook.repositories.vo.UsersVo;

@Repository("userDao")
public class UsersDaoImpl implements UsersDao {
	@Autowired
	private SqlSession sqlSession;

	@Override
	// 유저 정보 저장하는거
	public int insert(UsersVo vo) {		
		try {
			// role 값을 "U"로 설정
			
			vo.setRole("U");	
			System.out.println("확인");
			return sqlSession.insert("users.insert", vo);

		} catch (Exception e) {
			e.printStackTrace();
			throw new UsersDaoException("회원 가입 중 에러!"); // Exception 아직 안해서 그럼. 이름 확인하고 만들어주세요.
		}
	}

	@Override // 이메일 조회, 중복체크에 쓸거
	public UsersVo selectUserByEmail(String email) {
	    List<UsersVo> userList = sqlSession.selectList("users.selectUserByEmail", email);
	    if (userList != null && !userList.isEmpty()) {
	        return userList.get(0);
	    }
	    return null;
	}
	@Override
	// 비번, 이메일로 조회. 로그인에 쓸거
	public UsersVo selectUserByEmailAndPassword(String email, String password) {
		Map<String, String> userMap = new HashMap<>();
		userMap.put("email", email);
		userMap.put("password", password); // 여기 파라미터타입 users.xml에 명시하지 않아도 되는지 모르겠음. 일단 안했음.

		UsersVo userVo = sqlSession.selectOne("users.selectUserByEmailAndPassword", userMap);
		return userVo;
	}

	@Override
	public List<UsersVo> searchUsers(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}
}