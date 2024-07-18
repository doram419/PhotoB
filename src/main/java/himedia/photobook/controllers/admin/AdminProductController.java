package himedia.photobook.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/admin"})
public class AdminProductController {
	
	@RequestMapping("/product")
	public String product() {
		return "/WEB-INF/views/admin/admin_product.jsp";
	}

}
