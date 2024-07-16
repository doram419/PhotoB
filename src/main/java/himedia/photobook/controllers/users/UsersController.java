package himedia.photobook.controllers.users;


import himedia.photobook.repositories.vo.UsersVo;
import himedia.photobook.services.users.UsersService;
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
	private UsersService userService;

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

	@PostMapping("/login") // 로그인 실패 메세지 출력기능 구현 필요!!!
	public String loginAction(@RequestParam(value = "email", required = false, defaultValue = "") String email,

			@RequestParam(value = "password", required = false, defaultValue = "") String password,

			HttpSession session) {
		if (email.length() == 0 || password.length() == 0) {
			return "redirect:/users/home";
		}

		UsersVo authUser = userService.login(email, password);
		
		System.out.println("로그인 안됨1"+authUser);
		if (authUser != null) {

			session.setAttribute("authUser", authUser);

			return "redirect:/users/home";
		} else {
			System.out.println("로그인 안됨2"+authUser);
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

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("authUser");
		session.invalidate();
		
		return "redirect:/";
	}



}
