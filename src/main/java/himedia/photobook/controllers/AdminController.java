package himedia.photobook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
	@RequestMapping("/admin")
	public String adminHome() {
		return "/WEB-INF/views/admin/admin-pages.jsp";
	}
}
