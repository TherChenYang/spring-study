package com.yang.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * 和Jdbc操作相关的配置类
 * @author: CY.Ma
 * @date: 2023/6/25 22:29
 * @Description:
 * @doc:
 */
public class JdbcConfig {
    /**
     * 创建JdbcTemplate对象，并且存入IOC容器
     * @return
     */
    @Bean("jdbcTemplate")
    public JdbcTemplate createJdbcTemplate(@Autowired DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    /**
     * 创建数据源，并存入IOC容器
     * @return
     */
    @Bean
    public DataSource dataSource() {
        // 1. 创建spring内置数据源对象
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        // 2. 给数据源提供必要的参数
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/spring_ioc");
        dataSource.setUsername("root");
        dataSource.setPassword("password");
        return dataSource;
    }
}
