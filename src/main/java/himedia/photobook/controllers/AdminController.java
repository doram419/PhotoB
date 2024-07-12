package himedia.photobook.controllers;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping({"/admin"})
public class AdminController {
	@RequestMapping({"","/home"})
	public String home() {
		return "admin/admin_pages";
	}
	
	@RequestMapping({"/customerManagement", "/customerManage", "/cm"})
	public String customerManagement() {
		return "admin/admin_customer_management";
	}
	
	@RequestMapping({"/orderManagement", "/orderManage", "/om"})
	public String orderManagement() {
		return "admin/admin_order_management";
	}
	
	@RequestMapping({"/customerService", "/cs"})
	public String customerService() {
		return "admin/admin_customer_service";
	}
	
	/**
	 * db로 줄이지 않은 이유는 data base의 약자와 겹치기 때문
	 * */
	@RequestMapping({"/dashboard", "/dash"})
	public String dashboard() {
		return "admin/admin_dashboard";
	}

	@RequestMapping("/refund")
	public String refund() {
		return "/WEB-INF/views/admin/admin_refund.jsp";
	}
	@RequestMapping("/delivery")
	public String shipment() {
		return "/WEB-INF/views/admin/admin_delivery.jsp";
		
	}

	@GetMapping("/update")
	public String customerUpdate() {
		return "/WEB-INF/views/admin/admin_customer_update.jsp";
	}
	
	@GetMapping("/delete")
	public String customerDelete() {
		return "/WEB-INF/views/admin/admin_customer_delete.jsp";

	}

}
