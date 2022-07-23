package com.jwjwu.common.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * Spring Context 工具类
 *
 * @author Scott
 */
@Component
public class SpringContextUtils implements ApplicationContextAware {

    public static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        SpringContextUtils.applicationContext = applicationContext;
    }

    public static Object getBean(String name) {
        return applicationContext.getBean(name);
    }

    public static <T> T getBean(Class<T> requiredType) {
        return applicationContext.getBean(requiredType);
    }

    public static <T> T getBean(String name, Class<T> requiredType) {
        try {
			return applicationContext.getBean(name, requiredType);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }

    public static boolean containsBean(String name) {
        return applicationContext.containsBean(name);
    }

    public static boolean isSingleton(String name) {
        return applicationContext.isSingleton(name);
    }

    public static Class<? extends Object> getType(String name) {
        return applicationContext.getType(name);
    }
    
    public static String getProperty(String key) {
    	return applicationContext.getEnvironment().getProperty(key);
    }

    /// 获取当前环境
    public static String getActiveProfile() {
        try {
            return applicationContext.getEnvironment().getActiveProfiles()[0];
        }catch (Exception e){
            return null;
        }
    }

    // 国际化使用
    public static String getMessage(String key) {
        return applicationContext.getMessage(key, null, Locale.getDefault());
    }

}