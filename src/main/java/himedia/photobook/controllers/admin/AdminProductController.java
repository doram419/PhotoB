package himedia.photobook.controllers.admin;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    	public String searchProducts(@RequestParam(value = "keyword", required = false) String keyword, Model model) {
		try {
        Map<String, Object> productMap = adminProductService.getProductMap(keyword);
        model.addAttribute("ProductMap", productMap);
		} catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("error", "제품 목록을 가져오는 중 오류가 발생했습니다.");
		}
        return "/WEB-INF/views/admin/product/admin_product.jsp";
    }
	
	@GetMapping("/product/productEdit")
	public String editProduct(@RequestParam("albumId") String albumId, Model model) {
	    return "/WEB-INF/views/admin/product/productEdit.jsp";
	}


}
