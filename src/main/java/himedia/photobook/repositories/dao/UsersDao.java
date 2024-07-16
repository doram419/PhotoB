package himedia.photobook.repositories.dao;

import himedia.photobook.repositories.vo.UsersVo;

public interface UsersDao {
	public int insert(UsersVo vo);	//	회원 가입
    UsersVo selectUserByEmail(String email);//	중복 이메일 체크
	public UsersVo selectUserByEmailAndPassword(String email, String password);	//	로그인용
	public UsersVo selectUserByUserId(String userId);
}
