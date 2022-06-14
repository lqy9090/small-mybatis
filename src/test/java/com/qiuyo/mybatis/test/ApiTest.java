package com.qiuyo.mybatis.test;

import com.alibaba.fastjson2.JSON;
import com.qiuyo.mybatis.test.dao.IUserDao;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Proxy;

public class ApiTest {
   private Logger logger =  LoggerFactory.getLogger(ApiTest.class);

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
