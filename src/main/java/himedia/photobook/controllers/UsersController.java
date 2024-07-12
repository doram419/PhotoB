package himedia.photobook.controllers;

import himedia.photobook.repositories.vo.UsersVo;
import himedia.photobook.services.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	@RequestMapping({ "/board" })
	public String board() {
		return "/WEB-INF/views/users/users_board.jsp";
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

	@PostMapping("/login") // 로그인 실패 메세지 출력기능 구현 필요!!! (회원가입 실패 메세지 출력 참고 users_register.jsp)
	public String loginAction(@RequestParam(value = "email", required = false, defaultValue = "") String email,

			@RequestParam(value = "password", required = false, defaultValue = "") String password,

			HttpSession session) {
		System.out.println("email:" + email);
		System.out.println("password:" + password); //확인용
		if (email.length() == 0 || password.length() == 0) {
			return "redirect:/users/home";
		}

		UsersVo authUser = userService.login(email, password);

		if (authUser != null) {

			session.setAttribute("authUser", authUser);

			return "redirect:/users/home";
		} else {
			return "redirect:/users/login";
		}
	}

	@GetMapping("/register")
	public String register() {
		return "/WEB-INF/views/users/users_register.jsp";
	}

	@PostMapping("/register")
	public ModelAndView registerProcess(UsersVo user) {
		boolean isRegistered = userService.register(user);
		if (isRegistered) {
			return new ModelAndView("redirect:/users/login");
		} else {
			ModelAndView mv = new ModelAndView("/WEB-INF/views/users/users_register.jsp");
			mv.addObject("error", "이메일중복.다시.");
			return mv;
		}
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
