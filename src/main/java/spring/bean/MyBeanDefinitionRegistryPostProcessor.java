package spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;

/**
 * Created by shiqining on 11/18/16.
 */
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        int count = registry.getBeanDefinitionCount();
        String[] names = registry.getBeanDefinitionNames();
//        registry.removeBeanDefinition("ddd");
        System.out.println("count = " + count);
        System.out.println("beanDefinitionNames = " + names);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("postProcessBeanFactory");
        ClassLoader beanClassLoader =  beanFactory.getBeanClassLoader();
        System.out.println("beanClassLoader = " + beanClassLoader);
    }
}
