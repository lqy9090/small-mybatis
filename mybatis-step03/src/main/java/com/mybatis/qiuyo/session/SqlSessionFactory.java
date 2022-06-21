package com.mybatis.qiuyo.session;

/**
 * @Author: qiuyi
 * @Description:
 * @DateTime: 2022/6/17 13:37
 **/
public interface SqlSessionFactory {
    /**
     * 打开一个 session
     * @return
     */
    SqlSession openSession();
}
