package com.mybatis.qiuyo.binding;

import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * @Author: qiuyi
 * @Description: 映射器代理工厂
 * @DateTime: 2022/6/14 13:52
 **/
public class MapperProxyFactory<T> {
    private final Class<T> mapperInterface;

    public MapperProxyFactory(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    public T newInstance(Map<String, String> sqlSession) {
        MapperProxy<T> mapperProxy = new MapperProxy<T>(sqlSession, mapperInterface);
        return (T)Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[]{mapperInterface}, mapperProxy);
    }
}
