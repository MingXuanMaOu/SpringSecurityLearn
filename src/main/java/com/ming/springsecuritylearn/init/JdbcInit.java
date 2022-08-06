package com.ming.springsecuritylearn.init;

import com.ming.springsecuritylearn.dao.UserInfoDao;
import com.ming.springsecuritylearn.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

//@Component
public class JdbcInit {

    @Autowired
    private UserInfoDao userInfoDao;

//    @PostConstruct
    public void init(){
        PasswordEncoder encoder = new BCryptPasswordEncoder();

        UserInfo userInfo = new UserInfo();
        userInfo.setPassword(encoder.encode("123"));
        userInfo.setUsername("张三");
        userInfo.setRole("normal");
        userInfoDao.save(userInfo);

        userInfo = new UserInfo();
        userInfo.setUsername("admin");
        userInfo.setPassword(encoder.encode("admin"));
        userInfo.setRole("admin");
        userInfoDao.save(userInfo);

    }
}
