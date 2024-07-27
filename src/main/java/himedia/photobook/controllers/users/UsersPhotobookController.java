package himedia.photobook.controllers.users;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.web.multipart.MultipartFile;

import himedia.photobook.repositories.dao.InventoryDaoImpl;
import himedia.photobook.repositories.vo.AlbumVo;
import himedia.photobook.repositories.vo.InventoryVo;
import himedia.photobook.repositories.vo.UsersVo;
import himedia.photobook.services.users.UserPhotobookService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/users")
public class UsersPhotobookController {
	@Autowired
	private UserPhotobookService userPhotobookService;
	@Autowired
	private InventoryDaoImpl inventoryDaoImpl;

	@GetMapping({ "/photobook", "pb", "photo" })
	public String photobook() {
		return "/WEB-INF/views/users/users_photobook.jsp";
	}

	@PostMapping("/create_photobook")
	public String createPhotobook(@RequestParam(value = "material", required = false) String material,
			@RequestParam(value = "color", required = false) String color,
			@RequestParam(value = "albumSize", required = false) String albumSize,
			@RequestParam(value = "oQuantity", required = false) Long oQuantity,
			HttpSession albumsession,
			Model model) {
		AlbumVo albumVo = userPhotobookService.findAlbumIdByOptions(material, color, albumSize);
		
		
		if (albumVo == null) {
			System.out.println(",앨범vo널임"+albumVo);
			model.addAttribute("error");
			return "redirect:/users/photobook";
		}
		String albumId = albumVo.getAlbumId();
		InventoryVo inventoryVo = inventoryDaoImpl.selectOneByAlbumId(albumId);
		Long aQuantity = inventoryVo.getaQuantity();
		System.out.println("남은 수량"+aQuantity);
		if (aQuantity >= oQuantity)	{
		albumsession.setAttribute("albumId", albumId);
		albumsession.setAttribute("oQuantity", oQuantity);
		System.out.println("create_photobook으로 들어오는 수량" + oQuantity);
		return "/WEB-INF/views/users/users_create_photobook.jsp";
		}
		else 	{
			 model.addAttribute("error", "재고가 부족합니다."); 
			return "/WEB-INF/views/users/users_photobook.jsp";
		}
		
		
	}

	@PostMapping("/photobookOrder")
	public String photobookorder(@RequestParam(value = "albumId", required = false) String albumId,
			HttpSession session) {
		UsersVo authUser = (UsersVo) session.getAttribute("authUser");
		String userId = authUser.getUserId();
		InventoryVo inventoryVo = userPhotobookService.findAlbumPriceByAlbumId(albumId);
		Long albumPrice = inventoryVo.getAlbumPrice();
		Long oQuantity = (Long) session.getAttribute("oQuantity");
		Long priceDisplay = albumPrice * oQuantity;
		userPhotobookService.orderInsert(userId, albumId, oQuantity);

		boolean success = userPhotobookService.orderInsert(userId, albumId, oQuantity, multipartFile);


		return "redirect:/users/order";
	}

}
