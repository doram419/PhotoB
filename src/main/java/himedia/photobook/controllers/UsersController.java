package himedia.photobook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/users")
public class UsersController {

    @GetMapping("/login")
    public String login() {
    	System.out.println("로그인 떳씁니다");
    	return "/WEB-INF/views/users/login.jsp";
    }
    
}