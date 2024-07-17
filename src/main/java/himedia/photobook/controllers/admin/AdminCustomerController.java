package himedia.photobook.controllers.admin;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import himedia.photobook.repositories.vo.UsersVo;
import himedia.photobook.services.admin.AdminCustomerService;

@Controller
@RequestMapping({"/admin"})
public class AdminCustomerController {
	@Autowired
	private AdminCustomerService adminCustomerService;
	
	@GetMapping({"/customerManagement", "/customerManage", "/cm"})
	public String customerManagement() {
		return "/WEB-INF/views/admin/admin_customer_management.jsp";
	}
	
	@GetMapping("/search")
	public String searchUSers(@RequestParam Map<String, String> params, Model model) {
		String searchCategory = params.getOrDefault("search-category", null);
		String keyword = params.getOrDefault("keyword", null);
		List<UsersVo> userList = adminCustomerService.searchUsers(searchCategory, keyword);
		model.addAttribute("userList", userList);
		return "/WEB-INF/views/admin/admin_customer_management.jsp";
	}
	
	@GetMapping("/update")
	public String customerUpdate() {
		return "/WEB-INF/views/admin/admin_customer_update.jsp";
	}
	
//	관리자 고객관리 고객목록 삭제확인페이지(구현X)	
//	@GetMapping("/customerDelete")
//	public String customerDelete(@RequestParam ("userId") String userId, Model model) {
//		UsersVo users = adminCustomerService.getUserById(userId);
//		model.addAttribute("users", users);
//		return "/WEB-INF/views/admin/admin_customer_delete.jsp";
//	}
	
	@GetMapping("/delete")
	public String deleteUser(@RequestParam("userId")String userId) {
		System.out.println("deleteUser userId: " + userId);
		adminCustomerService.deleteUser(userId);
		return "redirect:/admin/cm";
	}

}
