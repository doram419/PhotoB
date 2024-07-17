package himedia.photobook.controllers.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import himedia.photobook.repositories.vo.AlbumVo;
import himedia.photobook.repositories.vo.UsersVo;
import himedia.photobook.services.UserPhotobookService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/users")
public class UserPhotobookController {
	@Autowired
	private UserPhotobookService userPhotobookService;

//	@RequestMapping({ "/photobook", "pb", "photo" })
//	public String photobook() {
//		return "/WEB-INF/views/users/users_photobook.jsp";
//	}

	@GetMapping({ "/photobook", "pb", "photo" })
	public String photobook() {
		return "/WEB-INF/views/users/users_photobook.jsp";
	}

	@PostMapping("/create_photobook")
	public String createPhotobook(@RequestParam(value = "material", required = false) String material,
			@RequestParam(value = "color", required = false) String color,
			@RequestParam(value = "albumSize", required = false) String albumSize, HttpSession albumsession,
			Model model) {
		AlbumVo albumVo = userPhotobookService.findAlbumIdByOptions(material, color, albumSize);
		if (albumVo == null) {
			model.addAttribute("error");
			return "redirect:/users/photobook";
		}

		String albumId = albumVo.getAlbumId();
		albumsession.setAttribute("albumId", albumId);
		return "/WEB-INF/views/users/users_create_photobook.jsp";
	}

	@PostMapping("/photobookorder")
	public String photobookorder(@RequestParam(value="albumId", required = false) String albumId, HttpSession session){
		System.out.println(albumId);
	
		return "redirect:/users/order";
	}
}
