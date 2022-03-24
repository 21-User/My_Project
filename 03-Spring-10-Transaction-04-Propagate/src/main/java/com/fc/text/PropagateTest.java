package com.fc.text;

import com.fc.config.TxConfig;
import com.fc.service.AccountService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PropagateTest {
    @Test
    public void test() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TxConfig.class);

        AccountService service = applicationContext.getBean(AccountService.class);

        service.addAccount("哈哈哈哈","地球");
    }
}
