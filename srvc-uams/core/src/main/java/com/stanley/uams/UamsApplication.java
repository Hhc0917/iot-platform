package com.stanley.uams;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * 权限管理服务
 * 包括用户、机构、角色、权限、菜单、公共接口配置等基础架构功能
 * @author 13346450@qq.com 童晟
 * @version 1.0
 * @create 2017/8/4
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrix
@ServletComponentScan
public class UamsApplication {

    public static void main(String[] args) {
        SpringApplication.run(UamsApplication.class, args);
    }
}
