package com.ming.springsecuritylearn.service.impl;

import com.ming.springsecuritylearn.dao.UserInfoDao;
import com.ming.springsecuritylearn.entity.UserInfo;
import com.ming.springsecuritylearn.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public UserInfo findByUsername(String username) {
        return userInfoDao.findByUsername(username);
    }
}
