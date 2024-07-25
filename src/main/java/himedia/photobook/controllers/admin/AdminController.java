package himedia.photobook.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import himedia.photobook.repositories.dao.OrderDaoImpl;
import himedia.photobook.services.admin.AdminCommentServiceImpl;
import himedia.photobook.services.admin.AdminDeliveryServiceImpl;
import himedia.photobook.services.admin.AdminOrderService;
import himedia.photobook.services.admin.AdminRefundServiceImpl;
import himedia.photobook.services.users.UBoardServiceImpl;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping({"/admin"})
public class AdminController {
	@Autowired
	private UBoardServiceImpl uBoardService;
	@Autowired
	private AdminOrderService adminOrderService;
	@Autowired
	private AdminDeliveryServiceImpl adminDeliveryServiceImpl;
	@Autowired
	private AdminRefundServiceImpl adminRefundServiceImpl;
	@Autowired
	private AdminCommentServiceImpl adminCommentServiceImpl;
	
	@RequestMapping({"","/home"})
	public String home(Model model) {
	    String count = adminOrderService.count();
	    String scount = adminDeliveryServiceImpl.count();
	    String rcount = adminRefundServiceImpl.count();
	    String ccount = adminCommentServiceImpl.count();
	    model.addAttribute("OrderCount", count);
	    model.addAttribute("ShipCount", scount);
	    model.addAttribute("RefCount",rcount);
	    model.addAttribute("CsCount",ccount);
	    return "/WEB-INF/views/admin/admin_pages.jsp";
	}
	
	@RequestMapping({"/customerService", "/cs"})
	public String customerService(Model md) {
		List<Map<String, Object>> list = uBoardService.getBoardInfos();
		md.addAttribute("postList", list);
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
	@RequestMapping("/product")
	public String product() {
		return "/WEB-INF/views/admin/admin_product.jsp";
	}
}
