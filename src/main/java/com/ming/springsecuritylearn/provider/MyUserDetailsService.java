package com.ming.springsecuritylearn.provider;

import com.ming.springsecuritylearn.dao.UserInfoDao;
import com.ming.springsecuritylearn.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.ArrayList;
import java.util.List;

@Component
@Qualifier("myUserDetailService")
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = null;
        User user = null;

        if(username != null){
            userInfo = userInfoDao.findByUsername(username);
        }
        if(userInfo != null){
            List<GrantedAuthority> list = new ArrayList<>();
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_" + userInfo.getRole());
            list.add(grantedAuthority);

            user = new User(userInfo.getUsername(),userInfo.getPassword(),list);
        }
        return user;
    }
}
