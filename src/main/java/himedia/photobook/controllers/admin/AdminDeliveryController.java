package himedia.photobook.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin")
public class AdminDeliveryController {
	@GetMapping("/delivery")
	public String shipment(Model model) {
		//service.getShipInfo
		
		return "/WEB-INF/views/admin/admin_delivery.jsp";
	}
}
