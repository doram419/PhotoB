package himedia.photobook.controllers.users;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import himedia.photobook.repositories.dao.UBoardDao;
import himedia.photobook.repositories.dao.UsersDaoImpl;
import himedia.photobook.repositories.vo.BoardVo;
import himedia.photobook.repositories.vo.UsersVo;
import himedia.photobook.services.UBoardService;
import himedia.photobook.services.UserService;
import jakarta.servlet.http.HttpSession;

/**
 * UsersController에서 모두 처리하지말고,
 * 고객 게시판 세부 상황은 이쪽으로 빼기
 * */
@Controller
@RequestMapping("/users")
public class UserBoardController {
	@Autowired
	private UBoardService uBoardService;
	

	
	@GetMapping({"/board"})
	public String usersBoard() {
		return "/WEB-INF/views/users/users_board.jsp";
	}
	
	@RequestMapping("/boardList")
	public String list(Model md) {
		List<Map<String, Object>> list = uBoardService.getBoardInfos();
		md.addAttribute("postList",list);
		System.out.println(list);
		return "/WEB-INF/views/users/users_board.jsp";
	}
	
//	작성 페이지로 이동
	@GetMapping("/board/write")
	public String writeForm(HttpSession session, RedirectAttributes redirectAtt) {
		UsersVo authUser= (UsersVo) session.getAttribute("authUser");
		return "/WEB-INF/views/users/board/board_write.jsp";
	}
	
	@PostMapping("/board/write")
	public String writeAction(@ModelAttribute BoardVo boardVo,HttpSession session, RedirectAttributes redirectAtt) {
		UsersVo authUser = (UsersVo) session.getAttribute("authUser");
		
		boardVo.setUserId(authUser.getUserId());
		uBoardService.write(boardVo);
		
		return "redirect:/users/boardList";
	}
	
	@GetMapping("/board/post/{userId}/{boardId}")
	public String view(@PathVariable("userId") String userId,@PathVariable("boardId") Long boardId, Model md, HttpSession session) {
		System.out.println("userId: "+userId);
		UsersVo authUser = (UsersVo) session.getAttribute("authUser");
		if(authUser==null) {
			return "redirect:/users/boardList";
		}
		BoardVo boardVo = uBoardService.getContent(userId,boardId);
		md.addAttribute("vo",boardVo);
		return "/WEB-INF/views/users/board/board_post.jsp";
	}
	
	
//	@GetMapping({ "/board/post" })
//	public String showPost() {
//		return "/WEB-INF/views/users/board/board_post.jsp";
//	}
}
