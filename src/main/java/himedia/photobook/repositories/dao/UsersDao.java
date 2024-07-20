package himedia.photobook.repositories.dao;

import java.util.List;
import himedia.photobook.repositories.vo.UsersVo;

public interface UsersDao {
	public int insert(UsersVo vo);	//	회원 가입
    public UsersVo selectUserByEmail(String email);//	중복 이메일 체크
	public UsersVo selectUserByEmailAndPassword(String email, String password);	//	로그인용
	public UsersVo getUserById(String userId);

	public List<UsersVo> searchUsers(String keyword); // 검색 기능 추가
	public void deleteUsers(String userId);
	public int updateUsers(UsersVo user);
	
	/**
	 * userId로 유저 정보를 조회 할 수 있는 메서드
	 * */
	public int updateUser(UsersVo vo);	//	프로필 업데이트
	public UsersVo selectOneUserById(String Id);

}
