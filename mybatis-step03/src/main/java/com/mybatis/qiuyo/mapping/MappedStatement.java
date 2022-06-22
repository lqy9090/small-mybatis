package com.mybatis.qiuyo.mapping;

import com.mybatis.qiuyo.session.Configuration;

/**
 * @Author: qiuyi
 * @Description:
 * @DateTime: 2022/6/22 13:27
 **/
public class MappedStatement {
    private Configuration configuration;
    private String id;
    private String sqlCommandType;
    private String sql;
    private String bondSql;


    public MappedStatement() {
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public String getId() {
        return id;
    }

    public String getSqlCommandType() {
        return sqlCommandType;
    }

    public String getSql() {
        return sql;
    }

    public String getBondSql() {
        return bondSql;
    }
}
