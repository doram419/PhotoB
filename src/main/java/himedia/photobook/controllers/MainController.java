package himedia.photobook.controllers;

import org.apache.ibatis.reflection.SystemMetaObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @RequestMapping({"/"})
    public String welcome() { System.out.println("ㅎㅇ");
        return "/WEB-INF/views/users/users_index.jsp";
       
    }
}
