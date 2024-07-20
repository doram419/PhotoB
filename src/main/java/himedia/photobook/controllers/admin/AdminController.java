package himedia.photobook.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;


import himedia.photobook.services.users.UBoardServiceImpl;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping({"/admin"})
public class AdminController {
	@RequestMapping({"","/home"})
	public String home() {
		return "/WEB-INF/views/admin/admin_pages.jsp";
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
	@RequestMapping("/product")
	public String product() {
		return "/WEB-INF/views/admin/admin_product.jsp";
	}
}
