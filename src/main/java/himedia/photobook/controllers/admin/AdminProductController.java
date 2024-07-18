package himedia.photobook.controllers.admin;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import himedia.photobook.repositories.vo.AlbumVo;
import himedia.photobook.services.admin.AdminProductService;

@Controller
@RequestMapping({"/admin"})
public class AdminProductController {
	@Autowired
	private AdminProductService AdminProductService;
	
	@RequestMapping("/product")
	public String product() {
		return "/WEB-INF/views/admin/product/admin_product.jsp";
	}
	
	@GetMapping("/product/search")
	public String searchAlbum(@RequestParam Map<String, String> params, Model model) {
		String searchCategory = params.getOrDefault("search-category", null);
		String keyword = params.getOrDefault("keyword", null);
		List<AlbumVo> AlbumList = AdminProductService.searchAlbum(searchCategory, keyword);
		model.addAttribute("AlbumList", AlbumList);
		return "/WEB-INF/views/admin/product/admin_product.jsp";
	}

}
