package com.mybatis.qiuyo.test;



import com.mybatis.qiuyo.binding.DefaultSqlSessionFactory;
import com.mybatis.qiuyo.binding.MapperRegistry;
import com.mybatis.qiuyo.binding.SqlSession;
import com.mybatis.qiuyo.binding.SqlSessionFactory;
import com.mybatis.qiuyo.test.dao.IUserDao;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ApiTest {
   private Logger logger =  LoggerFactory.getLogger(ApiTest.class);


   @Test
   public void test_MapperProxyFactory() {
      //1.注册 Mapper
      MapperRegistry mapperRegistry = new MapperRegistry();
      mapperRegistry.addMappers("com.mybatis.qiuyo.test.dao");

      //2. 从SqlSession工厂获取session
      SqlSessionFactory sqlSessionFactory = new DefaultSqlSessionFactory(mapperRegistry);
      SqlSession sqlSession = sqlSessionFactory.openSession();

      //3. 获取映射器对象
      IUserDao userDao = sqlSession.getMapper(IUserDao.class);


      String res = userDao.queryUserName("1001");
      logger.info(res);

   }
}
