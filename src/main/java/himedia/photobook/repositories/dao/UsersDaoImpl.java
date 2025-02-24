package himedia.photobook.repositories.dao;

import java.util.HashMap;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import himedia.photobook.exceptions.UsersDaoException;
import himedia.photobook.repositories.vo.OrdersVo;
import himedia.photobook.repositories.vo.ShipmentsVo;
import himedia.photobook.repositories.vo.UsersVo;

@Repository
public class UsersDaoImpl implements UsersDao {
	@Autowired
	private SqlSession sqlSession;

	@Override
	// 유저 정보 저장하는거
	public int insert(UsersVo vo) {
		try {
			vo.setRole("U");
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

		userMap.put("password", password);
		UsersVo userVo = sqlSession.selectOne("users.selectUserByEmailAndPassword", userMap);

		return userVo;
	}

	@Override
	public UsersVo getUserById(String userId) {
		return sqlSession.selectOne("users.getUserById", userId);
	}

	@Override
	public List<UsersVo> searchUsers(String keyword) {
		// 파라미터
		return sqlSession.selectList("users.searchUsers", keyword);
	}

	@Override
	public void deleteUsers(String userId) {
		sqlSession.delete("users.deleteUsers", userId);
	}

	@Override
	public int updateUsers(UsersVo user) {
		try {
			System.out.println(user);
			int updatedCount = sqlSession.update("users.updateUsers", user);
			return updatedCount;
		} catch (Exception e) {
			e.printStackTrace();
			throw new UsersDaoException("업데이트 도중 예외 발생!");
		}
	}

	// 프로필 업데이트에 쓸거
	@Override
	public int updateUser(UsersVo user) {
		try {
			int updatedCount = sqlSession.update("users.updateUser", user);
			return updatedCount;
		} catch (Exception e) {
			e.printStackTrace();
			throw new UsersDaoException("예외 발생!");
		}
	}

	@Override
	public UsersVo selectOneUserById(String Id) {
		UsersVo est = sqlSession.selectOne("users.selectUserById", Id);
		return est;
	}

	@Override
	public List<String> getUserNameByUserId(String userId) {

		return sqlSession.selectList("users.getUserNameByUserId", userId);
	}

	@Override
	public List<UsersVo> selectUserByName(String userName) {
		return sqlSession.selectList("users.selectUserByName", userName);
	}

	@Override
	public List<UsersVo> selectUserByKeyword(String keyword) {
		return sqlSession.selectList("users.selectUserByKeyword", keyword);
	}

}
