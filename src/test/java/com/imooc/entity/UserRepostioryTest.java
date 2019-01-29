package com.imooc.entity;

import com.imooc.ApplicationTests;
import com.imooc.repository.UserRepostiory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRepostioryTest extends ApplicationTests {
    @Autowired
    private UserRepostiory userRepostiory;

    @Test
    public void testFindOne(){
        User user = userRepostiory.findOne(1L);
        Assert.assertEquals("wali", user.getName());
    }
}
