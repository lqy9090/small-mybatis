package com.qiuyo.mybatis.binding;

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

    public T newInstance() {
        return null;
    }
}
