package com.fc.test;

import com.fc.config.JdbcConfig;
import com.fc.dao.impl.JDBCTemplateDaoImpl;
import com.fc.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class JdbcTemplateTest {
    @Test
    public void testFindCount() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JdbcConfig.class);

        JDBCTemplateDaoImpl templateDao = applicationContext.getBean(JDBCTemplateDaoImpl.class);

        int affectRows = templateDao.findCount();

        System.out.println(affectRows);

    }

    @Test
    public void testFIndById() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JdbcConfig.class);

        JDBCTemplateDaoImpl templateDao = applicationContext.getBean(JDBCTemplateDaoImpl.class);

        User user = templateDao.findById(3);

        System.out.println(user);
    }

    @Test
    public void testFindAll() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JdbcConfig.class);

        JDBCTemplateDaoImpl templateDao = applicationContext.getBean(JDBCTemplateDaoImpl.class);

        List<User> list = templateDao.findAll();

        System.out.println(list);

    }
}
