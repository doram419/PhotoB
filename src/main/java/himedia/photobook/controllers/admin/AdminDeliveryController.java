package himedia.photobook.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import himedia.photobook.services.admin.AdminDeliveryServiceImpl;

@Controller
@RequestMapping("admin")
public class AdminDeliveryController {
	@Autowired
	private AdminDeliveryServiceImpl adminDeliveryServiceImpl;
	
	@GetMapping("/delivery")
	public String shipment(Model model) {
		model.addAttribute("deliveryInfos", adminDeliveryServiceImpl.getDeliveryInfos());
		
		return "/WEB-INF/views/admin/admin_delivery.jsp";
	}
	
	@GetMapping("/delivery/detail")
	public String detail(Model model,
			@RequestParam("orderId") String orderId) {
		model.addAttribute("deliveryDetailInfos", adminDeliveryServiceImpl.getDeliveryDetailInfo(orderId));
		
		return "/WEB-INF/views/admin/delivery/delivery_detail.jsp";
	}
	
	@PostMapping
	public String modify(Model model,
			@ModelAttribute("orderId") String orderId) {
		model.addAttribute("deliveryDetailInfos", adminDeliveryServiceImpl.getDeliveryDetailInfo(orderId));
		
		return "/WEB-INF/views/admin/delivery/delivery_detail.jsp";
	}
}
