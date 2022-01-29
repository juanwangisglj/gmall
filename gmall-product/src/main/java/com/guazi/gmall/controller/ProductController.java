package com.guazi.gmall.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author glj
 * @date 2022/1/27 11:38 上午
 */

@RestController
public class ProductController {

    @GetMapping("/test")
    public String testSpringboot(){
        return "hello";
    }
}
