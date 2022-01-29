package com.guazi.gmall.controller;

import com.guazi.common.utils.R;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author glj
 * @date 2022/1/28 4:56 下午
 */
@RestController
@RefreshScope
public class GatewayController {

    @Value("${name}")
    private String username;
    @Value("${age}")
    private Integer age;

    @GetMapping("/test")
    public R test(){
        System.out.println("kkk");
        return R.ok().put("username",username).put("age",age);
    }
}
