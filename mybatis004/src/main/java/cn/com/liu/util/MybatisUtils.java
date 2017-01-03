package cn.com.liu.util;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.com.liu.test1.Test;

public class MybatisUtils {

	public static SqlSessionFactory getFactory() {
		String resource = "src/test/conf.xml";
		InputStream is = Test.class.getClassLoader().getResourceAsStream(
				resource);

		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

		return factory;
	}
}
