package com.guazi.gmall;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author glj
 * @date 2022/1/28 4:59 下午
 */
@SpringBootTest
public class GatewayTest {

    @Value("${user.name}")
    private String userName;
    @Value("${user.password}")
    private String password;


    @Test
    public void testGateway(){
//        log.info("username is {},password is {}",userName,password);
        System.out.println(userName+password);
    }
}
