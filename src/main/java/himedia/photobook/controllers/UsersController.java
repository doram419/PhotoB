package himedia.photobook.controllers;


import himedia.photobook.repositories.vo.UsersVo;

import himedia.photobook.services.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class UsersController {
	@Autowired
	private UserService userService;

	@GetMapping("/login")
	public String login() {

		return "/WEB-INF/views/users/users_login.jsp";
	}

	@RequestMapping({ "/home", "/index", "", "/" })
	public String home() {
		return "/WEB-INF/views/users/users_index.jsp";
	}

	@RequestMapping({ "/profile" })
	public String profile() {
		return "/WEB-INF/views/users/users_profile.jsp";
	}

	@RequestMapping({ "/photobook", "pb", "photo" })
	public String photobook() {
		return "/WEB-INF/views/users/users_photobook.jsp";
	}
	
	@PostMapping("/create_photobook")
	public String create_photobook() {
	    return "/WEB-INF/views/users/users_create_photobook.jsp";
	}
	@RequestMapping({ "/order" })
	public String order() {
		return "/WEB-INF/views/users/users_order.jsp";
	}

	@PostMapping("/login")
	public ModelAndView loginProcess(String email, String password, HttpSession session) {
		UsersVo user = userService.login(email, password);
		if (user != null) {
			session.setAttribute("user", user);
			return new ModelAndView("redirect:/");
		} else {
			ModelAndView mv = new ModelAndView("/WEB-INF/views/users/users_login.jsp");
			mv.addObject("error", "다시.");
			return mv;
		}
	}

	@GetMapping("/register")
	public String register() {
		return "/WEB-INF/views/users/users_register.jsp";
	}

	@PostMapping("/register")
	public ModelAndView registerProcess(UsersVo user) {
		boolean isRegistered = userService.register(user);
//		if (isRegistered) {
//			return new ModelAndView("redirect:/users/login");
//		} else {
			ModelAndView mv = new ModelAndView("/WEB-INF/views/users/users_register.jsp");
			mv.addObject("error", "다시.");
			return mv;
//		}
		
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
