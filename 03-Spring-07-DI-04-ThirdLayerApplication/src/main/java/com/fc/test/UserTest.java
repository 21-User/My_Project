package com.fc.test;

import com.fc.controller.UserController;
import com.fc.dao.UserDao;
import com.fc.entity.User;
import com.fc.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class UserTest {
    @Test
    public void testContext() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        User user = applicationContext.getBean(User.class);

        UserController controller = applicationContext.getBean(UserController.class);

        System.out.println(user);
        System.out.println(controller);

        List<User> list = controller.findAll();
        System.out.println(list);

    }

    @Test
    public void test() {
        UserController userController = new UserController();

        List<User> list = userController.findAll();

        System.out.println(list );
    }
}
