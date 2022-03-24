package com.fc.test;

import com.fc.config.TxConfig;
import com.fc.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccountTest {
    @Test
    public void AnnotationTest() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(TxConfig.class);

        AccountService accountService = applicationContext.getBean(AccountService.class);

        accountService.transfer(1,2,200L);
    }

    @Test
    public void transactionTest() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        AccountService programmingService = applicationContext.getBean("annotationService",AccountService.class);

        programmingService.transfer(1,2,100L);
    }

    @Test
    public void test() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        AccountService accountService = applicationContext.getBean("accountService",AccountService.class);

        accountService.transfer(1,2,100L);
    }
}
