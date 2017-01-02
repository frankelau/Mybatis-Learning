package cn.com.liu.mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class BaseUpdateMapper {
    protected static SqlSessionFactory ssf;


    protected static Reader reader;

    static {
        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
            ssf = new SqlSessionFactoryBuilder().build(reader,"mysql");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}