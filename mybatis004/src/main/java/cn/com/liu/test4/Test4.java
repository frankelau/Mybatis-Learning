package cn.com.liu.test4;

import cn.com.liu.bean.Order;
import cn.com.liu.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/*
 * 测试:　解决字段名与实体类属性名不相同的冲突
 */
public class Test4 {

	public static void main(String[] args) {
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();
		
		String statement = "com.atguigu.day03_mybaits.test4.orderMapper.getOrder";
		statement = "com.atguigu.day03_mybaits.test4.orderMapper.getOrder2";
		Order order = session.selectOne(statement , 2);
		System.out.println(order);
	}
}
