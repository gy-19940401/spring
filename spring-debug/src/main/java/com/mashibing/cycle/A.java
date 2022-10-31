package com.mashibing.cycle;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.ListableBeanFactory;


public class A implements FactoryBean<A> {

    private String name;
    private B b;

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "A{" +
                "b=" + b +
                '}';
    }

    /**
     * 返回 一个 由 factory 管理的对象实列 （shared or independent）
     * 和 {@link BeanFactory} 一样, 同时支持 单列 和 多列 模式
     *
     * <p>在 调用的 时候 还没有被出初始化 就会报异常 (例如，涉及到循环引用),
     * throw a corresponding {@link }.
     * 从 Spring 2.0 开始，FactoryBeans 可以返回 {@code null} 对象。工厂将此视为正常值使用；
     * 在这种情况下，它不会再抛出 FactoryBeanNotInitializedException 了。
     * 鼓励 FactoryBean 实现现在酌情自行抛出 FactoryBeanNotInitializedException。
     *
     * @return an instance of the bean (can be {@code null})
     * @throws Exception in case of creation errors
     */
    @Override
    public A getObject() throws Exception {
        return new A();
    }

    /**
     * Return the type of object that this FactoryBean creates,
     * or {@code null} if not known in advance.
     * <p>This allows one to check for specific types of beans without
     * instantiating objects, for example on autowiring.
     * <p>In the case of implementations that are creating a singleton object,
     * this method should try to avoid singleton creation as far as possible;
     * it should rather estimate the type in advance.
     * For prototypes, returning a meaningful type here is advisable too.
     * <p>This method can be called <i>before</i> this FactoryBean has
     * been fully initialized. It must not rely on state created during
     * initialization; of course, it can still use such state if available.
     * <p><b>NOTE:</b> Autowiring will simply ignore FactoryBeans that return
     * {@code null} here. Therefore it is highly recommended to implement
     * this method properly, using the current state of the FactoryBean.
     *
     * @return the type of object that this FactoryBean creates,
     * or {@code null} if not known at the time of the call
     * @see ListableBeanFactory#getBeansOfType
     */
    @Override
    public Class<?> getObjectType() {
        return A.class;
    }
}
