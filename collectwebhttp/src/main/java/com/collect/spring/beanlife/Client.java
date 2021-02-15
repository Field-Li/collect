package com.collect.spring.beanlife;

import com.mysql.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    @Autowired
    private ProductMapper productMapper;

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
        System.out.println("applicationContext 启动成功");
// 从 context 中取出我们的 Bean，而不是用 new MessageServiceImpl() 这种方式
        ProductMapper productMapper = applicationContext.getBean(ProductMapper.class);
// 这句将输出: hello world
        productMapper.selectOwnerProductList("234");
    }
}
