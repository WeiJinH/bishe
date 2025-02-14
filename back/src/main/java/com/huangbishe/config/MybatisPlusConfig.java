
package com.huangbishe.config;


import com.baomidou.mybatisplus.plugins.OptimisticLockerInterceptor;
import org.mybatis.spring.annotation.MapperScan;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;



/**
 * mybatis-plus配置
 */
@Configuration

public class MybatisPlusConfig {


    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }


}
