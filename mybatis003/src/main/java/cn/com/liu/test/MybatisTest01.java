package cn.com.liu.test;

import cn.com.liu.entity.Student;
import cn.com.liu.mapper.BaseQueryMapper;
import cn.com.liu.mapper.BaseUpdateMapper;
import cn.com.liu.mapper.query.StudentQueryMapper;
import cn.com.liu.mapper.update.StudentUpdateMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by liuzh on 2017/1/2.
 */
public class MybatisTest01 {
    private static BaseQueryMapper<Student> studentQueryMapper;
    private static BaseUpdateMapper<Student> studentUpdateMapper;

    static {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        studentQueryMapper = (StudentQueryMapper) ac.getBean("studentQueryMapper");
        studentUpdateMapper = (StudentUpdateMapper) ac.getBean("studentUpdateMapper");
    }

    @Test
    public void testQuery() {
        System.out.println(studentQueryMapper.selectOne(1));
    }

    @Test
    public void testQueryList() {
        Student student = new Student();
        System.out.println(studentQueryMapper.selectList(student));
    }

    @Test
    public void testUpdate() {
        Student student = new Student();
        student.setStudentid(1);
        student.setStudentage(22);
        student.setStudentname("杨宗纬");
        System.out.println(studentUpdateMapper.updateById(student));
    }

    @Test
    public void testInsert() {
        Student student = new Student();
        student.setStudentid(6);
        student.setStudentage(22);
        student.setStudentname("小沈阳");
        student.setStudentphone("1560070");
        int count = studentUpdateMapper.insert(student);
        System.out.println(count);
    }
}
