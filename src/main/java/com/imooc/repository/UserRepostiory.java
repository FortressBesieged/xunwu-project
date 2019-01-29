package com.imooc.repository;

import com.imooc.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepostiory extends CrudRepository<User, Long> {

    User findByName(String userName);
}
