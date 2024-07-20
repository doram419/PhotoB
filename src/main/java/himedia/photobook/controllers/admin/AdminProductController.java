package himedia.photobook.controllers.admin;

import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import himedia.photobook.services.admin.AdminProductService;

@Controller
@RequestMapping({"/admin"})
public class AdminProductController {
	@Autowired
	private AdminProductService adminProductService;
	
	@GetMapping("/product")
	public String product() {
		return "/WEB-INF/views/admin/product/admin_product.jsp";
	}
	
	@GetMapping("/products/search")
    	public String showAlbumInventory(Model model) {
        Map<String, Object> ProductMap = adminProductService.getProductMap();
        model.addAttribute("ProductMap", ProductMap);
        return "/WEB-INF/views/admin/product/admin_product.jsp";
    }

}
