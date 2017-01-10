package cn.com.liu.service.impl;

import cn.com.liu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import cn.com.liu.dao.mapper.UserMapper;
import cn.com.liu.po.User;

/**
 * 
 * <p>Title: UserServiceImpl</p>
 * <p>Description: 用户管理</p>
 * <p>Company: www.itcast.com</p> 
 * @author	传智.燕青
 * @date	2014-12-18下午4:47:47
 * @version 1.0
 */
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public User findUserById(int id) throws Exception {
		
		//调用mapper查询用户信息
		return userMapper.findUserById(id);
	}

	@Override
	public void saveUser() throws Exception {
		//更新用户，保证执行成功的
		User user_update = new User();
		user_update.setId(10);
		user_update.setUsername("张老三");
		userMapper.updateUser(user_update);
		
		//插入用户，插入一个同名的用户，由于username的唯 一约束 ，插入错误 ，事务回滚
		User user_insert = new User();
		user_insert.setUsername("武松");
		userMapper.insertUser(user_insert);
		
	}

}
