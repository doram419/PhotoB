package himedia.photobook.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminRefundController {
	@RequestMapping("/refund")
	public String refund() {
		return "/WEB-INF/views/admin/admin_refund.jsp";
	}
}
