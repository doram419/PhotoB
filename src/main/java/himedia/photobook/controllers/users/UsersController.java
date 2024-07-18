package himedia.photobook.controllers.users;


import himedia.photobook.repositories.vo.UsersVo;


import himedia.photobook.services.UsersService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import himedia.photobook.repositories.vo.UsersVo;
import himedia.photobook.services.UsersService;
import jakarta.servlet.http.HttpSession;

// 로그인, 회원가입, 로그아웃, 프로필업데이트기능 여기에 다 넣었습니다.

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


	@PostMapping("/login") // 로그인 실패 메세지 출력기능 구현 필요!!!
	public String loginAction(@RequestParam(value = "email", required = false, defaultValue = "") String email,

			@RequestParam(value = "password", required = false, defaultValue = "") String password,

			HttpSession session) {
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

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("authUser");
		session.invalidate();
		
		return "redirect:/";
	}

	@RequestMapping({ "/profile" })
	public String profile() {
		return "/WEB-INF/views/users/users_profile.jsp";
	}
	@PostMapping("/profile/update")
	public String updateUser(UsersVo updatedUser, HttpSession session) {

		UsersVo currentUser = (UsersVo) session.getAttribute("authUser");
		System.out.println("currentusr:" + currentUser);
		if (currentUser != null) {
			currentUser.setUserName(updatedUser.getUserName());
			currentUser.setPassword(updatedUser.getPassword());
			currentUser.setPhoneNumber(updatedUser.getPhoneNumber());
			currentUser.setAddress(updatedUser.getAddress());

			boolean isUpdated = userService.updateUser(currentUser);
			if (isUpdated) {
				session.setAttribute("authUser", currentUser);
				return "redirect:/users/profile";
			} else {
				System.out.println("else:" + currentUser);
				return "redirect:/users/profile?error=1";
			}
		} else {
			System.out.println("else:" + currentUser);
			return "redirect:/users/login";
		}
	}

}
