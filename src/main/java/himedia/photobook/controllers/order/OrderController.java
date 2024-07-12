package himedia.photobook.controllers.order;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({ "/order" })
public class OrderController {
	@RequestMapping({"/",""})
	public String order() {
		return "/WEB-INF/views/users/users_order.jsp";
	}
	
//	@RequestMapping({"{}",""})
//	public String order() {
//		return "/WEB-INF/views/users/users_order.jsp";
//	}
}
