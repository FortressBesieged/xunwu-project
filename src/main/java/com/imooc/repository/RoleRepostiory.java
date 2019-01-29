package com.imooc.repository;

import com.imooc.entity.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoleRepostiory extends CrudRepository<Role, Long> {
    List<Role> findRolesByUserId(Long userId);
}
