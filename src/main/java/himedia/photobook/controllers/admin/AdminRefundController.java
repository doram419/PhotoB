package himedia.photobook.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import himedia.photobook.services.admin.AdminRefundServiceImpl;

@Controller
@RequestMapping("/admin")
public class AdminRefundController {
	@Autowired
	private AdminRefundServiceImpl adminRefundServiceImpl;
	
	@GetMapping("/refund")
	public String refund(Model model) {
		model.addAttribute("refundInfos", adminRefundServiceImpl.getRefundInfos());
		
		return "/WEB-INF/views/admin/admin_refund.jsp";
	}
}
