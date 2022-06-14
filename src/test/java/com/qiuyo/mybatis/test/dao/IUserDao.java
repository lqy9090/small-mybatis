package com.qiuyo.mybatis.test.dao;

public interface IUserDao {
    String queryUserName(String uId);

    Integer queryUserAge(String uId);
}
