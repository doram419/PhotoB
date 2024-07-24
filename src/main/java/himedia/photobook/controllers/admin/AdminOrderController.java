package himedia.photobook.controllers.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import himedia.photobook.repositories.vo.AlbumVo;
import himedia.photobook.repositories.vo.OrdersVo;
import himedia.photobook.repositories.vo.UsersVo;
import himedia.photobook.services.admin.AdminOrderService;
import himedia.photobook.services.users.UsersService;

@Controller

@RequestMapping({ "/admin" })
public class AdminOrderController {

	@Autowired
	private AdminOrderService adminOrderService;
	@Autowired
	private UsersService usersService;

	@GetMapping("/om")
	public String order(Model model) {
		List<Map<String, Object>> orderList = adminOrderService.getOrderAdmin();
		model.addAttribute("orderList", orderList);
		return "/WEB-INF/views/admin/admin_order_management.jsp";
	}

	@GetMapping("/order/detail") // 상세조회 페이지 수정 필요
	public String orderDetail(@RequestParam("orderId") String orderId, Model model) {
		Map<String, Object> orderDetail = adminOrderService.getOrderDetail(orderId);
		model.addAttribute("orderDetail", orderDetail);
		return "/WEB-INF/views/admin/admin_order_detail.jsp";
	}

	@GetMapping("/order/search")
	public String searchUserId(@RequestParam(value = "keyword", required = false) String keyword, Model model) {
		model.addAttribute("orderList", adminOrderService.searchOrderInfo(keyword));	
		return "/WEB-INF/views/admin/admin_order_management.jsp";}
	
	@PostMapping("/order/createShipment")
	public String createOrder(@ModelAttribute("createOrderId") String orderId) {
		// TODO: service에서 order를 위해 map으로 보낼 때, 해당 order_id로 배송을 만들 수 있는지 없는지 체크 해야함 
		
		// TODO: 여기서도 결과가 되는지 안 되는지 체크
		boolean createResult = adminOrderService.createShipmentByOrderId(orderId);
		
		return "redirect:/admin/om";
	}
	
	@PostMapping("/order/createRefund")
	public String createRefund(@ModelAttribute("createOrderId") String orderId) {
		// TODO: service에서 order를 위해 map으로 보낼 때, 해당 order_id로 배송을 만들 수 있는지 없는지 체크 해야함 
		
		// TODO: 여기서도 결과가 되는지 안 되는지 체크
		boolean createResult = adminOrderService.createRefundByOrderId(orderId);
		
		return "redirect:/admin/om";
	}
}
