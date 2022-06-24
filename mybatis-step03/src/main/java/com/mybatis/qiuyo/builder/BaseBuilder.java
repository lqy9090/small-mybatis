package com.mybatis.qiuyo.builder;


import com.mybatis.qiuyo.session.Configuration;

/**
 * @Author: qiuyi
 * @Description:
 * @DateTime: 2022/6/21 13:42
 **/
public class BaseBuilder {
    protected Configuration configuration;

    public BaseBuilder(Configuration configuration) {
        this.configuration = configuration;
    }

    public Configuration getConfiguration() {
        return configuration;
    }
}
