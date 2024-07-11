package himedia.photobook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/admin"})
public class AdminController {
	@RequestMapping({"","/home"})
	public String home() {
		return "/WEB-INF/views/admin/admin_pages.jsp";
	}
	
	@RequestMapping({"/customerManagement", "/customerManage", "/cm"})
	public String customerManagement() {
		return "/WEB-INF/views/admin/admin_customer_management.jsp";
	}
	
	@RequestMapping({"/orderManagement", "/orderManage", "/om"})
	public String orderManagement() {
		return "/WEB-INF/views/admin/admin_order_management.jsp";
	}
	
	@RequestMapping({"/customerService", "/cs"})
	public String customerService() {
		return "/WEB-INF/views/admin/admin_customer_service.jsp";
	}
	
	/**
	 * db로 줄이지 않은 이유는 data base의 약자와 겹치기 때문
	 * */
	@RequestMapping({"/dashboard", "/dash"})
	public String dashboard() {
		return "/WEB-INF/views/admin/admin_dashboard.jsp";
	}
}
