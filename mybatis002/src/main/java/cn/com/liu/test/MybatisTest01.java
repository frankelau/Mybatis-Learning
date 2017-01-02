package cn.com.liu.test;

import cn.com.liu.entity.Student;
import cn.com.liu.mapper.query.StudentQueryMapper;
import cn.com.liu.mapper.update.StudentUpdateMapper;
import org.junit.Test;

/**
 * Created by liuzh on 2017/1/2.
 */
public class MybatisTest01 {

    @Test
    public void testQuery() {
        System.out.println(StudentQueryMapper.getInstance().selectStudentById(1));
    }
    @Test
    public void testQueryList() {
        Student student = new Student();
//        student.setStudentid(1);
//        student.setStudentage(22);
//        student.setStudentname("刘钊");
        System.out.println(StudentQueryMapper.getInstance().selectList(student));
    }

    @Test
    public void testUpdate() {
        Student student = new Student();
        student.setStudentid(1);
        student.setStudentage(22);
        student.setStudentname("刘钊");
        System.out.println(StudentUpdateMapper.getInstance().updateStudentById(student));
    }
    @Test
    public void testInsert() {
        Student student = new Student();
        student.setStudentid(5);
        student.setStudentage(22);
        student.setStudentname("刘钊");
        student.setStudentphone("1560070");
        int count = StudentUpdateMapper.getInstance().insertStudent(student);
        System.out.println(count);
    }
}
