package himedia.photobook.controllers.admin;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import himedia.photobook.repositories.vo.AlbumVo;
import himedia.photobook.repositories.vo.InventoryVo;
import himedia.photobook.services.admin.AdminProductService;

@Controller
@RequestMapping({"/admin"})
public class AdminProductController {
	@Autowired
	private AdminProductService adminProductService;
	
	@RequestMapping("/product")
	public String product() {
		return "/WEB-INF/views/admin/product/admin_product.jsp";
	}
	
	@GetMapping("/product/search")
	public String showAlbumInventory(Model model) {
        Map<AlbumVo, InventoryVo> albumInventoryMap = adminProductService.getAlbumInventoryMap();
        model.addAttribute("albumInventoryMap", albumInventoryMap);
        return "/WEB-INF/views/admin/product/admin_product.jsp";
    }

}
