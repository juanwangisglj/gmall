package com.guazi.gmall.config;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author glj
 * @date 2022/1/27 2:21 下午
 * 自定义配置类
 */
@Configuration
@MapperScan("com.guazi.gmall.mapper")
public class CustomerConfig {

}
