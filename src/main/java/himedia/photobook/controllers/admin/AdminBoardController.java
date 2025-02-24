package himedia.photobook.controllers.admin;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import himedia.photobook.repositories.vo.BoardVo;
import himedia.photobook.repositories.vo.CommentsVo;
import himedia.photobook.repositories.vo.InventoryVo;
import himedia.photobook.repositories.vo.UsersVo;
import himedia.photobook.services.admin.AdminCommentServiceImpl;
import himedia.photobook.services.admin.AdminInventoryServiceImpl;
import himedia.photobook.services.users.UBoardServiceImpl;
import jakarta.servlet.http.HttpSession;

/**
 * UsersController에서 모두 처리하지말고, 고객 게시판 세부 상황은 이쪽으로 빼기
 */
@Controller
@RequestMapping("/admin")
public class AdminBoardController {
	@Autowired
	private UBoardServiceImpl uBoardServiceImpl;
	@Autowired
	private AdminCommentServiceImpl adminCommentServiceImpl;
	@Autowired
	private AdminInventoryServiceImpl adminInventoryServiceImpl;

	@RequestMapping("/boardList")
	public String list(Model md) {
		List<Map<String, Object>> list = uBoardServiceImpl.getBoardInfos();
		md.addAttribute("postList", list);
		return "/WEB-INF/views/admin/admin_board.jsp";
	}

//	작성 페이지로 이동
	@GetMapping("/board/write")
	public String writeForm(HttpSession session, RedirectAttributes redirectAtt) {
		UsersVo authUser = (UsersVo) session.getAttribute("authUser");
		return "/WEB-INF/views/admin/board/board_write.jsp";
	}

	@PostMapping("/board/write")
	public String writeAction(@ModelAttribute BoardVo boardVo, HttpSession session, RedirectAttributes redirectAtt) {
		UsersVo authUser = (UsersVo) session.getAttribute("authUser");

		boardVo.setUserId(authUser.getUserId());
		uBoardServiceImpl.write(boardVo);

		return "redirect:/admin/boardList";
	}

	@GetMapping("/board/post/{userId}/{boardId}")
	public String view(@PathVariable("userId") String userId, @PathVariable("boardId") Long boardId, Model md,
			HttpSession session) {
		UsersVo authUser = (UsersVo) session.getAttribute("authUser");
		if (authUser == null) {
			return "redirect:/admin/boardList";
		}

		Map<String, Object> boardVo = uBoardServiceImpl.getContent(userId, boardId);
		CommentsVo commentsVo = adminCommentServiceImpl.getCommentsByBoardId(boardId);
		boolean hasComment = adminCommentServiceImpl.hasComment(boardId);
		md.addAttribute("vo", boardVo);
		md.addAttribute("commentVo", commentsVo);
		md.addAttribute("hasComment", hasComment);
//		md.addAttribute("userVo",usersVo);
		return "/WEB-INF/views/admin/board/board_post.jsp";
	}

	// 편집 페이지
	@GetMapping("/board/{userId}/{boardId}/modify")
	public String modifyForm(@PathVariable("userId") String userId, @PathVariable("boardId") Long boardId, Model md,
			HttpSession session, RedirectAttributes redirectAtt) {
		UsersVo authUser = (UsersVo) session.getAttribute("authUser");
		if (authUser == null) {
			redirectAtt.addFlashAttribute("errorMsg", "자격이 없습니다.");
			return "redirect:/admin/boardList";
		}
		Map<String, Object> boardVo = uBoardServiceImpl.getContent(userId, boardId);
		md.addAttribute("vo", boardVo);
		return "/WEB-INF/views/admin/board/board_modify.jsp";
	}

	// 편집 수행 액션
	@PostMapping("/modify")
	public String modifyAction(@ModelAttribute BoardVo updateVo, HttpSession session, RedirectAttributes redirectAtt) {
		UsersVo authUser = (UsersVo) session.getAttribute("authUser");
		if (authUser == null) {
			redirectAtt.addFlashAttribute("errorMsg", "자격이 없습니다.");
			return "redirect:/admin/boardList";
		}
		BoardVo boardVo = uBoardServiceImpl.getBoardVo(updateVo.getUserId(), updateVo.getBoardId());

		boardVo.setTitle(updateVo.getTitle());
		boardVo.setContent(updateVo.getContent());

		boolean success = uBoardServiceImpl.update(boardVo);
		return "redirect:/admin/boardList";
	}

	// 게시물 삭제
	@RequestMapping("/board/{userId}/{boardId}/delete")
	public String deleteAction(@PathVariable("userId") String userId, @PathVariable("boardId") Long boardId, Model md,
			HttpSession session, RedirectAttributes redirectAtt) {
		UsersVo authUser = (UsersVo) session.getAttribute("authUser");
		if (authUser == null) {
			redirectAtt.addFlashAttribute("errorMsg", "자격이 없습니다.");
			return "redirect:/admin/boardList";
		}
		BoardVo boardVo = uBoardServiceImpl.getBoardVo(userId, boardId);

		uBoardServiceImpl.delete(userId, boardVo.getBoardId());
		return "redirect:/admin/boardList";
	}

	// 관리자 댓글 작성
	@PostMapping("/comment/write")
	public String commentAction(@ModelAttribute CommentsVo commentsVo, @RequestParam("boardId") Long boardId,
			HttpSession session, RedirectAttributes redirectAtt) {
		UsersVo authUser = (UsersVo) session.getAttribute("authUser");
		if (authUser == null) {
			redirectAtt.addFlashAttribute("errorMsg", "자격이 없습니다.");
			return "redirect:/users/boardList";
		}

		commentsVo.setUserName(authUser.getUserName());
		adminCommentServiceImpl.write(commentsVo);
		redirectAtt.addAttribute("boardId", boardId);

		return "redirect:/admin/boardList";
//		return "/WEB-INF/views/admin/board/board_post.jsp";
	}

// 관리자 이름 검색 ( 고객센터 )
	@GetMapping("/customerService/search")
	public String searchBoard(@RequestParam(value = "keyword") String keyword, Model md) {
		List<Map<String, Object>> boardDetail = uBoardServiceImpl.getContentByName(keyword);
		md.addAttribute("boardDetail", boardDetail);
		return "/WEB-INF/views/admin/admin_customer_service.jsp";
	}

// 재고 가격으로 검색 ( 재고 관리 )
	@GetMapping("/inventory/search")
	public String searchInventory(@RequestParam(value = "keyword") String keyword, Model md) {
		InventoryVo invenDetail = adminInventoryServiceImpl.findAlbumPriceByAlbumId(keyword);
		md.addAttribute("invenDetail", invenDetail);
		return "/WEB-INF/views/admin/admin_inventory.jsp";
	}

// 제품 입고 
	@GetMapping("/inventory/store")
	public String putStore(@ModelAttribute InventoryVo inventoryVo, HttpSession session,
			RedirectAttributes redirectAtt) {
		adminInventoryServiceImpl.updateQuantity(inventoryVo);

		System.out.println(inventoryVo);

		return "redirect:/admin/inventory";
	}

}
