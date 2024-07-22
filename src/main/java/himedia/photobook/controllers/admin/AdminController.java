package himedia.photobook.controllers.admin;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

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
	@GetMapping({"/inventory","/inven", "/iv"})
	public String inventory() {
		return "/WEB-INF/views/admin/admin_inventory.jsp";

	}
	

}
