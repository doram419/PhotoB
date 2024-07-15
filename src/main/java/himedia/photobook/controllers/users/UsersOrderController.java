package himedia.photobook.controllers.users;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import himedia.photobook.repositories.vo.UsersVo;
import himedia.photobook.services.UsersOrderServiceImpl;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping({"/users"})
public class UsersOrderController {
	@Autowired
	private UsersOrderServiceImpl orderService;
	
	@GetMapping({"/order"})
	public String order(Model model, HttpSession session) {
		UsersVo user = (UsersVo) session.getAttribute("authUser");
		String userId = user.getUserId();
		
		List<Map<String, Object>> orderInfos = orderService.getOrderInfos(userId);
		
		model.addAttribute("orderInfos", orderInfos);
		
		return "/WEB-INF/views/users/users_order.jsp";
	}
	
	/**
	 * 주문 상세보기
	 * */
	@PostMapping({"/order/detail"})
	public String detail(@RequestParam("ordersId") String ordersId, 
			@RequestParam("albumId") String albumId, 
			@RequestParam("orderDate") String orderDate,
			@RequestParam("oQuantity") String oQuantity,
			@RequestParam("status") String status,
			Model model) {
		
		System.out.println("-order detail-");

		model.addAttribute("ordersId", ordersId);
		model.addAttribute("albumId", albumId);
		model.addAttribute("orderDate", orderDate);
		model.addAttribute("oQuantity", oQuantity);
		model.addAttribute("status", status);
		
		return "/WEB-INF/views/users/order/order_detail.jsp";
	}
}
