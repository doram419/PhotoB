package himedia.photobook.controllers.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * UsersController에서 모두 처리하지말고,
 * 고객 게시판 세부 상황은 이쪽으로 빼기
 * */
@Controller
@RequestMapping("/board")
public class BoardController {
	@GetMapping({ "/","" })
	public String usersBoard() {
		return "/WEB-INF/views/users/users_board.jsp";
	}
	
	@GetMapping({ "/write" })
	public String write() {
		return "/WEB-INF/views/users/board/board_write.jsp";
	}
	
	@GetMapping({ "/post" })
	public String showPost() {
		return "/WEB-INF/views/users/board/board_post.jsp";
	}
}
