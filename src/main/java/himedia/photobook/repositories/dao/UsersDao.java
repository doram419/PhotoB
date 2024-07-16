package himedia.photobook.repositories.dao;

import java.util.List;

import himedia.photobook.repositories.vo.UsersVo;

public interface UsersDao {
	// 고객 전체 조회
	public List<UsersVo> getAllUser();
	
	public int insert(UsersVo vo);	//	회원 가입
    UsersVo selectUserByEmail(String email);//	중복 이메일 체크
	public UsersVo selectUserByEmailAndPassword(String email, String password);	//	로그인용

	
	// 고객 상세 조회 (이름 , 회원id, 이메일, 핸드폰 으로 조회)
	public UsersVo getOneUser(String name); 
	
}
