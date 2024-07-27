package himedia.photobook.controllers.admin;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import himedia.photobook.repositories.vo.OrdersVo;
import himedia.photobook.repositories.vo.ShipmentsVo;
import himedia.photobook.repositories.vo.UsersVo;
import himedia.photobook.services.admin.AdminDeliveryServiceImpl;
import himedia.photobook.tools.DataConverter;

@Controller
@RequestMapping("admin")
public class AdminDeliveryController {
	private DataConverter dataConverter = new DataConverter();

	@Autowired
	private AdminDeliveryServiceImpl adminDeliveryServiceImpl;

	@GetMapping("/delivery")
	public String shipment(Model model) {
		model.addAttribute("deliveryInfos", adminDeliveryServiceImpl.getDeliveryInfos());

		return "/WEB-INF/views/admin/admin_delivery.jsp";
	}

	@GetMapping("/delivery/detail")
	public String detail(Model model, @RequestParam("orderId") String orderId) {
		model.addAttribute("deliveryDetailInfos", adminDeliveryServiceImpl.getDeliveryDetailInfo(orderId));

		return "/WEB-INF/views/admin/delivery/delivery_detail.jsp";
	}

	@PostMapping("/delivery/modify")
	public String modify(@ModelAttribute ShipmentsVo shipmentsVo, @ModelAttribute UsersVo usersVo,
			@ModelAttribute OrdersVo ordersVo, @ModelAttribute("stringShipmentDate") String shipmentDate,
			@ModelAttribute("stringOrderDate") String orderDate,
			@ModelAttribute("targetOrderId") String targetOrderId) {
		try {
			shipmentsVo.setShipmentDate(dataConverter.StringToDate(shipmentDate));
			ordersVo.setOrderDate(dataConverter.StringToDate(orderDate));
		} catch (ParseException e) {
			e.printStackTrace();
			// TODO: custom Error throw 하기
		}

		Map<String, Object> deliveryInfo = new HashMap<String, Object>();
		deliveryInfo.put("shipmentsVo", shipmentsVo);
		deliveryInfo.put("usersVo", usersVo);
		deliveryInfo.put("ordersVo", ordersVo);
		deliveryInfo.put("targetOrderId", targetOrderId);

		adminDeliveryServiceImpl.updateDeliveryInfo(deliveryInfo);

		return "redirect:/admin/delivery";
	}

	@PostMapping("/delivery/search")
	public String search(Model model, @RequestParam("keyword") String keyword,
			@RequestParam("search-category") String category) {

		if (category.equals("orderId"))
			model.addAttribute("deliveryInfos", adminDeliveryServiceImpl.searchInfosByOrderId(keyword));
		else if (category.equals("usersName"))
			model.addAttribute("deliveryInfos", adminDeliveryServiceImpl.searchInfosByUserName(keyword));

		return "/WEB-INF/views/admin/admin_delivery.jsp";
	}

	@GetMapping("/Nshipment")
	public String Nshipment(Model model) {
		model.addAttribute("deliveryInfos", adminDeliveryServiceImpl.getDeliveryInfos());
		return "/WEB-INF/views/admin/admin_none_delivery.jsp";

	}
}
