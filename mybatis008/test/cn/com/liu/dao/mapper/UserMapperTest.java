package cn.com.liu.dao.mapper;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.com.liu.po.User;

public class UserMapperTest {

	private ApplicationContext applicationContext;

	@Before
	public void setUp() throws Exception {

		applicationContext = new ClassPathXmlApplicationContext(new String[] {
				"spring/spring.xml"
		});
	}

	@Test
	public void testFindUserById() throws Exception {
		// 从spring容器中获取userdao
		UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");

		User user = userMapper.findUserById(10);
		System.out.println(user);
	}

}
