package himedia.photobook.controllers.users;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import himedia.photobook.services.UsersOrderServiceImpl;

@Controller
@RequestMapping({ "/users"})
public class UsersOrderController {
	@Autowired
	private UsersOrderServiceImpl orderService;
	
	@GetMapping({"/order"})
	public String order(Model model) {
		List<Map<String, Object>> orderInfos = orderService.getOrderInfos();
		
		model.addAttribute("orderInfos", orderInfos);
		
		return "/WEB-INF/views/users/users_order.jsp";
	}
}
