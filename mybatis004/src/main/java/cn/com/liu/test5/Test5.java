package cn.com.liu.test5;

import cn.com.liu.bean.Classes;
import cn.com.liu.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/*
 * 测试: 一对一关联表查询
 */
public class Test5 {

	public static void main(String[] args) {
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();
		
		String statement = "com.atguigu.day03_mybaits.test5.ClassMapper.getClass";
		
		statement = "com.atguigu.day03_mybaits.test5.ClassMapper.getClass2";
	
		
		Classes c = session.selectOne(statement , 2);
		System.out.println(c);
		
		session.close();
	}
}
