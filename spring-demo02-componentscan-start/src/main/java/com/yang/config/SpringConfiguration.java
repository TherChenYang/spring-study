package com.yang.config;

import com.yang.generator.CustomBeanNameGenerator;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

/**
 * 自定义spring注解配置
 * @author: CY.Ma
 * @date: 2023/6/26 16:43
 * @description:
 *  如果componentScan中没有指定basePackage
 *  默认扫描被@ComponentScan注解的类的包以及子包
 */
@Configuration
@ComponentScan(basePackages = {"com.yang"},
        nameGenerator = CustomBeanNameGenerator.class, resourcePattern = "**/*.class",
        excludeFilters = @ComponentScan.Filter(classes = {Controller.class}))
public class SpringConfiguration {
}
