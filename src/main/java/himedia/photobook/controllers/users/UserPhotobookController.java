package himedia.photobook.controllers.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import himedia.photobook.repositories.vo.AlbumVo;
import himedia.photobook.services.UserPhotobookService;

@Controller
@RequestMapping("/users")
public class UserPhotobookController {
	@Autowired
	private UserPhotobookService userphotobookService;

//	@RequestMapping({ "/photobook", "pb", "photo" })
//	public String photobook() {
//		return "/WEB-INF/views/users/users_photobook.jsp";
//	}
	
	@GetMapping({ "/photobook", "pb", "photo" })
	public String photobook() {
		return "/WEB-INF/views/users/users_photobook.jsp";
	}

	@PostMapping("/create_photobook")
	public String createPhotobook(@RequestParam(value="material",required=true) String material,
            @RequestParam(value="albumSize",required=false) String albumSize,
            @RequestParam(value="color",required=false) String color,
            Model model) {
		System.out.println( material);  // 로그 출력 잘 받아오나 확인하는용
        System.out.println(albumSize);
        System.out.println(color);
	AlbumVo albumVo = userphotobookService.findAlbumIdByOptions(material, albumSize, color);
	model.addAttribute("albumId", albumVo.getAlbumId());
	return "/WEB-INF/views/users/users_create_photobook.jsp";
	}
//	@PostMapping("/photobookorder")
//	public String photobookorder() {
	
//		
//		return
//	}
}
