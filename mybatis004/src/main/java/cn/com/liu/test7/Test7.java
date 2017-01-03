package cn.com.liu.test7;

import java.util.List;

import cn.com.liu.bean.ConditionUser;
import cn.com.liu.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cn.com.liu.bean.User;

/*
 * 测试: 动态SQL与模糊查询
 */
public class Test7 {

	public static void main(String[] args) {
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();
		
		String statement = "com.atguigu.day03_mybaits.test7.userMapper.getUser";
		
		String name = "o";
		name = null;
		
		ConditionUser parameter = new ConditionUser("%"+name+"%", 13, 18);
		List<User> list = session.selectList(statement, parameter);
		System.out.println(list);
		
		
		session.close();
	}
}
