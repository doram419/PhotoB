package himedia.photobook.controllers.admin;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import himedia.photobook.services.admin.AdminOrderService;

@Controller

@RequestMapping({ "/admin" })
public class AdminOrderController {

	@Autowired
	private AdminOrderService adminOrderService;

	@GetMapping("/om")
	public String order(Model model) {
		List<Map<String, Object>> orderInfoList = adminOrderService.getOrderAdmin();
		model.addAttribute("orderInfoList", orderInfoList);
		return "/WEB-INF/views/admin/admin_order_management.jsp";
	}

	@GetMapping("/order/detail") // 상세조회 페이지 수정 필요
	public String orderDetail(@RequestParam("orderId") String orderId, Model model) {
		Map<String, Object> orderDetail = adminOrderService.getOrderDetail(orderId);
		model.addAttribute("orderDetail", orderDetail);
		return "/WEB-INF/views/admin/admin_order_detail.jsp";
	}

//	  @GetMapping("/order/search")
//	  public String searchOrder(@RequestParam(value = "keyword", required = false) String keyword, Model model) {
//		    System.out.println("들어가는 keyword: " + keyword);
//		  List<Map<String, Object>> orderInfoList = adminOrderService.searchOrders(keyword);
//	    System.out.println("search"+orderInfoList);
//	    model.addAttribute("orderInfoList", orderInfoList);
//	    System.out.println("controller 모델에 들어가는 정보"+orderInfoList);
//	    return "/WEB-INF/views/admin/admin_order_management.jsp";
//	  }

	@GetMapping("/order/search")
	public String searchUserId(@RequestParam(value = "keyword", required = false) String keyword, Model model) {
	    String userId = adminOrderService.getUserIdByUserName(keyword);
	    model.addAttribute("userId", userId);
		System.out.println("search의 model:"+model);
		return "/WEB-INF/views/admin/admin_order_management.jsp";
	}
}
