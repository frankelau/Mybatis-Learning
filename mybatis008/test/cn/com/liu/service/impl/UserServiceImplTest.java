package cn.com.liu.service.impl;

import cn.com.liu.po.User;
import cn.com.liu.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceImplTest {

	private ApplicationContext applicationContext;

	@Before
	public void setUp() throws Exception {

		applicationContext = new ClassPathXmlApplicationContext(new String[] {
                "spring/spring.xml"
		});
	}

	@Test
	public void testFindUserById() throws Exception {
		
		UserService userService = (UserService) applicationContext.getBean("userService");
		
		User user = userService.findUserById(10);
		System.out.println(user);
	}
	//测试事务
	@Test
	public void testSaveUser() throws Exception {
		
		UserService userService = (UserService) applicationContext.getBean("userService");
		
		userService.saveUser();
	}

}
