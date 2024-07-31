package himedia.photobook.repositories.dao;

import himedia.photobook.repositories.vo.PhotoVo;

public interface PhotoDao {
	/**
	 * 파라미터에 담은 PhotoVo 값으로 photo 튜플을 만들어주는 메서드
	 * Param : PhotoVo photoVo - 만들 튜플 값
	 * Return : 영향 받은 튜플 수 
	 * */
	public int insert(PhotoVo photoVo);
	/**
	 * 파라미터에 담은 orderId 값으로 주문에 등록된 
	 * 사진수를 반환해주는 메서드
	 * Param : String orderId - 조회할 orderId
	 * Return : 해당 orderId가 pk인 사진의 개수
	 * */
	public int selectCountByOrderId(String orderId);
	public int delete(String orderId);
}
