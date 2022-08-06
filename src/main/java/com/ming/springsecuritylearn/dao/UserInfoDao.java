package com.ming.springsecuritylearn.dao;

import com.ming.springsecuritylearn.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoDao extends JpaRepository<UserInfo,Long> {

    UserInfo findByUsername(String username);
}
