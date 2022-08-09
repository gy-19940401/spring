package com.mashibing.learnTest;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @Description: 修改默认循环依赖设置
 * @author: GanYang
 * @Date: 2022/3/16 22:00
 */
public class MyClassPathXmlApplicationContext extends ClassPathXmlApplicationContext {

    @Override
    protected void customizeBeanFactory(DefaultListableBeanFactory beanFactory) {
        setAllowCircularReferences(true);
        setAllowCircularReferences(false);
        super.customizeBeanFactory(beanFactory);
    }
}
