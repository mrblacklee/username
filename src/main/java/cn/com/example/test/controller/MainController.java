package cn.com.example.test.controller;

import cn.com.example.test.domain.TUser;
import cn.com.example.test.service.TUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/main")
public class MainController {
    @Autowired
    private TUserService tUserService;
    @RequestMapping("/showIndex.do")
    public String showIndex(HttpServletRequest request,HttpServletResponse response){
        List<TUser> list=tUserService.listUser();
        HttpSession session=request.getSession();
        session.setAttribute("list",list);
        try {
            request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "index";
    }
  /*  @RequestMapping("/showUser.do")
   public String list(HttpServletRequest request,HttpServletResponse response,int currentPage,int pageSize){
        List<TUser> list= tUserService.listUser(currentPage,pageSize);
        HttpSession session=request.getSession();
        session.setAttribute("list",list);
        try {
            request.getRequestDispatcher("/WEB-INF/jsp/listUser.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "listUser";
    }*/
}

