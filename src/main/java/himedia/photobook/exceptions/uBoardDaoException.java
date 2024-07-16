package himedia.photobook.exceptions;

import himedia.photobook.repositories.vo.uBoardVo;

public class uBoardDaoException extends RuntimeException {
	
	private uBoardVo uboardVo = null;

//	기본 생성자
	public uBoardDaoException() {

	}
	
	public uBoardDaoException(String message) {
		super();
	}
	
	public uBoardDaoException(String message,uBoardVo uboardVo) {
		super(message);
		this.uboardVo = uboardVo;
	}

}
