package cn.com.liu.test;

import java.util.Date;

import cn.com.liu.bean.User;
import cn.com.liu.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-beans.xml") //加载配置
public class SMTest {
    private static final Logger logger = LoggerFactory.getLogger("SMTest");
    @Autowired
    private UserMapper userMapper;


    @Test
    public void testAdd() {

        User user = new User(1, "tom", new Date(), 1234);
        try {
            userMapper.save(user);
        } catch (Exception e) {
            logger.error("插入发生异常", e);
        }

        try {
            int id = user.getId();
            System.out.println(id);
        } catch (Exception e) {
            logger.error("查询发生异常", e);
        }
    }


    @Test
    public void testQuery(){
        try {
            User user = userMapper.findById(1);
            System.out.println(user);
        } catch (Exception e) {
            logger.error("查询发生异常", e);
        }

    }
}
