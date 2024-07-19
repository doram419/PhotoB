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
		System.out.println(model); // 조회 확인용
		return "/WEB-INF/views/admin/admin_order_management.jsp";
	}

	@GetMapping("/order/detail") //상세조회 페이지 수정 필요
	public String orderDetail(@RequestParam("orderId") String orderId, Model model) {
		Map<String, Object> orderDetail = adminOrderService.getOrderDetail(orderId);
		model.addAttribute("orderDetail", orderDetail);
		return "/WEB-INF/views/admin/admin_order_detail.jsp";
	}
}
