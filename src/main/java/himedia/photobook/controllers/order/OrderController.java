package himedia.photobook.controllers.order;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import himedia.photobook.repositories.vo.OrdersVo;
import himedia.photobook.service.OrderService;

@Controller
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	
	
}
