package com.mybatis.qiuyo.session.defaults;

import com.mybatis.qiuyo.binding.MapperRegistry;
import com.mybatis.qiuyo.session.SqlSession;

/**
 * @Author: qiuyi
 * @Description:
 * @DateTime: 2022/6/17 13:30
 **/
public class DefaultSqlSession implements SqlSession {
    private MapperRegistry mapperRegistry;

    public DefaultSqlSession(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }


    @Override
    public <T> T selectOne(String statement) {
        return null;
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        return (T) ("你被代理了！" + "方法：" + statement + " 入参：" + parameter);
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return mapperRegistry.getMapper(type,this);
    }
}
