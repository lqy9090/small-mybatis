package com.mybatis.qiuyo.test.dao;

public interface IUserDao {
    String queryUserName(String uId);

    Integer queryUserAge(String uId);
}
