package com.mybatis.qiuyo.builder.xml;

import com.mybatis.qiuyo.builder.BaseBuilder;
import com.mybatis.qiuyo.io.Resources;
import com.mybatis.qiuyo.mapping.MappedStatement;
import com.mybatis.qiuyo.mapping.SqlCommandType;
import com.mybatis.qiuyo.session.Configuration;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xml.sax.InputSource;


import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: qiuyi
 * @Description:
 * @DateTime: 2022/6/21 13:39
 **/
public class XMLConfigBuilder extends BaseBuilder {
    private Element root;

    public XMLConfigBuilder(Reader reader) {
        super(new Configuration());

        SAXReader saxReader = new SAXReader();
        try {
            Document document = saxReader.read(new InputSource(reader));
            root = document.getRootElement();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public Configuration parse() {
        try {
            mapperElement(root.element("mappers"));
        } catch (Exception e) {
            throw new RuntimeException("Error parsing SQL Mapper Configuration. Cause: " + e, e);
        }
        return configuration;
    }

    private void mapperElement(Element mappers) throws IOException, DocumentException, ClassNotFoundException {
        List<Element> mapperList = mappers.elements("mapper");
        for (Element e : mapperList) {
            String resource = e.attributeValue("resource");
            Reader reader = Resources.geResourceAsReader(resource);
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(new InputSource(reader));
            Element root = document.getRootElement();
            //命名空间
            String namespace = root.attributeValue("namespace");

            //SELECT
            List<Element> selectNodes = root.elements("select");
            for (Element node : selectNodes) {
                String id = node.attributeValue("id");
                String paramType = node.attributeValue("paramType");
                String resultType = node.attributeValue("resultType");
                String sql = node.getText();

                //占位符 ? 匹配
                HashMap<Integer, String> parameter = new HashMap<>();
                Pattern pattern = Pattern.compile("(#\\{(.*?)})");
                Matcher matcher = pattern.matcher(sql);
                for (int i = 1; matcher.find(); i++) {
                    String g1 = matcher.group(1);
                    String g2 = matcher.group(2);
                    parameter.put(i, g2);
                    sql = sql.replace(g1, "?");
                }

                String msId = namespace + "." + id;
                String nodeName = node.getName();
                SqlCommandType.valueOf(nodeName.toUpperCase(Locale.ENGLISH));

                MappedStatement mappedStatement = new MappedStatement();
                //添加解析sql
                configuration.addMappedStatement(mappedStatement);
            }

            //注册mapper映射器
            //这里解析完，调用configuration去注册mapper
            configuration.addMapper(Resources.classForName(namespace));

        }
    }
}
