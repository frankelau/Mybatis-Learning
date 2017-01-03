package cn.com.liu.mapper;

import java.util.List;
/*
 * 约定
 */
import cn.com.liu.MybatisReposity;
import cn.com.liu.bean.User;


@MybatisReposity
public interface UserMapper {

	void save(User user);

	void update(User user);

	void delete(int id);

	User findById(int id);

	List<User> findAll();

}
