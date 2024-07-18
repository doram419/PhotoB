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

import himedia.photobook.repositories.dao.UsersDao;
import himedia.photobook.repositories.vo.BoardVo;
import himedia.photobook.repositories.vo.UsersVo;
import himedia.photobook.services.users.UBoardService;
import jakarta.servlet.http.HttpSession;

/**
 * UsersController에서 모두 처리하지말고,
 * 고객 게시판 세부 상황은 이쪽으로 빼기
 * */
@Controller
@RequestMapping("/users")
public class UsersBoardController {
	@Autowired
	private UBoardService uBoardService;
	@Autowired
	private UsersDao usersDao;

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
		UsersVo usersVo = usersDao.selectOneUserById(userId);
		md.addAttribute("vo",boardVo);
		md.addAttribute("userVo",usersVo);
		return "/WEB-INF/views/users/board/board_post.jsp";
	}
	
	// 편집 페이지
	@GetMapping("/board/{userId}/{boardId}/modify")
	public String modifyForm(@PathVariable("userId") String userId,@PathVariable("boardId") Long boardId,Model md, HttpSession session, RedirectAttributes redirectAtt) {
		UsersVo authUser = (UsersVo) session.getAttribute("authUser");
		if(authUser == null) {
			redirectAtt.addFlashAttribute("errorMsg","로그인 하세요~");
			return "redirect:/users/boardList";
		}
		BoardVo boardVo = uBoardService.getContent(userId, boardId);
		md.addAttribute("vo",boardVo);
		return "/WEB-INF/views/users/board/board_modify.jsp";
	}
	
	// 편집 수행 액션
	@PostMapping("/modify")
	public String modifyAction(@ModelAttribute BoardVo updateVo,HttpSession session, RedirectAttributes redirectAtt) {
		UsersVo authUser = (UsersVo) session.getAttribute("authUser");
		if(authUser == null) {
			redirectAtt.addFlashAttribute("errorMsg","로그인 하세요~");
			return "redirect:/users/boardList";
		}
		BoardVo boardVo = uBoardService.getContent(updateVo.getUserId(),updateVo.getBoardId());
		
		boardVo.setTitle(updateVo.getTitle());
		boardVo.setContent(updateVo.getContent());
		
		boolean success = uBoardService.update(boardVo);
		return "redirect:/users/boardList";
	}
	
	// 게시물 삭제
	@RequestMapping("/board/{userId}/{boardId}/delete")
	public String deleteAction(@PathVariable("userId") String userId,@PathVariable("boardId") Long boardId,Model md, HttpSession session, RedirectAttributes redirectAtt) {
		UsersVo authUser = (UsersVo) session.getAttribute("authUser");
		if (authUser == null) {
			redirectAtt.addFlashAttribute("errorMsg", "로그인 실패~");
			return "redirect:/";
		}
		BoardVo boardVo = uBoardService.getContent(userId, boardId);
		
		uBoardService.delete(userId, boardVo.getBoardId());
		return "redirect:/users/boardList";
	}
}
