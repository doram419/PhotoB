package himedia.photobook.controllers.users;

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
import himedia.photobook.services.users.UserOrderServiceImpl;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping({"/users"})
public class UsersOrderController {
	@Autowired
	private UserOrderServiceImpl userOrderServiceImpl;
	
	@GetMapping({"/order"})
	public String order(Model model, HttpSession session) {
		UsersVo user = (UsersVo) session.getAttribute("authUser");
		String userId = null;
		
		if(user != null)
		{
			userId = user.getUserId();
			List<Map<String, Object>> orderInfos = userOrderServiceImpl.getOrderInfos(userId);
			System.out.println(orderInfos);
			
			model.addAttribute("orderInfos", orderInfos);
		}
			
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
		
		model.addAttribute("ordersId", ordersId);
		model.addAttribute("albumId", albumId);
		model.addAttribute("orderDate", orderDate);
		model.addAttribute("oQuantity", oQuantity);
		model.addAttribute("status", status);
		
		return "/WEB-INF/views/users/order/order_detail.jsp";
	}
}
