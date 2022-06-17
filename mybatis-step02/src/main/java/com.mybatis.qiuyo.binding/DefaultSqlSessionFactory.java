package com.mybatis.qiuyo.binding;

/**
 * @Author: qiuyi
 * @Description:
 * @DateTime: 2022/6/17 13:38
 **/
public class DefaultSqlSessionFactory implements SqlSessionFactory{
    private final MapperRegistry mapperRegistry;

    public DefaultSqlSessionFactory(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(mapperRegistry);
    }
}
