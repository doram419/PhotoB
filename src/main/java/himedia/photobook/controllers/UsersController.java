package himedia.photobook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UsersController {
  @GetMapping("/login")
    public String login() {
    	return "/WEB-INF/views/users/users_login.jsp";
  }
  
	@RequestMapping({"/home", "/index", "", "/"})
	public String home(){
		return "/WEB-INF/views/users/users_index.jsp";
	}
	
	@RequestMapping({"/board"})
	public String board(){
		return "/WEB-INF/views/users/users_board.jsp";
	}
	
	@RequestMapping({"/profile"})
	public String profile(){
		return "/WEB-INF/views/users/users_profile.jsp";
	}
	
	@RequestMapping({"/photobook", "pb", "photo"})
	public String photobook(){
		return "/WEB-INF/views/users/users_photobook.jsp";
	}
	
	@RequestMapping({"/order"})
	public String order(){
		return "/WEB-INF/views/users/users_order.jsp";
	}
}