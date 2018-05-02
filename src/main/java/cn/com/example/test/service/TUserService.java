package cn.com.example.test.service;

import cn.com.example.test.comments.MD5;
import cn.com.example.test.dao.TUserDao;
import cn.com.example.test.domain.TUser;
import cn.com.example.test.pagehelper.PageBean;
import cn.com.example.test.service.ex.*;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TUserService implements ITUserService {
    @Autowired
    private TUserDao tUserDao;

    @Override
    //注册功能
    public void register(TUser tUser,String upwdconfirm) {
        //判断该用户名是否存在，不存在插入，存在抛异常
        if (tUserDao.selectByUserName(tUser.getUsername()) == null) {
            if (tUser.getPassword().equals(MD5.md5(upwdconfirm,upwdconfirm+1))) {
                tUserDao.insertUser(tUser);
            }else {
                throw new PwdNotMatchException("密码不一致");
            }
        } else {
            throw new ClassNameAlreadyExistException("用户名已经存在");
        }
    }

    @Override
    public boolean checkEmail(String email) {
        return tUserDao.selectByEmail(email)>0;
    }

    @Override
    public boolean checkPhone(String phone) {
        return tUserDao.selectByPhone(phone)>0;
    }

    @Override
    public boolean checkUserName(String username) {
        if(tUserDao.selectByUserName(username)==null){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public TUser login(String username, String password) {
        TUser user=tUserDao.selectByUserName(username);
        if(user==null){
            throw new UserNotFoundException("该用户不存在");
        }else {
            if(user.getPassword().equals(MD5.md5(password,password+1))){
                return user;
            }else {
                throw new PasswordNotMatchException("密码错误");
            }

        }
    }

    @Override
    public void changePassword(Integer id, String oldPwd, String newPwd) {
        TUser user=tUserDao.selectByPrimaryKey(id);
        if (user!=null){
            if (user.getPassword().equals(MD5.md5(oldPwd,oldPwd+1))){
                TUser u=new TUser();
                u.setId(id);
                u.setPassword(MD5.md5(newPwd,newPwd+1));
                tUserDao.updateByPrimaryKeySelective(u);
            }else {
                throw new PasswordNotMatchException("密码错误");
            }
        }
    }

    @Override
    public TUser getUserById(Integer id) {
        return tUserDao.selectById(id);
    }

    @Override
    public void updateUser(Integer id, String username, String email, String phone, Integer gender) {
        TUser user=new TUser();
        TUser u1=tUserDao.selectByUserName(username);
        if(u1==null){
            user.setUsername(username);
        }else {

            TUser u2=tUserDao.selectByPrimaryKey(id);
            if(u2!=null){
                if (u2.getUsername().equals(username)){

                }else {
                    throw new UserNameAlreadyExsitException("用户名已经存在");
                }
            }
        }
        user.setId(id);
        user.setEmail(email);
        user.setPhone(phone);
        user.setGender(gender);
        tUserDao.updateByPrimaryKeySelective(user);
    }

    @Override
    public List<TUser> listUser() {
        PageHelper.startPage(1,6);
        //List<TUser> list=tUserDao.selectAll();
       // int countNums=tUserDao.countUser();
       // PageBean<TUser> pageData=new PageBean<>(currentPage,pageSize,countNums);
        //pageData.setItems(allItems);
        return tUserDao.selectAll();

    }

}