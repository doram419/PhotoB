package himedia.photobook.repositories.dao;

import himedia.photobook.repositories.vo.UsersVo;

public interface UsersDao {
	public int insert(UsersVo vo);	//	회원 가입
	public UsersVo selectUser(String email);	//	중복 이메일 체크
	public UsersVo selectUser(String email, String password);	//	로그인용
}
