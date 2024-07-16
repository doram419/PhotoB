package himedia.photobook.controllers.users;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({ "/users"})
public class UserOrderController {
	@RequestMapping({"/order"})
	public String order() {
		return "/WEB-INF/views/users/users_order.jsp";
	}
	
//	@RequestMapping({"{}",""})
//	public String order() {
//		return "/WEB-INF/views/users/users_order.jsp";
//	}
}
