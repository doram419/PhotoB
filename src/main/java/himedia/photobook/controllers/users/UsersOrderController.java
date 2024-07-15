package himedia.photobook.controllers.users;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import himedia.photobook.repositories.vo.UsersVo;
import himedia.photobook.services.UsersOrderServiceImpl;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping({ "/users"})
public class UsersOrderController {
	@Autowired
	private UsersOrderServiceImpl orderService;
	
	@GetMapping({"/order"})
	public String order(Model model, HttpSession session) {
		UsersVo user = (UsersVo) session.getAttribute("authUser");
		System.out.println("user : " + user);
		String userId = user.getUserId();
		System.out.println("user_id : " + userId);
		
		List<Map<String, Object>> orderInfos = orderService.getOrderInfos(userId);
		
		model.addAttribute("orderInfos", orderInfos);
		
		return "/WEB-INF/views/users/users_order.jsp";
	}
}
