package himedia.photobook.repositories.dao;

import java.util.List;

import himedia.photobook.repositories.vo.UsersVo;

public interface UsersDao {
	public int insert(UsersVo vo);	//	회원 가입
    UsersVo selectUserByEmail(String email);//	중복 이메일 체크
	public UsersVo selectUserByEmailAndPassword(String email, String password);	//	로그인용

	List<UsersVo> searchUsers(String keyword); // 검색 기능 추가
}
