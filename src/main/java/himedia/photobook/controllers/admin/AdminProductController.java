package himedia.photobook.controllers.admin;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import himedia.photobook.repositories.vo.AlbumVo;
import himedia.photobook.repositories.vo.InventoryVo;
import himedia.photobook.services.admin.AdminProductService;
import jakarta.servlet.http.HttpSession;

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
		try {
		List<AlbumVo> albums = adminProductService.searchAlbum("ALBUM_ID", albumId);
		if (!albums.isEmpty()) {
            model.addAttribute("album", albums.get(0)); // 첫 번째 앨범 정보 전달
        } else {
            model.addAttribute("error", "앨범을 찾을 수 없습니다.");
        }
       } catch (Exception e) {
           e.printStackTrace();
           model.addAttribute("error", "앨범 업데이트 중 오류가 발생했습니다.");
       }
       return "/WEB-INF/views/admin/product/productEdit.jsp"; // 업데이트 후 목록으로 리디렉션
   }


	@PostMapping("/product/update")
    public String updateProduct(@ModelAttribute AlbumVo albumVo, @ModelAttribute InventoryVo inventoryVo, 
            HttpSession session, @RequestParam("albumId") String albumId, Model model) {
        try {
            boolean isUpdated1 = adminProductService.updateAlbum(albumVo);
            boolean isUpdated2 = adminProductService.updateInventory(inventoryVo);
            if (isUpdated1 && isUpdated2) {
                model.addAttribute("success", "앨범이 성공적으로 업데이트 되었습니다.");
            } else {
                model.addAttribute("error", "앨범 업데이트에 실패했습니다.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "앨범 업데이트 중 오류가 발생했습니다.");
        }
        return "redirect:/admin/products/search"; // 업데이트 후 목록으로 리디렉션
    }
	
	@PostMapping("/product/delete")
    public String deleteProduct(@RequestParam("albumId") String albumId, Model model) {
        try {
            adminProductService.deleteAlbum(albumId);
            model.addAttribute("success", "앨범이 성공적으로 삭제되었습니다.");
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "앨범 삭제 중 오류가 발생했습니다.");
        }
        return "redirect:/admin/products/search"; // 삭제 후 목록으로 리디렉션
    }

    @GetMapping("/product/add")
    public String addProduct(AlbumVo albumVo, Model model) {
        try {
        	boolean result = adminProductService.insertAlbum(albumVo);
            if (result) {
                model.addAttribute("success", "앨범이 성공적으로 추가되었습니다.");
            } else {
                model.addAttribute("error", "앨범 추가에 실패했습니다.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "앨범 추가 중 오류가 발생했습니다.");
        }
        return "redirect:/admin/products/search"; // 추가 후 목록으로 리디렉션
    }

}
