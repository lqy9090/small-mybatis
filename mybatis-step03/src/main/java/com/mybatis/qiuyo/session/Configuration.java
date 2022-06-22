package com.mybatis.qiuyo.session;

import com.mybatis.qiuyo.binding.MapperRegistry;
import com.mybatis.qiuyo.mapping.MappedStatement;

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

    public void addMappedStatement(MappedStatement ms){

    }

}
