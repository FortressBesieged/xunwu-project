package com.imooc.service.user;

import com.imooc.entity.Role;
import com.imooc.entity.User;
import com.imooc.repository.RoleRepostiory;
import com.imooc.repository.UserRepostiory;
import com.imooc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepostiory userRepostiory;

    @Autowired
    private RoleRepostiory roleRepostiory;

    @Override
    public User findUserByName(String userName) {
        User user = userRepostiory.findByName(userName);
        if(user == null){
            return null;
        }

        List<Role> roles = roleRepostiory.findRolesByUserId(user.getId());
        if(roles == null || roles.isEmpty()){
            throw new DisabledException("权限非法");
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        roles.forEach(role -> authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName())));
        user.setAuthorityList(authorities);
        return user;
    }
}
