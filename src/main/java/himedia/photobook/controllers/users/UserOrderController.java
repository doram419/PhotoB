package himedia.photobook.controllers.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import himedia.photobook.repositories.vo.OrdersVo;
import himedia.photobook.services.UserOrderServiceImpl;

@Controller
@RequestMapping({ "/users"})
public class UserOrderController {
	@Autowired
	private UserOrderServiceImpl orderService;
	
	@GetMapping({"/order"})
	public String order(Model model) {
		List<OrdersVo> orderList = orderService.selectAll();
		
		model.addAttribute("orderList", orderList);
		System.out.println(orderList);
		
		return "/WEB-INF/views/users/users_order.jsp";
	}
	
//	@RequestMapping({"{}",""})
//	public String order() {
//		return "/WEB-INF/views/users/users_order.jsp";
//	}
}
