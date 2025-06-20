package com.chen.algor.ioc;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 容器对象
 * 创建单例bena,但是不超过10个，
 */
public class IOCFactory {

    // 声明存储bean数量
    private final static Integer MAX_CREATE_BEAN_NUM =10;

    // 使用HashMap存储对象,这里需要用下多线程
    private final Map<Class<?>, Object> singleHashMap = new ConcurrentHashMap<>();


    //定义方法
    public   <T> T getBean(Class<T> clazz) {
         // 如果存在那就返回
        if(singleHashMap.containsKey(clazz)){
            return (T)singleHashMap.get(clazz);
        }

        // 判断下数量，
        if (singleHashMap.size() > MAX_CREATE_BEAN_NUM) {
              throw new IllegalArgumentException("bean 超过最大数量"+ MAX_CREATE_BEAN_NUM);
        }

        // 单例创建bean
        try {
            synchronized (clazz) {
                T instance = clazz.getDeclaredConstructor().newInstance();
                singleHashMap.put((Class<?>) clazz,  instance);
                return instance;
            }
        } catch (Exception e) {
            throw new RuntimeException("创建对象失败:" + clazz, e);
        }
    }

    public static void main(String[] args) {
        IOCFactory factory = new IOCFactory();
        Person bean = factory.getBean(Person.class);
        System.out.println(bean);
        Person person = factory.getBean(Person.class);
        System.out.println(person);
    }


}
