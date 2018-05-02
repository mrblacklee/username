package cn.com.example.test.controller;

import cn.com.example.test.domain.TUser;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;

@Controller
public class BaseController {
    public Integer getId(HttpSession session){
        TUser tUser=(TUser) session.getAttribute("user");
        if (tUser==null){
            return null;
        }else {
            return tUser.getId();
        }
    }
}
