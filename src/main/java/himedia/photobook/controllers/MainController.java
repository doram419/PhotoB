package himedia.photobook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/home"})
public class MainController {
	//
	@RequestMapping({"/"})
	public String welcome() {
		return "/WEB-INF/views/index/index.jsp";
	}
	
	@RequestMapping({"/board", "/bd", "/"})
	public String board() {
		return "/WEB-INF/views/home/board.html";
	}
	
	@RequestMapping({"/home_index", "/home", "/hi"})
	public String homeIndex() {
		return "/WEB-INF/views/home/home_index.html";
	}
	
	@RequestMapping({"/login", "/lg"})
	public String login() {
		return "/WEB-INF/views/home/login.html";
	}
	
	
	@RequestMapping({"/order", "/od"})
	public String order() {
		return "/WEB-INF/views/home/order.html";
	}
	@RequestMapping({"/photobook", "/pb"})
	public String photobook() {
		return "/WEB-INF/views/home/photobook.html";
	}
	@RequestMapping({"/profile", "/pf"})
	public String profile() {
		return "/WEB-INF/views/home/profile.html";
	}
	@RequestMapping({"/register", "/reg"})
	public String register() {
		return "/WEB-INF/views/home/register.html";
	}
}
