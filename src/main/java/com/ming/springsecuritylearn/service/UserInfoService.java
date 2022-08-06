package com.ming.springsecuritylearn.service;

import com.ming.springsecuritylearn.entity.UserInfo;

public interface UserInfoService {
    UserInfo findByUsername(String username);
}
