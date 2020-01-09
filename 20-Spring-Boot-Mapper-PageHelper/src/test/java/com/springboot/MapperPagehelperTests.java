package com.springboot;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.bean.User;
import com.springboot.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MapperPagehelperApplication.class)
public class MapperPagehelperTests {

    @Autowired
    private UserService userService;

    @Test
    public void testSave() throws Exception {
        User user = new User();
        user.setUsername("scott");
        user.setPasswd("ac089b11709f9b9e9980e7c497268dfa");
        user.setCreateTime(new Date());
        user.setStatus("0");
        this.userService.save(user);
    }
    @Test
    public void testQuery() throws Exception {
        Example example = new Example(User.class);
        example.createCriteria().andCondition("username like '%i%'");
        example.setOrderByClause("id desc");
        List<User> userList = this.userService.selectByExample(example);
        for (User u : userList) {
            System.out.println(u.getUsername());
        }

        List<User> all = this.userService.selectAll();
        for (User u : all) {
            System.out.println(u.getUsername());
        }

        User user = new User();
        user.setId(001);
        user = this.userService.selectByKey(user);
        System.out.println(user.getUsername());
    }
    @Test
    public void testDelete() throws Exception {
        User user = new User();
        user.setId(004);
        this.userService.delete(user);
    }

    @Test
    public void testPageQuery() throws Exception {
        PageHelper.startPage(2, 2);
        List<User> list = userService.selectAll();
        PageInfo<User> pageInfo = new PageInfo<User>(list);
        List<User> result = pageInfo.getList();
        for (User u : result) {
            System.out.println(u.getUsername());
        }
    }

}
