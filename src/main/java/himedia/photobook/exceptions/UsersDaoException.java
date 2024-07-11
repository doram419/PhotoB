package himedia.photobook.exceptions;

import himedia.photobook.repositories.vo.UsersVo;

public class UsersDaoException extends RuntimeException {
		private UsersVo userVo = null;

		public UsersDaoException() {

		}

		public UsersDaoException(String message) {
			super(message);
		}

		public UsersVo getUserVo() {
			return userVo;
		}

		public void setUserVo(UsersVo userVo) {
			this.userVo = userVo;
		}

	}


