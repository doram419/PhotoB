package himedia.photobook.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import himedia.photobook.repositories.vo.InventoryVo;
import himedia.photobook.services.admin.AdminInventoryServiceImpl;
import himedia.photobook.services.users.UBoardServiceImpl;


@Controller
@RequestMapping({"/admin"})
public class AdminController {
	@Autowired
	private UBoardServiceImpl uBoardService;
	@Autowired
	private AdminInventoryServiceImpl adminInventoryService;
	
	@RequestMapping({"","/home"})
	public String home() {
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
	@RequestMapping("/inventory")
	public String inventory(@RequestParam(value = "page", defaultValue = "1") int page,@RequestParam(value = "size", defaultValue = "10") int size ,Model md) {
		List<InventoryVo> list = adminInventoryService.getPagedInventory(page, size);
		
		md.addAttribute("invenList",list);
	    md.addAttribute("currentPage", page);
		return "/WEB-INF/views/admin/admin_inventory.jsp";
	}
	
}
