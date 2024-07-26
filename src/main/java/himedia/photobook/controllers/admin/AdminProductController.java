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
import org.springframework.web.multipart.MultipartFile;

import himedia.photobook.repositories.vo.AlbumVo;
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
	        List<Map<String, Object>> productMap = adminProductService.getProductInfos(keyword);
	        model.addAttribute("ProductMap", productMap);
		} catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("error", "제품 목록을 가져오는 중 오류가 발생했습니다.");
		}
        return "/WEB-INF/views/admin/product/admin_product.jsp";
    }
	
	@GetMapping("/product/productEdit")
	public String editProduct(@RequestParam("albumId") String albumId, Model model) {
		/*
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
       */
		try {
			Map<String, Object> productMap = adminProductService.getAlbumInfoMap(albumId);
	        model.addAttribute("ProductMap", productMap);
		} catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("error", "제품 목록을 가져오는 중 오류가 발생했습니다.");
		}
       return "/WEB-INF/views/admin/product/productEdit.jsp";
   }


	@PostMapping("/product/update")
    public String updateProduct(@ModelAttribute AlbumVo albumVo, @ModelAttribute("price") Long price,
            					Model model) {
        try {
        	boolean isUpdate = adminProductService.updateProduct(albumVo, price);
            model.addAttribute("success", "앨범 업데이트에 성공했습니다.");
            
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "앨범 업데이트 중 오류가 발생했습니다.");
        }
        return "/WEB-INF/views/admin/product/admin_product.jsp";
    }
	
	@GetMapping("/product/update")
    public String updateForm() {
        return "/WEB-INF/views/admin/product/admin_product.jsp"; 
    }
	
	
	@GetMapping("/product/delete")
    public String deleteProduct(@RequestParam("albumId") String albumId, Model model) {
        try {
        	boolean success =  adminProductService.deleteProduct(albumId);

            model.addAttribute("success", "앨범이 성공적으로 삭제되었습니다.");
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "앨범 삭제 중 오류가 발생했습니다.");
        }
        return "/WEB-INF/views/admin/product/admin_product.jsp"; // 삭제 후 목록으로 리디렉션
    }
	
	 @GetMapping("/product/add")
	    public String addForm() {
	    	
	        return "/WEB-INF/views/admin/product/productAdd.jsp"; // 추가 후 목록으로 리디렉션
	    }

	 //TODO:앨범 추가부터
    @PostMapping("/product/add")
    public String addProduct(
    		@ModelAttribute("albumId") String albumId,
    		@ModelAttribute("material") String material,
    		@ModelAttribute("color") String color,
    		@ModelAttribute("albumSize") String albumSize,
    		@ModelAttribute("albumPrice") Long albumPrice,
    		@RequestParam("fileUploader") MultipartFile multipartFile,
    		Model model) {
    	AlbumVo albumVo = new AlbumVo();
    	albumVo.setAlbumId(albumId);
    	albumVo.setMaterial(material);
    	albumVo.setColor(color);
    	albumVo.setAlbumSize(albumSize);
    	
    	System.out.println("dafkafm" + albumPrice);
    	
        try {
        	boolean result = adminProductService.insertProduct(albumVo, albumPrice, multipartFile);
            if (result) {
                model.addAttribute("success", "앨범이 성공적으로 추가되었습니다.");
            } else {
                model.addAttribute("error", "앨범 추가에 실패했습니다.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "앨범 추가 중 오류가 발생했습니다.");
        }
        return "/WEB-INF/views/admin/product/productAdd.jsp"; // 추가 후 목록으로 리디렉션
    }
    
}
