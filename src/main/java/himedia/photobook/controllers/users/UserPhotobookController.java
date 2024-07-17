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
			@RequestParam(value = "albumSize", required = false) String albumSize,
			@RequestParam(value = "color", required = false) String color, HttpSession albumsession, Model model) {
		System.out.println("받아온 커버"+material);
		AlbumVo albumVo = userPhotobookService.findAlbumIdByOptions(material, albumSize, color);
		System.out.println("여기서 null을 가져오면 안됨: " + albumVo);
		if (albumVo == null) {
			model.addAttribute("error");
			return "redirect:/users/photobook";
		}

		String albumId = albumVo.getAlbumId();
		albumsession.setAttribute("albumId", albumId);

		return "redirect:/users/photobook/create_Photobook";
	}

//	@PostMapping("/photobookorder")
//	public String photobookorder() {

//		
//		return
//	}
}
