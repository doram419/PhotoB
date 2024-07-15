package himedia.photobook.repositories.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import himedia.photobook.repositories.vo.AlbumVo;

/**
 * 배운 것과 다르게 interface 구현은 하지 않음
 * 이후 기능상 겹치는 부분이 있으면 따로 인터페이스 구현 할 예정
 * 그러나 이름은 수정이 있을 가능성을 고려하여 ~impl로 함 
 * */
@Repository("albumDao")
public class AlbumDaoImpl {
	@Autowired
	private SqlSession session;
	
	/**
	 * 앨범 ID로 album 튜플을 가져오는 메서드
	 * exception 처리 필요함
	 * */
	public AlbumVo selectOneById(String albumId) throws IllegalArgumentException{
		return session.selectOne(albumId);
	}
}
