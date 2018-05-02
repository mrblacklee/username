package cn.com.example.test.service;

import cn.com.example.test.domain.TUser;

import java.util.List;

public interface ITUserService {
    /**
     *
     * @param tUser 封装页面的数据
     */
    void register(TUser tUser,String upwdconfirm);
    boolean checkEmail(String email);
    boolean checkPhone(String phone);
    boolean checkUserName(String username);
    TUser login(String username,String password);
    void changePassword(Integer id,String oldPwd,String newPwd);
    TUser getUserById(Integer id);
    void updateUser(Integer id,String username,String email,String phone,Integer gender);
    List<TUser> listUser();
}
