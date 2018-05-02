package cn.com.example.test.comments;

import org.apache.shiro.crypto.hash.Md5Hash;

public class MD5 {
    public static String TOKEN_FOR_MODIFYPASSWORD = "ce6760509794de149c3fc8fa65a881a7";

    public static String md5(String str, String salt) {
        // Md5Hash是Shiro中的一个方法
        return new Md5Hash(str,salt).toString();
    }




}
