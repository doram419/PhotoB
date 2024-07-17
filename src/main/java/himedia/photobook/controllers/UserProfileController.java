package himedia.photobook.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import himedia.photobook.repositories.vo.UsersVo;
import himedia.photobook.services.UserProfileService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/users/profile")
public class UserProfileController {
	@Autowired
	private UserProfileService userprofileService;

	@PostMapping("/update")
	public String updateProfile(UsersVo updatedUser, HttpSession session) {
		// 세션에서 현재 사용자 정보 가져오기
		
		UsersVo currentUser = (UsersVo) session.getAttribute("authUser");
System.out.println("currentusr:"+currentUser);
		if (currentUser != null) {
			// 업데이트된 필드만 currentUser에 적용
				
			//if (updatedUser.getUserName() != null) {
				currentUser.setUserName(updatedUser.getUserName());
			//}
			//if (updatedUser.getPassword() != null) {
				currentUser.setPassword(updatedUser.getPassword());
			//}
			//if (updatedUser.getPhoneNumber() != null) {
				currentUser.setPhoneNumber(updatedUser.getPhoneNumber());
			//}
			//if (updatedUser.getAddress() != null) {
				currentUser.setAddress(updatedUser.getAddress());
			//}

			boolean isUpdated = userprofileService.updateProfile(currentUser);
			if (isUpdated) {
				session.setAttribute("authUser", currentUser);
				return "redirect:/users/profile";
			} else {
				System.out.println("else:"+currentUser);
				return "redirect:/users/profile?error=1";
			}
		} else {
			// 세션에 사용자 정보가 없는 경우 처리
			System.out.println("else:"+currentUser);
			return "redirect:/users/login";
		}
	}
}
