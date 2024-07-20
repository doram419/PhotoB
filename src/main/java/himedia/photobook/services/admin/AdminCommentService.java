package himedia.photobook.services.admin;

import himedia.photobook.repositories.vo.BoardVo;
import himedia.photobook.repositories.vo.CommentsVo;

public interface AdminCommentService {
	public boolean write(CommentsVo commentsVo);
}
