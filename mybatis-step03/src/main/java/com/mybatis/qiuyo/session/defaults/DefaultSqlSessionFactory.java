package com.mybatis.qiuyo.session.defaults;

import com.mybatis.qiuyo.binding.MapperRegistry;
import com.mybatis.qiuyo.session.SqlSession;
import com.mybatis.qiuyo.session.SqlSessionFactory;

/**
 * @Author: qiuyi
 * @Description:
 * @DateTime: 2022/6/17 13:38
 **/
public class DefaultSqlSessionFactory implements SqlSessionFactory {
    private final MapperRegistry mapperRegistry;

    public DefaultSqlSessionFactory(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(mapperRegistry);
    }
}
