package com.mybatis.qiuyo.session;

/**
 * @Author: qiuyi
 * @Description:
 * @DateTime: 2022/6/16 13:20
 **/
public interface SqlSession {
    /**
     * Retrieve a single row mapped from the statement key
     * 根据指定的SqlID获取一条记录的封装的对象
     *
     * @param statement     sqlID
     * @param <T> the return Object type   封装之后的对象类型
     * @return  Mapped Object 封装之后的对象
     */
    <T> T selectOne(String statement);

    /**
     * Retrieve a single row mapped from the statement key and parameter.
     * 根据指定的SqlID获取一条记录的封装对象，只不过这个方法容许我们可以给sql传递一些参数
     * 一般在实际使用中，这个参数传递的是pojo，或者Map或者ImmutableMap
     *
     * @param statement   Unique identifier matching the statement to use.
     * @param parameter   A parameter object to pass to the statement.
     * @param <T>
     * @return
     */
    <T> T selectOne(String statement, Object parameter);

    /**
     * Retrieves a mapper
     *
     * @param type  Mapper interface class
     * @param <T>  the mapper type
     * @return  a mapper bound to this SqlSession
     */
    <T> T getMapper(Class<T> type);
}
