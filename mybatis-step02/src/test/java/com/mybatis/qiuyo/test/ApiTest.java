package com.mybatis.qiuyo.test;

import com.alibaba.fastjson2.JSON;
import com.mybatis.qiuyo.test.dao.IUserDao;
import com.qiuyo.mybatis.binding.MapperProxyFactory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class ApiTest {
   private Logger logger =  LoggerFactory.getLogger(ApiTest.class);

   @Test
   public void test_MapperProxyFactory() {
      MapperProxyFactory<IUserDao> factory = new MapperProxyFactory<>(IUserDao.class);

      Map<String, String> sqlSession = new HashMap<>();
      sqlSession.put("com.qiuyo.mybatis.test.dao.IUserDao.com.qiuyo.mybatis.test.dao.IUserDao", "模拟执行mapper.xml中的sql语句，操作：查询用户的名称");

      IUserDao userDao = factory.newInstance(sqlSession);

      String result = userDao.queryUserName("1");
      logger.info("测试结果: {}", JSON.toJSONString(result));
   }

   @Test
   public void test_proxy_class() {
      IUserDao userDao =(IUserDao) Proxy.newProxyInstance(
              Thread.currentThread().getContextClassLoader(),
              new Class[]{IUserDao.class},
              (((proxy, method, args) -> "你被代理了！"))
      );

      String result = userDao.queryUserName("1");
      logger.info("测试结果: {}", JSON.toJSONString(result));

   }

}
