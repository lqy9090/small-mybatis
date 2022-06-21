package com.mybatis.qiuyo.session;

import com.mybatis.qiuyo.binding.MapperRegistry;

/**
 * @Author: qiuyi
 * @Description:
 * @DateTime: 2022/6/21 13:46
 **/
public class Configuration {
    protected MapperRegistry mapperRegistry = new MapperRegistry(this);

    public <T> void addMapper(Class<T> type) {
        mapperRegistry.addMapper(type);
    }
}
