package cn.com.example.test.controller;

import cn.com.example.test.comments.MD5;
import cn.com.example.test.domain.ResponseResult;
import cn.com.example.test.domain.TUser;
import cn.com.example.test.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class TUserController extends BaseController{
    @Autowired
    private TUserService tUserService;
    @RequestMapping("/showRegister.do")
    public String showRegister(){
        return "register";
    }

    @RequestMapping("/checkUsername.do")
    @ResponseBody
    public ResponseResult<Void> checkUserName(String username){
        ResponseResult<Void> rr=new ResponseResult<Void>();
        if(tUserService.checkUserName(username)){
            rr.setState(0);
            rr.setMessage("用户名已经存在");
        }else {
            rr.setState(1);
            rr.setMessage("用户名可以使用");
        }
        return rr;
    }
    @RequestMapping("/checkEmail.do")
    @ResponseBody
    public ResponseResult<Void> checkEmail(String email){
        ResponseResult<Void> rr=new ResponseResult<Void>();
        if(tUserService.checkEmail(email)){
            rr.setState(0);
            rr.setMessage("该邮箱已存在");
        }else {
            rr.setState(1);
            rr.setMessage("该邮箱可以使用");
        }
        return rr;
    }
    @RequestMapping("/checkPhone.do")
    @ResponseBody
    public ResponseResult<Void> checkPhone(String phone){
        ResponseResult<Void> rr=new ResponseResult<Void>();
        if(tUserService.checkPhone(phone)){
            rr.setState(0);
            rr.setMessage("该电话已存在");
        }else {
            rr.setState(1);
            rr.setMessage("该电话可以使用");
        }
        return rr;
    }
    @RequestMapping("/register.do")
    @ResponseBody
    public ResponseResult<Void> register(@RequestParam("uname") String username,@RequestParam("upwd") String password,String upwdconfirm,String email,String phone){
        ResponseResult<Void> rr=new ResponseResult<Void>();
        TUser tUser=new TUser();
        tUser.setUsername(username);
        tUser.setPassword(MD5.md5(password,password+1));
        tUser.setEmail(email);
        tUser.setPhone(phone);
        try{
            tUserService.register(tUser,upwdconfirm);
        }catch (Exception e){
            rr.setState(0);
            rr.setMessage(e.getMessage());
        }
        return rr;
    }
    @RequestMapping("/showLogin.do")
    public String showLogin(){
        return "login";
    }
    @RequestMapping("/login.do")
    @ResponseBody
    public ResponseResult<Void> login(String username, String password, HttpSession session){
        ResponseResult<Void> rr=new ResponseResult<Void>();
        try {
            TUser user=tUserService.login(username,password);
            //登录成功，TUser对象存到session中
            session.setAttribute("user",user);
            rr.setState(1);
            rr.setMessage("登录成功");
        }catch (Exception e){
            rr.setState(0);
            rr.setMessage(e.getMessage());
        }
        return rr;
    }
@RequestMapping("/exit.do")
public String exit(HttpSession session){
        session.invalidate();
        return "redirect:../main/showIndex.do";
}
@RequestMapping("/showPersonInfo.do")
public String showPersonInfo(){
    return "personInfo";

}
@RequestMapping("/showPassword.do")
public String showPassword(){
    return "personal_password";
}
@RequestMapping("/password.do")
@ResponseBody
public ResponseResult<Void> password(HttpSession session,String oldPwd,String newPwd){
    ResponseResult<Void> rr=new ResponseResult<Void>();
    try{
        tUserService.changePassword(this.getId(session),oldPwd,newPwd);
        rr.setState(1);
        rr.setMessage("密码修改成功");
    }catch (Exception e){
        rr.setState(0);
        rr.setMessage(e.getMessage());
    }
        return rr;

}
@RequestMapping("/updateUser.do")
@ResponseBody
public ResponseResult<Void> updateUser(HttpSession session,String username,String email,String phone,Integer gender){
    ResponseResult<Void> rr=new ResponseResult<Void>();
    try {
        tUserService.updateUser(this.getId(session),username,email,phone,gender);
        session.setAttribute("user",tUserService.getUserById(this.getId(session)));
        rr.setState(1);
        rr.setMessage("修改成功");
    }catch (Exception e){
        rr.setState(0);
        rr.setMessage(e.getMessage());
    }
    return rr;
}
}
